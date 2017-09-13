

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listPosts")
public class ListPosts extends HttpServlet {
	
	private static final long		serialVersionUID	= 1L;
	static String			url		= "jdbc:mysql://nhippen.ddns.net:3306/myDB";
	static String			user		= "nhippen";
	static String			password		= "password";
	static Connection			connection	= null;

	public ListPosts() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
		connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		if (connection != null) {
		} else {
			System.out.println("Failed to make connection!");
		}
		try {
			String selectSQL = "SELECT * FROM FORUM_POSTS";
//			String theUserName = "nhippen";
			PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
//			preparedStatement.setString(1, theUserName);
			ResultSet rs = preparedStatement.executeQuery();
			StringBuilder json = new StringBuilder();
			json.append("[");
			while (rs.next()) {
				String postId = rs.getString("POST_ID");
				String userId = rs.getString("USER_ID");
				String postTitle = rs.getString("POST_TITLE");
				String postBody = rs.getString("POST_BODY");
				json.append("{")
					.append("\"postId\":").append(postId).append(",")
					.append("\"userId\":\"").append(userId).append("\",")
					.append("\"title\":\"").append(postTitle).append("\",")
					.append("\"body\":\"").append(postBody).append("\"")
					.append("},");
				
//				response.getWriter().append("POST ID: " + postId + ", ");
//				response.getWriter().append("USER ID: " + userId + ", ");
//				response.getWriter().append("TITLE: " + postTitle + ", ");
//				response.getWriter().append("BODY: " + postBody + "<br>");
			}
			json.deleteCharAt(json.length() - 1)
				.append("]");
			out.append(json);
			out.flush();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
