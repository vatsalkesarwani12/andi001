package e.vatsalkesarwani.intentsndservices.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import e.vatsalkesarwani.intentsndservices.R;

public class MainActivity extends AppCompatActivity {

    private Button button;
    //private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Just Java");*/

        button= findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        /*spinner=(Spinner)findViewById(R.id.spin);
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);*/
    }

    int a=0;
    boolean hasWhipp=false;
    boolean haschoc=false;

    void openActivity()
    {
        Intent intent =new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void plu(View view) {
        a++;
        display();
    }

    public void min(View view) {
        if(a==0)
        {
            Toast.makeText(this,"not allowed",Toast.LENGTH_SHORT).show();
        }
        else a--;
        display();
    }
    public void display()
    {
        TextView tt=(TextView) findViewById(R.id.update);
        tt.setText(""+a);
    }

    public void submit(View view) {

        int x=0;
        int y=0;
        EditText name=(EditText) findViewById(R.id.name);
        String val=name.getText().toString();
        System.out.println(val);
       // Log.v("MainActivity",val+"\n");

        CheckBox whipped =(CheckBox) findViewById(R.id.wc) ;
        hasWhipp =whipped.isChecked();
        //Log.v("MainActivity",""+hasWhipp);
        if(hasWhipp)
            x=5;

        CheckBox chocho =(CheckBox) findViewById(R.id.ch) ;
        haschoc =chocho.isChecked();
        //Log.v("MainActivity",""+haschoc);
        if(haschoc)
            y=10;

        TextView t=(TextView) findViewById(R.id.summ);
        int z=a*10+x+y;
        if(a==0)
            z=0;
        //Toast.makeText(this,"thanks for the vist",Toast.LENGTH_SHORT).show();
        t.setText(""+val+"\nWhipped Cream "+hasWhipp+"\nChocolate "+haschoc+"\nQuantity : "+a+"\nTotal : "+z+"\nThank u.....");
    }
}
