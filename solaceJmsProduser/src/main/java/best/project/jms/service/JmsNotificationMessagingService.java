package best.project.jms.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import best.project.jms.model.Notification;

@Service
public class JmsNotificationMessagingService implements NotificationMessagingService {
	
	private static final Logger LOG = Logger.getLogger(JmsNotificationMessagingService.class.getName());
	
	@Autowired
	private JmsTemplate jms;
	
	@Value("${solace.jms.queue}")
	private String queueName;

	@Override
	public void sendNotification(Notification notification) {
		LOG.log(Level.INFO, "sending notification: {0}", notification.toString());
		jms.send(queueName, (session) -> session.createObjectMessage(notification));		
	}

}
