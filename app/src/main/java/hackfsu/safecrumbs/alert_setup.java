package hackfsu.safecrumbs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.location.LocationListener;
import android.location.Location;
import android.location.LocationManager;
import android.content.Context;

public class alert_setup extends ActionBarActivity implements LocationListener {
    String message;
    int alert_time;
    Button alert_mode_button;
    Button go_back;
    double lat;
    double lon;
    @Override
    public void onProviderDisabled(String provider) {}

    @Override
    public void onProviderEnabled(String provider) {}
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}

    public void onLocationChanged(Location loc) {
        lat = loc.getLatitude();
        lon = loc.getLongitude();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 5000, 10, this);


        setContentView(R.layout.activity_alert_setup);

        alert_mode_button = (Button) findViewById(R.id.alert_mode_button);
        go_back = (Button) findViewById(R.id.go_back_button);

        alert_mode_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String lat2 = Double.toString(lat);
                String long2 = Double.toString(lon);
                message = "";

                message += "Coordinates are (";
                message += lat2;
                message += " , ";
                message += long2;
                message += ")";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("4048631374", null, message, null, null);
                /*smsManager.sendTextMessage("1111111111", null, message, null, null);
                smsManager.sendTextMessage("2222222222", null, message, null, null);
                smsManager.sendTextMessage("3333333333", null, message, null, null);
                smsManager.sendTextMessage("44444444444", null, message, null, null);*/
                Intent intent = new Intent(alert_setup.this, alert_on.class);
                alert_setup.this.startActivity(intent);

            }

        });
        go_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(alert_setup.this, main_911.class);
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
