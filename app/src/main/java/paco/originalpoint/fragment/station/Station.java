package paco.originalPoint.fragment.station;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import paco.originalPoint.R;
import paco.originalPoint.TitleBar;
import paco.originalPoint.BaseFragment;
import paco.originalPoint.fragment.station.StationObject;

public class Station extends BaseFragment {
    private View view;
    private Context thisContext;
    DatabaseReference stationRef = FirebaseDatabase.getInstance().getReference().child("StationDB");
    private static final String TAG = "station";
    ArrayList<StationObject> stationArray = new ArrayList<StationObject>();
    Bundle sis;
    MapView mapView;
    GoogleMap map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        sis = savedInstanceState;
        thisContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_station, container, false);

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
                            StationObject station = new StationObject();
                            station.setStationName((String) messageSnapshot.child("stationName").getValue());
                            station.setAddress((String) messageSnapshot.child("address").getValue());
                            station.setLat((String) messageSnapshot.child("lat").getValue());
                            station.setLng((String) messageSnapshot.child("long").getValue());
                            stationArray.add(station);
                        }
                        Log.i(TAG, "station count = " + stationArray.size());
                        initMap();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "Failed to read value.", databaseError.toException());
                    }
                }
        );
    }

    private void initMap() {

        mapView = (MapView) view.findViewById(R.id.mapview);
        mapView.onCreate(sis);
        mapView.onResume();// needed to get the map to display immediately

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                for (int i = 0;i < stationArray.size();i++) {
                    StationObject stationObj = stationArray.get(i);
                    Marker marker = map.addMarker(new MarkerOptions()
                            .position(new LatLng(Double.parseDouble(stationObj.getLat()), Double.parseDouble(stationObj.getLng())))
                            .title(stationObj.getStationName()));
                    marker.setTag(i);
                }

                double la = 25.033718;
                double lo = 121.56481;
                final CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(la, lo), 13);
                map.moveCamera(cameraUpdate);
            }
        });

    }

    public boolean onMarkerClick(final Marker marker) {

        Integer clickCount = (Integer) marker.getTag();
        Log.i(TAG, "clickCount = " + clickCount);

        return false;
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
