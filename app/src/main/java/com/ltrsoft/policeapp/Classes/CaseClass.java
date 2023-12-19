package com.ltrsoft.policeapp.Classes;

import java.io.Serializable;

public class CaseClass implements Serializable {
   private String complain_name,crime_type,crime_status;

    public CaseClass(String complain_name, String crime_type, String crime_status) {
        this.complain_name = complain_name;
        this.crime_type = crime_type;
        this.crime_status = crime_status;
    }

    public String getComplain_name() {
        return complain_name;
    }

    public void setComplain_name(String complain_name) {
        this.complain_name = complain_name;
    }

    public String getCrime_type() {
        return crime_type;
    }

    public void setCrime_type(String crime_type) {
        this.crime_type = crime_type;
    }

    public String getCrime_status() {
        return crime_status;
    }

    public void setCrime_status(String crime_status) {
        this.crime_status = crime_status;
    }
}
