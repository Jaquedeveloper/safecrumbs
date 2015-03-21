package hackfsu.safecrumbs;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkLogging();
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

    Button call_911 = (Button) findViewById(R.id.callButton);
    call_911.setOnClickListerner(new View.onClickListener()
        {
        public void onClick (View v){
        Intent i = new Intent(Intent.ACTION_DIAL);
        String p = "tel:" + getString(R.string.phone_number);
        i.setData(Uri.parse(p));
        startActivity(i);
        }
    });

    public void checkLogging(){
        SharedPreferences settings = getSharedPreferences(preferenceName, 0);
        boolean isFirstTime = settings.getBoolean("isFirstTime", true);
        if (isFirstTime) {
            //Intent intent = new Intent(this, );
            Log.d("Comments", "First time");
            settings.edit().putBoolean("isFirstTime", false).commit();

        }else{
            //do something for other than first time
        }
    }
}
