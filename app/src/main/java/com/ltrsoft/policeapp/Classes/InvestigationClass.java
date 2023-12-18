package com.ltrsoft.policeapp.Classes;

import java.io.Serializable;

public class InvestigationClass implements Serializable {
    String inv_id,inv_name,inv_location,inv_time;

    public InvestigationClass(String inv_id, String inv_name, String inv_location, String inv_time) {
        this.inv_id = inv_id;
        this.inv_name = inv_name;
        this.inv_location = inv_location;
        this.inv_time = inv_time;
    }

    public String getInv_id() {
        return inv_id;
    }

    public void setInv_id(String inv_id) {
        this.inv_id = inv_id;
    }

    public String getInv_name() {
        return inv_name;
    }

    public void setInv_name(String inv_name) {
        this.inv_name = inv_name;
    }

    public String getInv_location() {
        return inv_location;
    }

    public void setInv_location(String inv_location) {
        this.inv_location = inv_location;
    }

    public String getInv_time() {
        return inv_time;
    }

    public void setInv_time(String inv_time) {
        this.inv_time = inv_time;
    }
}
