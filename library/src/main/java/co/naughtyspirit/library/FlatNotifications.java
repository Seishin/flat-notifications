package co.naughtyspirit.library;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import co.naughtyspirit.library.interfaces.FlatNotificationsAPI;

/**
 * * Created by Seishin <atanas@naughtyspirit.co>
 * * on 3/21/15.
 * *
 * * NaughtySpirit 2015
 */
public class FlatNotifications implements FlatNotificationsAPI {
    private static final String TAG = FlatNotifications.class.getName();

    private Activity activity;

    private String message;

    private FlatNotifications(Builder builder) {
        this.activity = builder.activity;
        this.message = builder.msg;
    }

    @Override
    public void setMessage(String msg) {
        this.message = msg;
    }

    @Override
    public void show() {
        Intent intent = new Intent(activity, NotificationActivity.class);
        intent.putExtra("msg", message);
        activity.startActivity(intent);
    }

    public static class Builder {

        private Activity activity;
        private String msg;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        public Builder setMessage(String msg) {
            this.msg = msg;
            return this;
        }

        public FlatNotifications build() {
            return new FlatNotifications(this);
        }
    }
}
