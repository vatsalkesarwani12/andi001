package e.vatsalkesarwani.intentsndservices.Activity;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import e.vatsalkesarwani.intentsndservices.R;

public class SimpleBlankFragment extends Fragment {


    private static final String TAG = "Life";
    public static final String  MESSAGE_KEY = "message" ;

    public SimpleBlankFragment() {
        // Required empty public constructor
    }

    public static SimpleBlankFragment newInstance(String message) {

        Bundle args = new Bundle();
        args.putString(SimpleBlankFragment.MESSAGE_KEY,message);
        SimpleBlankFragment fragment = new SimpleBlankFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        View v= inflater.inflate(R.layout.fragment_blank, container, false);

        TextView textView=v.findViewById(R.id.fragTextt);
        textView.setText(getArguments().getString(MESSAGE_KEY));

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: ");
    }
}
