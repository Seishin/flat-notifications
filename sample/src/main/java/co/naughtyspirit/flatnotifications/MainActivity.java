package co.naughtyspirit.flatnotifications;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import co.naughtyspirit.library.FlatNotifications;

/**
 * * Created by Seishin <atanas@naughtyspirit.co>
 * * on 3/21/15.
 * *
 * * NaughtySpirit 2015
 */
public class MainActivity extends FragmentActivity {

    private FlatNotifications notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        showNotification();
    }

    private void initUI() {
        Button showNotificationBtn = (Button) findViewById(R.id.show_notification);
        showNotificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifications.setMessage("New notification...");
                notifications.setBackgroundColor(Color.GREEN);
                notifications.setTextColor(Color.RED);
                notifications.show();
            }
        });
    }

    private void showNotification() {
        notifications = new FlatNotifications.Builder(this)
                .setMessage("Hello, world!")
                .build();
        notifications.show();
    }
}
