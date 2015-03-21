package hackfsu.safecrumbs;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.SharedPreferences;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.util.Log;


public class MainActivity extends ActionBarActivity {
    final String preferenceName = "MyPreferenceFile";
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.enter);
        //checkLogging();
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                SharedPreferences settings = getSharedPreferences(preferenceName, MODE_PRIVATE);
                boolean isFirstTime = settings.getBoolean("isFirstTime", true);
                if(isFirstTime) {
                    settings.edit().putBoolean("isFirstTime", false).commit();
                    Intent intent = new Intent(MainActivity.this, main_911.class);
                    MainActivity.this.startActivity(intent);
                } else {
                    Intent intent = new Intent();
                }
            }

        });
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

    public void checkLogging(){
        SharedPreferences settings = getSharedPreferences(preferenceName, 0);
        boolean isFirstTime = settings.getBoolean("isFirstTime", true);
        if (isFirstTime) {
            Log.d("Comments", "First time");
            settings.edit().putBoolean("isFirstTime", false).commit();
            Intent intent = new Intent(MainActivity.this, main_911.class);
            MainActivity.this.startActivity(intent);

        }else{
            Intent intent = new Intent("com.Android.main_911");
        }
    }
}
