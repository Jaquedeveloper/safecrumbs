package hackfsu.safecrumbs;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.location.LocationListener;
import android.location.Location;
import android.location.LocationManager;
import android.content.Context;
import android.view.View;
import android.telephony.SmsManager;
import android.content.SharedPreferences;


public class alert_setup extends ActionBarActivity {
    String message;
    int alert_time;
    Button alert_mode_button;
    Button go_back;
    final String agenda = "agenda";

    double lat;
    double lon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD

        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 5000, 10, this);


=======
>>>>>>> 1972febbdabf55afbeb6c775ab427f66f801439f
        setContentView(R.layout.activity_alert_setup);
        alert_mode_button = (Button) findViewById(R.id.alert_mode_button);
        go_back = (Button) findViewById(R.id.go_back_button);


        alert_mode_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("8506612415", null, message, null, null);
                /*smsManager.sendTextMessage("1111111111", null, message, null, null);
                smsManager.sendTextMessage("2222222222", null, message, null, null);
                smsManager.sendTextMessage("3333333333", null, message, null, null);
                smsManager.sendTextMessage("44444444444", null, message, null, null);*/
                Intent intent = new Intent(alert_setup.this, alert_on.class);
                alert_setup.this.startActivity(intent);

            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alert_setup, menu);
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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.uneasy:
                if (checked)
                    message = "I'm feeling uneasy";
                    break;
            case R.id.unsafe:
                if (checked)
                    message = "I'm feeling unsafe";
                    break;
            case R.id.in_danger:
                if (checked)
                    message = "I'm in danger!!";
                    break;
            case R.id.alert_30:
                if(checked)
                    alert_time = 30;
                    break;
            case R.id.alert_1hr:
                if(checked)
                    alert_time = 60;
                    break;
        }
    }
}
