package paco.originalpoint.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import paco.originalpoint.R;
import paco.originalpoint.TitleBar;
import paco.originalpoint.baseFragment;
import paco.originalpoint.fragment.station.stationObject;

public class Station extends baseFragment {
    private View view;
    private Context thisContext;
    DatabaseReference stationRef = FirebaseDatabase.getInstance().getReference().child("StationDB");
    private static final String TAG = "station";
    ArrayList<stationObject> stationArray = new ArrayList<stationObject>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        thisContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_case, container, false);

        final TitleBar titleBar = (TitleBar)view.findViewById(R.id.title_bar);
        titleBar.setImmersive(true);
        titleBar.setBackgroundColor(Color.parseColor("#64b4ff"));

        titleBar.setTitle("服務據點");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setSubTitleColor(Color.WHITE);
        titleBar.setDividerColor(Color.GRAY);

        initFirDB();
        //導入Tab分頁的Fragment Layout
        return view;
    }

    public void initFirDB() {

        stationRef.addListenerForSingleValueEvent(

                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value

                        for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                            stationObject station = new stationObject();
                            station.setStationName((String) messageSnapshot.child("stationName").getValue());
                            station.setAddress((String) messageSnapshot.child("address").getValue());
                            station.setLat((String) messageSnapshot.child("lat").getValue());
                            station.setLng((String) messageSnapshot.child("lng").getValue());
                            stationArray.add(station);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "Failed to read value.", databaseError.toException());
                    }
                }
        );
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
