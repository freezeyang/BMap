package notifications;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
/**
 * Created by yin on 4/7/18.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService{
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        //if the message contains data payload
        //It is a map of custom keyvalues
        //we can read it easily
        if(remoteMessage.getData().size() > 0){
            //handle the data message here
            //getting the title and the body

            //Constants.TEXT=remoteMessage.getNotification().getBody();
        }
        String title = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();
        MyNotificationManager.getInstance(this).displayNotification(title, body);
        Constants.TEXT=remoteMessage.getNotification().getBody();

        //then here we can use the title and body to build a notification
    }
}
