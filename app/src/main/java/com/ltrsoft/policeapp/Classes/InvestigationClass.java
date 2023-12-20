package com.ltrsoft.policeapp.Classes;

import java.io.Serializable;

public class InvestigationClass implements Serializable {
    private String iwitness,ivictim,isuspect,icrime_type,icomplain_name;

    public InvestigationClass(String iwitness, String ivictim, String isuspect, String icrime_type, String icomplain_name) {
        this.iwitness = iwitness;
        this.ivictim = ivictim;
        this.isuspect = isuspect;
        this.icrime_type = icrime_type;
        this.icomplain_name = icomplain_name;
    }

    public String getIwitness() {
        return iwitness;
    }

    public void setIwitness(String iwitness) {
        this.iwitness = iwitness;
    }

    public String getIvictim() {
        return ivictim;
    }

    public void setIvictim(String ivictim) {
        this.ivictim = ivictim;
    }

    public String getIsuspect() {
        return isuspect;
    }

    public void setIsuspect(String isuspect) {
        this.isuspect = isuspect;
    }

    public String getIcrime_type() {
        return icrime_type;
    }

    public void setIcrime_type(String icrime_type) {
        this.icrime_type = icrime_type;
    }

    public String getIcomplain_name() {
        return icomplain_name;
    }

    public void setIcomplain_name(String icomplain_name) {
        this.icomplain_name = icomplain_name;
    }
}
