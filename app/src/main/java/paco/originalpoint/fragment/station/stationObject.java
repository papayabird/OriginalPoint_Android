package paco.originalpoint.fragment.station;

/**
 * Created by tsaiyuheng on 2017/2/14.
 */

public class stationObject {

    String stationName;
    String address;
    String lat;
    String lng;

    public String getStationName() {
        return stationName;
    }

    public String getAddress() {
        return address;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
/*
    public stationObject(String stationName, String address, String lat, String lng) {

        this.stationName = stationName;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }
    */
}
