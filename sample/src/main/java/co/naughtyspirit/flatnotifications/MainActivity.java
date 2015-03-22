package co.naughtyspirit.flatnotifications;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import co.naughtyspirit.library.FlatNotifications;

/**
 * * Created by Seishin <atanas@naughtyspirit.co>
 * * on 3/21/15.
 * *
 * * NaughtySpirit 2015
 */
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlatNotifications notifications = new FlatNotifications.Builder(this)
                .setMessage("Hello, world!")
                .build();
        notifications.show();

    }
}
