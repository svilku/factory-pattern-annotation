package org.design;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.design.enums.NotificationType;
import org.design.services.NotificationFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

@QuarkusTest
public class NotificationTest {

    @Inject
    NotificationFactory notificationFactory;

    @Test
    public void notificationAnnotationTest() throws Exception {
        String type = notificationFactory.getNotificationType(NotificationType.EMAIL)
                .doSomethingWithNotification();

        Assert.assertTrue(type.contains("EMAIL"));
    }

    @Test
    @Disabled
    public void notificationAnnotationByStrategyTest() {
        String type = notificationFactory.getNotificationTypeInstance(NotificationType.SMS)
                .doSomethingWithNotification();

        Assert.assertTrue(type.contains("SMS"));
    }
}
