package com.example.samplefragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;

public class PlaceholderFragmentTwo extends Fragment {

	
	String title;
    public PlaceholderFragmentTwo(int id)
    {
    	switch(id)
    	{
    	case 1: title = "Что доставило мне радость сегодня?";
    		break;
    	case 2: title = "Кому и за что я сегодня благодарен?";
    		break;
    	case 3: title = "За что я благодарен себе?";
    		break;    	
    	}
    }

    ViewGroup mContainerView;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_block, container, false);
       
        mContainerView = (ViewGroup) rootView;
//        addItem();
        ((TextView)(mContainerView.findViewById(R.id.event_title))).setText(title);
        
        return rootView;
    }
    
    
    
    private void addItem() {
        // Instantiate a new "row" view.
        final ViewGroup newView = (ViewGroup) getActivity().getLayoutInflater().inflate(
                R.layout.point_item, mContainerView, false);


        // Set a click listener for the "X" button in the row that will remove the row.
        
        //((EditText)newView.findViewById(R.id.point_item_edit)).setOnKeyListener(new EditKeyListener());
        
        EditText newedit = (EditText) newView.findViewById(R.id.point_item_edit);
        newedit.setOnKeyListener(new EditKeyListener());
        
        newView.findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	if(mContainerView.getChildCount() > 3)
            		mContainerView.removeView(newView);
            }
        });

        // Because mContainerView has android:animateLayoutChanges set to true,
        // adding this view is automatically animated.
        mContainerView.addView(newView,1);
    }
    
    private class EditKeyListener implements OnKeyListener{
    	@Override
    	public boolean onKey(View v, int keyCode, KeyEvent event) {
    		
			// TODO Auto-generated method stub
    		if(keyCode == KeyEvent.KEYCODE_ENTER)
    		{
    			if( v.equals(mContainerView.getChildAt( mContainerView.getChildCount()-1 ).findViewById(R.id.point_item_edit) ))
				{
    				PlaceholderFragmentTwo.this.addItem();
    				v.clearFocus();
    				return true;
				}
    		}
    		else if(keyCode == KeyEvent.KEYCODE_DEL)
    		{
    			if(mContainerView.getChildCount() > 3)
	    			if( ((EditText)v).getSelectionStart() == ((EditText)v).getSelectionEnd() &&  ((EditText)v).getSelectionEnd() == 0  )
	    				{
	    					ViewParent point_item = v.getParent();
	    					((ViewGroup)point_item.getParent()).removeView((View) point_item);
	    				}
    		}
			return false;
		}
	}
    
    
}