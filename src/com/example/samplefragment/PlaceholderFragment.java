package com.example.samplefragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class PlaceholderFragment extends Fragment {

	
    public PlaceholderFragment()
    {
    	
    }

    ViewGroup root;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base, container, false);
        root = (ViewGroup) rootView;
        
        FragmentTransaction ft = getFragmentManager().beginTransaction();
    	ft.add(R.id.cont1, new PlaceholderFragmentTwo(1), "fragment_0");
    	ft.add(R.id.cont2, new PlaceholderFragmentTwo(2), "fragment_1");
    	ft.add(R.id.cont3, new PlaceholderFragmentTwo(3), "fragment_2");
    	ft.commit();
        
        return rootView;
    }
}