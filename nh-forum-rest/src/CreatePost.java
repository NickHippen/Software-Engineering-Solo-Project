

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createPost")
public class CreatePost extends HttpServlet {
	
	private static final long		serialVersionUID	= 1L;
	static String			url		= "jdbc:mysql://nhippen.ddns.net:3306/myDB";
	static String			user		= "nhippen";
	static String			password		= "password";
	static Connection			connection	= null;

	public CreatePost() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String userId = request.getParameter("userId");
		if (title == null || body == null || userId == null || title.isEmpty() || body.isEmpty() || userId.isEmpty()) {
			System.out.println("Missing or invalid params");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
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
			String selectSQL = "INSERT INTO FORUM_POSTS (USER_ID, POST_TITLE, POST_BODY) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, body);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
