import java.util.ArrayList;
import java.util.List;

public class ForumPost {

	private String postId;
	private String userId;
	private String title;
	private String body;
	private List<PostComment> comments = new ArrayList<>();

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<PostComment> getComments() {
		return comments;
	}

	public void setComments(List<PostComment> comments) {
		this.comments = comments;
	}
	
	public void addComment(PostComment comment) {
		this.comments.add(comment);
	}
	
	public String toJson() {
		StringBuilder json = new StringBuilder();
		json.append("{")
			.append("\"postId\":").append(getPostId()).append(",")
			.append("\"userId\":\"").append(getUserId()).append("\",")
			.append("\"title\":\"").append(getTitle()).append("\",")
			.append("\"body\":\"").append(getBody()).append("\",")
			.append("\"comments\":[");
		for (PostComment comment : comments) {
			json.append(comment.toJson()).append(",");
		}
		if (!comments.isEmpty()) {
			json.deleteCharAt(json.length() - 1);
		}
		json.append("]}");
		return json.toString();
	}

}
