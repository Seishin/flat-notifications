package co.naughtyspirit.library;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import co.naughtyspirit.library.fragments.NotificationFragment;
import co.naughtyspirit.library.interfaces.OnFragmentClose;

/**
 * * Created by Seishin <atanas@naughtyspirit.co>
 * * on 3/21/15.
 * *
 * * NaughtySpirit 2015
 */
public class NotificationActivity extends FragmentActivity implements OnFragmentClose {

    private static final String TAG = NotificationActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        NotificationFragment fragment = new NotificationFragment();
        fragment.setArguments(getIntent().getExtras());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, "notification")
                .addToBackStack("notification")
                .commit();
    }

    @Override
    public void onClose() {
        this.finish();
    }
}
