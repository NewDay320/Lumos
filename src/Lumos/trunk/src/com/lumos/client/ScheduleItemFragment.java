package com.lumos.client;

import com.lumos.R;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ScheduleItemFragment extends Fragment {
	final static String ARG_POSITION = "position";
	int currPosition = -1;
	
	@Override
	public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
		if (savedInstanceState != null) {
//			currPosition = savedInstanceState.getInt(ARG_POSITON);
		}
		return i.inflate(R.layout.schedule_item_view, container, false);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		Bundle args = getArguments();
		if (args != null) {
			updateScheduleView(args.getInt(ARG_POSITION));
		} else if (currPosition != -1) {
			updateScheduleView(currPosition);
		}
	}
	
	public void updateScheduleView(int position){
		TextView item = (TextView) getActivity().findViewById(R.id.schedule_item);
		item.setText(IpsumSchedule.ItemInfo[position]);
		currPosition = position;
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState){
		super.onSaveInstanceState(outState);
		outState.putInt(ARG_POSITION, currPosition);
	}
}