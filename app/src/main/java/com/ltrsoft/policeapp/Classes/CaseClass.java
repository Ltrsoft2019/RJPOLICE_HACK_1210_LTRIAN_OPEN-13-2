package com.ltrsoft.policeapp.Classes;

import java.io.Serializable;

public class CaseClass implements Serializable {
   private String complain_name,status_name,complaint_type_name,complaint_description,complaint_against,incident_date,latitude,longitude,complaint_fir_id,created_at,updated_at,user_address;

    public CaseClass(String complain_name, String status_name, String complaint_type_name,
                     String complaint_description, String complaint_against, String incident_date,
                     String latitude, String longitude, String complaint_fir_id,
                     String created_at, String updated_at, String user_address) {
        this.complain_name = complain_name;
        this.status_name = status_name;
        this.complaint_type_name = complaint_type_name;
        this.complaint_description = complaint_description;
        this.complaint_against = complaint_against;
        this.incident_date = incident_date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.complaint_fir_id = complaint_fir_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user_address = user_address;
    }

    public String getComplain_name() {
        return complain_name;
    }

    public void setComplain_name(String complain_name) {
        this.complain_name = complain_name;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public String getComplaint_type_name() {
        return complaint_type_name;
    }

    public void setComplaint_type_name(String complaint_type_name) {
        this.complaint_type_name = complaint_type_name;
    }

    public String getComplaint_description() {
        return complaint_description;
    }

    public void setComplaint_description(String complaint_description) {
        this.complaint_description = complaint_description;
    }

    public String getComplaint_against() {
        return complaint_against;
    }

    public void setComplaint_against(String complaint_against) {
        this.complaint_against = complaint_against;
    }

    public String getIncident_date() {
        return incident_date;
    }

    public void setIncident_date(String incident_date) {
        this.incident_date = incident_date;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getComplaint_fir_id() {
        return complaint_fir_id;
    }

    public void setComplaint_fir_id(String complaint_fir_id) {
        this.complaint_fir_id = complaint_fir_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
}
