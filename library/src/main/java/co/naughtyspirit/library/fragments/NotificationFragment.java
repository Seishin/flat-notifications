package co.naughtyspirit.library.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import co.naughtyspirit.library.R;
import co.naughtyspirit.library.interfaces.OnFragmentClose;
import co.naughtyspirit.library.utils.Constants;

/**
 * * Created by Seishin <atanas@naughtyspirit.co>
 * * on 3/21/15.
 * *
 * * NaughtySpirit 2015
 */
public class NotificationFragment extends Fragment {

    private static final String TAG = NotificationFragment.class.getName();

    private FragmentActivity activity;
    private OnFragmentClose callback;

    private View view;
    private TextView messageTV;
    private RelativeLayout notificationLayout;

    private String message;
    private int bgColor;
    private int textColor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.message = getArguments().getString(Constants.KEY_MESSAGE);
        this.bgColor = getArguments().getInt(Constants.KEY_BG_COLOR);
        this.textColor = getArguments().getInt(Constants.KEY_TEXT_COLOR);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notification, container, false);

        initUI();

        return view;
    }

    private void initUI() {
        messageTV = (TextView) view.findViewById(R.id.notification_text);
        messageTV.setText(message);
        messageTV.setTextColor(textColor);

        notificationLayout = (RelativeLayout) view.findViewById(R.id.notification);
        notificationLayout.setBackgroundColor(bgColor);

        Button dismiss = (Button) view.findViewById(R.id.dismiss);
        dismiss.setTextColor(textColor);
        dismiss.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.getSupportFragmentManager().popBackStack();
            }
        });
    }

    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter) {
            Animation enterAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.alpha_in);
            enterAnim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    Animation notificationEnterAnim = AnimationUtils.loadAnimation(activity,
                            R.anim.slide_in_top_notification);
                    notificationEnterAnim.setFillAfter(true);
                    notificationLayout.startAnimation(notificationEnterAnim);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });

            return enterAnim;
        } else {
            Animation outAnim = AnimationUtils.loadAnimation(activity, R.anim.alpha_out);;

            notificationLayout.startAnimation(AnimationUtils.loadAnimation(activity,
                    R.anim.slide_out_top));

            return outAnim;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (FragmentActivity) activity;

        try {
            this.callback = (OnFragmentClose) activity;
        } catch (ClassCastException e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback.onClose();
    }
}
