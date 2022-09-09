package best.project.jms.service;

import best.project.jms.model.Notification;

public interface NotificationMessagingService {

	void sendNotification(Notification notification);

}