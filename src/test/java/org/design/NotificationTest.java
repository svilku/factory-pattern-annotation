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
        NotificationType type = notificationFactory.getNotificationType(NotificationType.EMAIL)
                .notifyUser();

        Assert.assertTrue(type.equals(NotificationType.EMAIL));
    }

    @Test
    @Disabled
    public void notificationAnnotationByStrategyTest() {
        NotificationType type = notificationFactory.getNotType(NotificationType.SMS)
                .notifyUser();

        Assert.assertTrue(type.equals(NotificationType.SMS));
    }
}
