package com.timmony.notification.test;

import android.app.Activity;
import android.support.v4.app.NotificationCompat;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener{

    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View v){
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.ic_noti_large);
        Intent intent = new Intent();
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat noti;
        noti = new NotificationCompat.Builder(this)
                .setTicker("Your NetCode to authorise the payment of $200.00 to BSB 062000 Account number ****1234 is 123456.")
                .setContentTitle("CommBank app")
                .setContentText("Your NetCode to authorise the payment of $200.00 to BSB 062000 Account number ****1234 is 123456.")
                .setSmallIcon(R.drawable.ic_notifi_small)
                .setStyle(new NotificationCompat.BigTextStyle()
                .bigText("Your NetCode to authorise the payment of $200.00 to BSB 062000 Account number ****1234 is 123456."))
                //.setDefaults(NotificationCompat.DEFAULT_ALL)
                .setLargeIcon(bm)
                .setContentIntent(pIntent).build();
        //noti.largeIcon=bm;
        //noti.flags=NotificationCompat.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, noti);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
