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
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import android.content.DialogInterface;


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

    public void checkLogging(){
        SharedPreferences settings = getSharedPreferences(preferenceName, 0);

        //
        boolean isFirstTime = settings.getBoolean("isFirstTime", true);
        if (isFirstTime) {
            buildAlertDialog("Shared",Boolean.toString(isFirstTime));
            settings.edit().putBoolean("isFirstTime", false).commit();
            final int request_code = 1010;
            //startActivityForResult(new Intent(this,ContactPicker.class),request_code);
            // Intent intent = new Intent("com.Android.main_911");
            //startActivity(intent);
        }else{
            buildAlertDialog("Shared",Boolean.toString(isFirstTime));
//            settings.edit().putBoolean("isFirstTime", false).commit();
//            final int request_code = 1010;
//            startActivityForResult(new Intent(this,ContactPicker.class),request_code);
        }
    }

    public void buildAlertDialog(String title,String message){
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(message)
                .setTitle(title)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
