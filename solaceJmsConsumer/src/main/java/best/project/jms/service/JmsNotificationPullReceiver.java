package best.project.jms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import best.project.jms.model.Notification;

@Service
public class JmsNotificationPullReceiver implements NotificationReceiver {
	
	@Autowired
	private JmsTemplate jms;
	
	@Value("${solace.jms.queue}")
	private String queueName;

	@Override
	public Notification receiveNotification() {
		return (Notification) jms.receiveAndConvert(queueName);
	}

}
