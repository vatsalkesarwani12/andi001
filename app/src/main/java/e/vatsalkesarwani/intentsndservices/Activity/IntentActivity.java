package e.vatsalkesarwani.intentsndservices.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toolbar;

import e.vatsalkesarwani.intentsndservices.R;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {

    Button c,u,cc,sms,sysInt;
    ImageView imgView;
    final int REQUEST_CODE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setActionBar(toolbar);

        c=findViewById(R.id.button4);
        u=findViewById(R.id.button5);
        cc=findViewById(R.id.button6);
        sms=findViewById(R.id.button7);
        imgView=findViewById(R.id.imageView);
        sysInt=findViewById(R.id.button8);
        c.setOnClickListener(this);
        u.setOnClickListener(this);
        cc.setOnClickListener(this);
        sms.setOnClickListener(this);
        sysInt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.button4:
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (i.resolveActivity(getPackageManager())!=null)
                {
                    startActivityForResult(i,REQUEST_CODE);
                }
                break;
            case R.id.button5:
                String url="https://www.google.co.in/";
                Uri webpage=Uri.parse(url);
                Intent intent=new Intent(Intent.ACTION_VIEW,webpage);
                if (intent.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(intent);
                }
                break;
            case R.id.button6:
                String text="Copy it to the clip";
                Intent intent1=new Intent();
                intent1.setAction(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                intent1.putExtra(Intent.EXTRA_TEXT,text);
                if (intent1.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(intent1 );
                }
                break;
            case R.id.button7:
                String message="This is a text message";
                Intent intent2=new Intent(Intent.ACTION_SENDTO);
                intent2.setData(Uri.parse("sms:+99473704638"));
                intent2.putExtra("sms_body",message);
                if (intent2.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(intent2);
                }
                break;
            case R.id.button8:
                startActivity(new Intent(getApplicationContext(),SystemIntent.class));
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bitmapImage = (Bitmap) extras.get("data");
            imgView.setImageBitmap(bitmapImage);
        }
    }
}
