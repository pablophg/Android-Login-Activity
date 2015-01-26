package net.pablophg.activitynav;

import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Button;


public class DisplayMessageActivity extends ActionBarActivity {

    final static String DEBUG_TAG = "Motion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        //getActionBar().setDisplayHomeAsUpEnabled(false); // manage transition

        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_USERNAME);
        String password = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_PASSWORD);
        Log.e("Username:", username);
        Log.e("Password:", password);
        setTitle("User: "+username);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getSupportFragmentManager().popBackStackImmediate();
        overridePendingTransition(R.anim.slideback2, R.anim.slideback);
        finish();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        switch (item.getItemId()) {
            case android.R.id.home:
                //overridePendingTransition(R.anim.slide2, R.anim.slide);
                Log.e("Info", "Home button clicked");
               // return true;
                //getSupportFragmentManager().popBackStackImmediate();
                onBackPressed(); // This is the graphical button on top left corner (over action bar)
                //finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
