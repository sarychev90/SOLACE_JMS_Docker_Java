package best.project.jms.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import best.project.jms.model.Notification;

@Service
public class JmsNotificationPushReceiver {
	
	private static final Logger LOG = Logger.getLogger(JmsNotificationPushReceiver.class.getName());
	
	@JmsListener(destination = "${solace.jms.queue}")
	public void receiveNotification(Notification notification) {
		LOG.log(Level.INFO, "receive notification: {0}", notification.toString());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			LOG.log(Level.SEVERE, "exception while interrupted thread sleep while receiving notification: " + notification, e);
		}
	}
}
