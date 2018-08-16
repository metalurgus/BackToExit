package metalurgus.github.com.bact_to_exit.lib;

import android.support.v7.app.AppCompatActivity;

public abstract class BackToExitActivity extends AppCompatActivity {

    public int getDelay() {
        return BackPressedHandler.DEFAULT_DELAY;
    }

    public String getText() {
        return BackPressedHandler.DEFAULT_TEXT;
    }

    private BackPressedHandler backPressedHandler;

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            super.onBackPressed();
        } else {
            if (backPressedHandler == null) {
                backPressedHandler = new BackPressedHandler(getDelay(), getText());
            }
            backPressedHandler.onBackPressed(this);
        }
    }
}
