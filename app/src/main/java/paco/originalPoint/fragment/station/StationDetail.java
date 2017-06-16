package paco.originalPoint.fragment.station;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import paco.originalPoint.BaseFragment;
import paco.originalPoint.R;
import paco.originalPoint.TitleBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class StationDetail extends BaseFragment {

    private View view;
    private static final String TAG = "stationDetail";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_station_detail, container, false);

        StationObject stationObject = (StationObject) mInput;

        final TitleBar titleBar = (TitleBar)view.findViewById(R.id.title_bar);
        titleBar.setImmersive(true);
        titleBar.setBackgroundColor(Color.parseColor("#64b4ff"));
        titleBar.setLeftText("返回");
        titleBar.setLeftTextColor(Color.WHITE);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int count = getFragmentManager().getBackStackEntryCount();
                if (count == 0) {
                    getActivity().onBackPressed();
                } else {
                    getFragmentManager().popBackStack();
                }
            }
        });

        titleBar.setTitle(stationObject.getStationName());
        titleBar.setTitleColor(Color.WHITE);



        return view;
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

}
