package best.project.jms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import best.project.jms.model.Notification;
import best.project.jms.service.NotificationMessagingService;

@RestController
@RequestMapping(path = "/api/notifications", produces = "application/json")
public class NotificationController {
	
	private NotificationMessagingService messageService;

	@Autowired
	public NotificationController(NotificationMessagingService messageService) {
		this.messageService = messageService;
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	public Notification postNotification(@RequestBody Notification notification) {
		messageService.sendNotification(notification);
		return notification;
	}
}
