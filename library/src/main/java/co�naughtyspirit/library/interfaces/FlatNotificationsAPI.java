package co.naughtyspirit.library.interfaces;

/**
 * * Created by Seishin <atanas@naughtyspirit.co>
 * * on 3/21/15.
 * *
 * * NaughtySpirit 2015
 */
public interface FlatNotificationsAPI {

    public void setMessage(String msg);
    public void setBackgroundColor(int color);
    public void setBackgroundColor(String color);
    public void setTextColor(int color);
    public void setTextColor(String color);
    public void show();
}
