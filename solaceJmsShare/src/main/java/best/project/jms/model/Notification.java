package best.project.jms.model;

import java.io.Serializable;

public class Notification implements Serializable {

	private static final long serialVersionUID = 205503946282579612L;
	
	private String topic;
	private String message;
	
	public Notification() {
		//
	}
	
	public Notification(String topic, String message) {
		this.topic = topic;
		this.message = message;
	}
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Notification [topic=" + topic + ", message=" + message + "]";
	}

}
