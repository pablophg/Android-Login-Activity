package net.pablophg.activitynav;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.heinrichreimersoftware.materialdrawer.DrawerFrameLayout;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerItem;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerProfile;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE_USERNAME = "net.pablophg.activitynav.USERNAME";
    public final static String EXTRA_MESSAGE_PASSWORD = "net.pablophg.activitynav.PASSWORD";
/*
    public void postData() {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://google.com");
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("id", "12345"));
            nameValuePairs.add(new BasicNameValuePair("stringdata", "thisisastring"));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            String strresult = response.toString();
            Log.e("result", strresult);

        }catch(ClientProtocolException e){

        }catch(IOException e){

        }
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button nav_btn = (Button) findViewById(R.id.buttonLogin);

        final EditText username = (EditText) findViewById(R.id.editText11);
        final EditText password = (EditText) findViewById(R.id.editText12);

        nav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username_input = username.getText().toString();
                String password_input = password.getText().toString();

                Intent intent = new Intent(v.getContext(), DisplayMessageActivity.class);
                intent.putExtra(EXTRA_MESSAGE_USERNAME, username_input);
                intent.putExtra(EXTRA_MESSAGE_PASSWORD, password_input);
                startActivity(intent);

                //finish();

                overridePendingTransition(R.anim.slide2, R.anim.slide);
            }
        });

       //postData();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

        return super.onOptionsItemSelected(item);
    }
}
