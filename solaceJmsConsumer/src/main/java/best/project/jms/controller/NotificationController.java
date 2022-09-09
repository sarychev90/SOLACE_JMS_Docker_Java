package best.project.jms.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import best.project.jms.model.Notification;
import best.project.jms.service.NotificationReceiver;

@RestController
@RequestMapping(path = "/api/notifications", produces = "application/json")
public class NotificationController {
	
	private static final Logger LOG = Logger.getLogger(NotificationController.class.getName());
	
	private NotificationReceiver messageService;

	@Autowired
	public NotificationController(NotificationReceiver messageService) {
		this.messageService = messageService;
	}

	@GetMapping(consumes = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	public Notification getNotification() {
		Notification notification = messageService.receiveNotification();
		LOG.log(Level.INFO, notification.toString());
		return notification;
	}
}
