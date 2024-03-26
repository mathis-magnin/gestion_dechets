package edu.polytech.ihmtd2dechet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;
import android.widget.ImageView;

public class MenuFragment extends Fragment {
    public MenuFragment() { }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
        //do something
        ImageView logoMap = rootView.findViewById(R.id.mapPin);
        logoMap.setOnClickListener(click -> {
            Intent intent = new Intent(getContext(), MapActivity.class);
            startActivity(intent);
        });
        return rootView;
    }
}
