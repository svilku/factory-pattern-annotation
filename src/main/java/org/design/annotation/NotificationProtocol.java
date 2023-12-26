package org.design.annotation;

import jakarta.enterprise.util.AnnotationLiteral;
import lombok.AllArgsConstructor;
import org.design.enums.NotificationType;

@AllArgsConstructor
public class NotificationProtocol extends AnnotationLiteral<NotificationAnnotation> implements NotificationAnnotation {
    private final NotificationType type;

    @Override
    public NotificationType notification_type() {
        return this.type;
    }
}
