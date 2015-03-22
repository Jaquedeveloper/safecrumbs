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
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    final String preferenceName = "MyPreferenceFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button_enter);
        checkLogging();

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SharedPreferences settings = getSharedPreferences(preferenceName, 0);
                boolean isFirstTime2 = settings.getBoolean("isFirstTime", true);
                final int request_code = 1010;
                startActivityForResult(new Intent(MainActivity.this,ContactPicker.class),request_code);
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
        if(isFirstTime) {
            settings.edit().putBoolean("isFirstTime", false).commit();
            int request_code = 1010;
        }else{
            Intent i = new Intent(this,main_911.class);
            startActivity(i);
            finish();
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

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);


        if(resultCode==RESULT_OK && !data.getExtras().isEmpty() && data.getExtras().containsKey("selectedContacts"))
        {

            Object[] objArray = (Object[])data.getExtras().getSerializable("selectedContacts");
            String selectedContacts[][]=null;
            if(objArray!=null)
            {
                selectedContacts = new String[objArray.length][];
                for(int i=0;i<objArray.length;i++)
                {
                    selectedContacts[i] = (String[]) objArray[i];
                }
                //Now selectedContacts[] contains the selected contacts
            }

            for(int j=0; j<= selectedContacts.length; j++){
                buildAlertDialog("saved",selectedContacts[j].toString());
            }


        }

    }

}
