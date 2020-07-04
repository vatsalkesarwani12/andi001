package e.vatsalkesarwani.intentsndservices.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import e.vatsalkesarwani.intentsndservices.R;

public class SystemIntent extends AppCompatActivity implements View.OnClickListener {

    Button call, map, alarm, email, dailog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_intent);

        /*Toolbar toolbar=findViewById(R.id.toolbar);
        setActionBar(toolbar);*/

        alarm = findViewById(R.id.button9);
        map = findViewById(R.id.button10);
        email = findViewById(R.id.button11);
        call = findViewById(R.id.button12);
        dailog = findViewById(R.id.button13);

        alarm.setOnClickListener(this);
        map.setOnClickListener(this);
        email.setOnClickListener(this);
        call.setOnClickListener(this);
        dailog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button9:
                String mes = "Time to wake up";
                final int hour = 2;
                final int min = 1;
                Intent intent3 = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent3.putExtra(AlarmClock.EXTRA_MESSAGE, mes);
                intent3.putExtra(AlarmClock.EXTRA_HOUR, hour);
                intent3.putExtra(AlarmClock.EXTRA_MINUTES, min);
                intent3.putExtra(AlarmClock.EXTRA_VIBRATE, true);
                if (intent3.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent3);
                }
                break;
            case R.id.button10:
                String location = "37.4220,-122.0481";//display coordinated location
                // location="0,?q=37.4220,-122.0841(Google Plex)"    display the given coordinate with Google plex
                // location="0,0?q=20+W+34th+St+10001"       display the given address
                // location="47.205,-122.3493?q=restaurants"   find nearby restaurants of the given coordinates
                Uri geoloc = Uri.parse("geo:" + location);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(geoloc);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                break;

            case R.id.button11:
                String mailmssg = "This is the message";
                String add[] = {"test@gmail.com"};
                String ccs[] = {"user@gmail.com"};
                String topic = "Topic";
                String subject = "subject";
                Intent intent5 = new Intent(Intent.ACTION_SENDTO);
                Uri emailuri = Uri.parse("mailto:");
                intent5.setData(emailuri);
                intent5.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent5.putExtra(Intent.EXTRA_EMAIL, add);
                intent5.putExtra(Intent.EXTRA_CC, ccs);
                intent5.putExtra(Intent.EXTRA_TEXT, mailmssg);
                if (intent5.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent5);
                }
                break;

            case R.id.button12:
                Intent intent4 = new Intent(Intent.ACTION_CALL);
                Uri urinum = Uri.parse("tel:" + "9473704638");
                intent4.setData(urinum);
                if (intent4.resolveActivity(getPackageManager()) != null) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    startActivity(intent4);
                }
                break;

            case R.id.button13:
                startActivity(new Intent(getApplicationContext(),Dailogs.class));
                break;
        }
    }
}
