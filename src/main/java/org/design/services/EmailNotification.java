package org.design.services;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import org.design.Notification;
import org.design.annotation.NotificationAnnotation;
import org.design.enums.NotificationType;

@NotificationAnnotation(notification_type = NotificationType.EMAIL)
@ApplicationScoped
//@Unremovable
public class EmailNotification implements Notification {

    @Override
    public NotificationType notifyUser() {
        System.out.println("user: Email");
        return NotificationType.EMAIL;
    }
}
