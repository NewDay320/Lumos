package com.lumos.client;

import com.lumos.R;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DietLogFragment extends ListFragment {
	
	OnDietLogItemSelectedListener mCallback;
	
	public interface OnDietLogItemSelectedListener {
		public void onScheduleItemSelected(int position);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ? android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
		setListAdapter(new ArrayAdapter<String>(getActivity(), layout, IpsumDietLog.Items));
	}
	
	@Override
	public void onStart(){
		super.onStart();
        if (getFragmentManager().findFragmentById(R.id.schedule_fragment) != null) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
	}
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		//STUFF
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback = (OnDietLogItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnScheduleItemSelectedListener");
        }
    }
	
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id){
        // Notify the parent activity of selected item
        mCallback.onScheduleItemSelected(position);
        
        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);
	}
}