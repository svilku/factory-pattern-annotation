package org.design.annotation;

import jakarta.inject.Qualifier;
import org.design.enums.NotificationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NotificationAnnotation {
    NotificationType notification_type();
}
