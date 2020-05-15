package e.vatsalkesarwani.intentsndservices.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import e.vatsalkesarwani.intentsndservices.R;

public class Dailogs extends AppCompatActivity implements View.OnClickListener {
    Button simpleDailog,customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailogs);

        simpleDailog=findViewById(R.id.button14);
        customDialog=findViewById(R.id.button15);

        simpleDailog.setOnClickListener(this);
        customDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.button14:
                smplDailog();
                break;

            case R.id.button15:
                customDialog();
                break;
        }
    }

    private void customDialog() {
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom);
        dialog.setCancelable(false);
        Button b=dialog.findViewById(R.id.customButton);
        TextView t=dialog.findViewById(R.id.customText);
        t.setText("This is a custom dialog box");
        dialog.show();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dailogs.this, "custom dialog back button pressed", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

    private void smplDailog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Hello this is a simple dialog with a positive and a negative button");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Dailogs.this, "Yes", Toast.LENGTH_SHORT).show();
            }
        })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Dailogs.this, "No", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
