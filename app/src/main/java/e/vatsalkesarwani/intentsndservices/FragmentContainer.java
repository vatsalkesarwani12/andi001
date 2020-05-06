package e.vatsalkesarwani.intentsndservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentContainer extends AppCompatActivity {

    private SimpleBlankFragment simpleBlankFragment;
    private Button add,remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);

        add=findViewById(R.id.add);
        remove=findViewById(R.id.remove);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Bundle bundle= new Bundle();
//                bundle.putString(SimpleBlankFragment.MESSAGE_KEY,"This is the the passed message");
//                simpleBlankFragment.setArguments(bundle);
                simpleBlankFragment = SimpleBlankFragment.newInstance("This is the the factory passed message");
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container,simpleBlankFragment)
                        .commit();
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                getSupportFragmentManager()
                        .beginTransaction()
                        .remove(fragment)
                        .commit();
            }
        });
    }


}
