public class PostComment {

	private String comId;
	private String userId;
	private String body;

	public String getComId() {
		return comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public String toJson() {
		StringBuilder json = new StringBuilder();
		json.append("{")
			.append("\"comId\":\"").append(getComId()).append("\",")
			.append("\"userId\":\"").append(getUserId()).append("\",")
			.append("\"body\":\"").append(getBody()).append("\"")
			.append("}");
		return json.toString();
	}

}
