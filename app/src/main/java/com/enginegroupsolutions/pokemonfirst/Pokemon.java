package com.enginegroupsolutions.pokemonfirst;

public class Pokemon {
    private int _id;
    private String _pName;

    public Pokemon(){

    }

    public Pokemon(String pName){
        this._pName = pName;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_pName() {
        return _pName;
    }

    public void set_pName(String _pName) {
        this._pName = _pName;
    }
}
