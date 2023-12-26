package org.design.services;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;
import org.design.Notification;
import org.design.annotation.NotificationProtocol;
import org.design.enums.NotificationType;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class NotificationFactory {

    @Inject
    @Any
    private Instance<Notification> notificationInstance;

    public Notification getNotificationType(NotificationType type) throws Exception {
        Instance<Notification> instance = notificationInstance.select(new NotificationProtocol(type));
        if (!instance.isUnsatisfied()) {
            return instance.get();
        } else throw new Exception("Invalid Notification Type");
    }

    private static final Map<NotificationType, Notification> map = new EnumMap<>(NotificationType.class);

    //@PostConstruct
    public void prepareStrategy() {
        Instance<Notification> instance = CDI.current().select(Notification.class);
        instance.forEach(inst ->
                Optional.ofNullable(map.putIfAbsent(inst.notifyUser(), inst))
                        .ifPresent(ins -> {
                            throw new RuntimeException("Already defined");
                        }));
    }

    public Notification getNotType(NotificationType type) {
        return map.get(type);

    }
}
