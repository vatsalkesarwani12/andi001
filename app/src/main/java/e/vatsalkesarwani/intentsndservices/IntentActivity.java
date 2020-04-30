package e.vatsalkesarwani.intentsndservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {

    Button c,u,cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setActionBar(toolbar);

        c=findViewById(R.id.button4);
        u=findViewById(R.id.button5);
        cc=findViewById(R.id.button6);
        c.setOnClickListener(this);
        u.setOnClickListener(this);
        cc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.button4:
                Intent i=new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                if (i.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(i);
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
        }
    }
}
