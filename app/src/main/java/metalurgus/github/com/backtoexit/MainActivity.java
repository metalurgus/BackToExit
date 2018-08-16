package metalurgus.github.com.backtoexit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import metalurgus.github.com.bact_to_exit.lib.BackToExitActivity;

public class MainActivity extends BackToExitActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
