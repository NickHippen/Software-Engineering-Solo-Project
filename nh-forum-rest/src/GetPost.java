

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

@WebServlet("/post/*")
public class GetPost extends HttpServlet {
	
	private static final long		serialVersionUID	= 1L;
	static String			url		= "jdbc:mysql://nhippen.ddns.net:3306/myDB";
	static String			user		= "nhippen";
	static String			password		= "password";
	static Connection			connection	= null;

	public GetPost() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String[] pathSplit = request.getPathInfo().split("/");
		String postId = pathSplit[pathSplit.length - 1];
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
			String selectSQL = "SELECT P.*, C.COM_ID, C.USER_ID AS COM_USER_ID, C.COM_BODY FROM FORUM_POSTS P LEFT JOIN POST_COMMENTS C ON P.POST_ID = C.POST_ID WHERE P.POST_ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, postId);
			ResultSet rs = preparedStatement.executeQuery();
			ForumPost post = null;
			while (rs.next()) {
				if (post == null) {
					post = new ForumPost();
					String userId = rs.getString("USER_ID");
					String postTitle = rs.getString("POST_TITLE");
					String postBody = rs.getString("POST_BODY");
					post.setPostId(postId);
					post.setUserId(userId);
					post.setTitle(postTitle);
					post.setBody(postBody);
				}
				PostComment comment = new PostComment();
				String comId = rs.getString("COM_ID");
				if (comId != null) {
					comment.setComId(comId);
					comment.setUserId(rs.getString("COM_USER_ID"));
					comment.setBody(rs.getString("COM_BODY"));
					post.addComment(comment);
				}
			}
			if (post == null) {
				System.out.println("Invalid post id");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
			out.append(post.toJson());
			out.flush();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
