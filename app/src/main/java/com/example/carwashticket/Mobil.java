package com.example.carwashticket;

public class Mobil {
    private String _id, _plat, _owner;
    public Mobil (String id, String plat, String owner) {
        this._id = id;
        this._plat = plat;
        this._owner = owner;
    }
    public Mobil() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_plat() {
        return _plat;
    }
    public void set_plat(String _plat) {
        this._plat = _plat;
    }
    public String get_owner() {
        return _owner;
    }
    public void set_owner(String _owner) {
        this._owner = _owner;
    }
}