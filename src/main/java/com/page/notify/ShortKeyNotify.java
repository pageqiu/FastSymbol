package com.page.notify;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nullable;

public class ShortKeyNotify {

    private static final NotificationGroup NOTIFICATION_GROUP =
            new NotificationGroup("Custom Notification Group", NotificationDisplayType.BALLOON, true);

    public static void notifyInfo(@Nullable Project project, String content) {
        NOTIFICATION_GROUP.createNotification(content, NotificationType.INFORMATION)
                .notify(project);
    }

}
