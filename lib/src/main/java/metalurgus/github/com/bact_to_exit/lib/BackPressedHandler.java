package metalurgus.github.com.bact_to_exit.lib;

import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;


public class BackPressedHandler {
    public static final int DEFAULT_DELAY = 2000;
    public static final String DEFAULT_TEXT = "Press back again to exit";
    private static BackPressedHandler defaultInstance;

    private int delay;
    private ToastHelper toast;
    private String text;

    private long backPressed;

    /**
     * @return BackPressedHandler with default parameters: delay = 2000, text = "Press back again to exit"
     */
    public static BackPressedHandler defaultInstance() {
        if (defaultInstance == null) {
            defaultInstance = new BackPressedHandler();
        }
        return defaultInstance;
    }

    public BackPressedHandler() {
        delay = DEFAULT_DELAY;
        text = DEFAULT_TEXT;
    }

    public BackPressedHandler(int delay, String text) {
        this.delay = delay;
        this.text = text;
    }

    public void onBackPressed(Activity activity) {
        if (backPressed + delay > System.currentTimeMillis()) {
            activity.finish();
        } else {
            if (toast != null) {
                toast.cancel();
            }

            toast = ToastHelper.makeText(activity, text, delay);
            toast.setText(text);
            toast.show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (toast != null) {
                        toast.cancel();
                        toast = null;
                    }
                }
            }, delay);
        }
        backPressed = System.currentTimeMillis();
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BackPressedHandler delay(int delay) {
        this.delay = delay;
        return this;
    }

    public BackPressedHandler text(String text) {
        this.text = text;
        return this;
    }

}
