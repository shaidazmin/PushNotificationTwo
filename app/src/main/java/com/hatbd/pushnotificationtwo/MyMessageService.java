package com.hatbd.pushnotificationtwo;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyMessageService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
    }

    public void showNotification(String title,String message){

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this,"Notification")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_notification_icon)
                .setAutoCancel(true)
                .setContentText(message);

        NotificationManagerCompat managerCompat =  NotificationManagerCompat.from(this);
        managerCompat.notify(121,builder.build());
    }

}
