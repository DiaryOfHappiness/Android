package com.example.samplefragment;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_root);
        if (savedInstanceState == null) {
        	FragmentTransaction ft = getFragmentManager().beginTransaction();

        	ft.add(R.id.content, new PlaceholderFragment(), "fragment_base");

        	ft.commit();
        	
        	
            
//            getFragmentManager().beginTransaction()
//            .add(R.id.event_layout1, new PlaceholderFragment())
//            .commit();
        }
    }


  



    /**
     * A placeholder fragment containing a simple view.
     */
   
}
