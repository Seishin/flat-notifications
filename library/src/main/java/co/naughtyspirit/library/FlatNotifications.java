package co.naughtyspirit.library;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;

import co.naughtyspirit.library.interfaces.FlatNotificationsAPI;
import co.naughtyspirit.library.utils.Constants;

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
    private int bgColor;
    private int textColor;

    private FlatNotifications(Builder builder) {
        this.activity = builder.activity;
        this.message = builder.msg;
        this.bgColor = (builder.bgColor > -1) ? builder.bgColor : activity.getResources().getColor(R.color.bg_primary);
        this.textColor = (builder.textColor > - 1) ? builder.textColor : Color.parseColor("#FFFFFF");
    }

    @Override
    public void setMessage(String msg) {
        this.message = msg;
    }

    @Override
    public void setBackgroundColor(String color) {
        this.bgColor = Color.parseColor(color);
    }

    @Override
    public void setTextColor(int color) {
        this.textColor = color;
    }

    @Override
    public void setTextColor(String color) {
        this.textColor = Color.parseColor(color);
    }

    @Override
    public void setBackgroundColor(int color) {
        this.bgColor = color;
    }

    @Override
    public void show() {
        Intent intent = new Intent(activity, NotificationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.putExtra(Constants.KEY_MESSAGE, message);
        intent.putExtra(Constants.KEY_BG_COLOR, bgColor);
        intent.putExtra(Constants.KEY_TEXT_COLOR, textColor);
        activity.startActivity(intent);
    }

    public static class Builder {

        private Activity activity;
        private String msg;
        private int bgColor = -1;
        private int textColor = -1;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        public Builder setMessage(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder setBackgroundColor(int color) {
            this.bgColor = color;
            return this;
        }

        public Builder setBackgroundColor(String color) {
            this.bgColor = Color.parseColor(color);
            return this;
        }

        public Builder setTextColor(int color) {
            this.textColor = color;
            return this;
        }

        public Builder setTextColor(String color) {
            this.textColor = Color.parseColor(color);
            return this;
        }

        public FlatNotifications build() {
            return new FlatNotifications(this);
        }
    }
}
