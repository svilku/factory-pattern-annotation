package org.design.services;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import org.design.Notification;
import org.design.annotation.NotificationAnnotation;
import org.design.enums.NotificationType;

@NotificationAnnotation(notification_type = NotificationType.SMS)
@ApplicationScoped
//@Unremovable
public class SMSNotification implements Notification {
    @Override
    public NotificationType notifyUser() {
        System.out.println("user: SMS");
        return NotificationType.SMS;

    }
}
