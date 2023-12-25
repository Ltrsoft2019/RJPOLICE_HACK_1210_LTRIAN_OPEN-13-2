package com.ltrsoft.policeapp.Classes;

import java.io.Serializable;

public class InvestigationClass implements Serializable {
    private String fir_id, complaint_subject, complaint_type_name, complaintORfir_name, status_name, suspect_name,
            suspect_address, suspect_gender, suspect_mobile_no, suspect_photo,
            investigation_witness_name, investigation_witness_address, investigation_witness_dob, investigation_witness_gender,
            investigation_witness_mobile, investigation_witness_photo, victim_name,
            victim_address, victim_gender, victim_mobile_no, victim_photo, suspect_dob, victim_dob;

    public InvestigationClass(String fir_id, String complaint_subject, String complaint_type_name,
                              String complaintORfir_name, String status_name, String suspect_name,
                              String suspect_address, String suspect_gender, String suspect_mobile_no,
                              String suspect_photo, String investigation_witness_name, String investigation_witness_address,
                              String investigation_witness_dob, String investigation_witness_gender,
                              String investigation_witness_mobile, String investigation_witness_photo,
                              String victim_name, String victim_address, String victim_gender, String victim_mobile_no,
                              String victim_photo, String suspect_dob, String victim_dob) {
        this.fir_id = fir_id;
        this.complaint_subject = complaint_subject;
        this.complaint_type_name = complaint_type_name;
        this.complaintORfir_name = complaintORfir_name;
        this.status_name = status_name;
        this.suspect_name = suspect_name;
        this.suspect_address = suspect_address;
        this.suspect_gender = suspect_gender;
        this.suspect_mobile_no = suspect_mobile_no;
        this.suspect_photo = suspect_photo;
        this.investigation_witness_name = investigation_witness_name;
        this.investigation_witness_address = investigation_witness_address;
        this.investigation_witness_dob = investigation_witness_dob;
        this.investigation_witness_gender = investigation_witness_gender;
        this.investigation_witness_mobile = investigation_witness_mobile;
        this.investigation_witness_photo = investigation_witness_photo;
        this.victim_name = victim_name;
        this.victim_address = victim_address;
        this.victim_gender = victim_gender;
        this.victim_mobile_no = victim_mobile_no;
        this.victim_photo = victim_photo;
        this.suspect_dob = suspect_dob;
        this.victim_dob = victim_dob;
    }

    public String getFir_id() {
        return fir_id;
    }

    public void setFir_id(String fir_id) {
        this.fir_id = fir_id;
    }

    public String getComplaint_subject() {
        return complaint_subject;
    }

    public void setComplaint_subject(String complaint_subject) {
        this.complaint_subject = complaint_subject;
    }

    public String getComplaint_type_name() {
        return complaint_type_name;
    }

    public void setComplaint_type_name(String complaint_type_name) {
        this.complaint_type_name = complaint_type_name;
    }

    public String getComplaintORfir_name() {
        return complaintORfir_name;
    }

    public void setComplaintORfir_name(String complaintORfir_name) {
        this.complaintORfir_name = complaintORfir_name;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public String getSuspect_name() {
        return suspect_name;
    }

    public void setSuspect_name(String suspect_name) {
        this.suspect_name = suspect_name;
    }

    public String getSuspect_address() {
        return suspect_address;
    }

    public void setSuspect_address(String suspect_address) {
        this.suspect_address = suspect_address;
    }

    public String getSuspect_gender() {
        return suspect_gender;
    }

    public void setSuspect_gender(String suspect_gender) {
        this.suspect_gender = suspect_gender;
    }

    public String getSuspect_mobile_no() {
        return suspect_mobile_no;
    }

    public void setSuspect_mobile_no(String suspect_mobile_no) {
        this.suspect_mobile_no = suspect_mobile_no;
    }

    public String getSuspect_photo() {
        return suspect_photo;
    }

    public void setSuspect_photo(String suspect_photo) {
        this.suspect_photo = suspect_photo;
    }

    public String getInvestigation_witness_name() {
        return investigation_witness_name;
    }

    public void setInvestigation_witness_name(String investigation_witness_name) {
        this.investigation_witness_name = investigation_witness_name;
    }

    public String getInvestigation_witness_address() {
        return investigation_witness_address;
    }

    public void setInvestigation_witness_address(String investigation_witness_address) {
        this.investigation_witness_address = investigation_witness_address;
    }

    public String getInvestigation_witness_dob() {
        return investigation_witness_dob;
    }

    public void setInvestigation_witness_dob(String investigation_witness_dob) {
        this.investigation_witness_dob = investigation_witness_dob;
    }

    public String getInvestigation_witness_gender() {
        return investigation_witness_gender;
    }

    public void setInvestigation_witness_gender(String investigation_witness_gender) {
        this.investigation_witness_gender = investigation_witness_gender;
    }

    public String getInvestigation_witness_mobile() {
        return investigation_witness_mobile;
    }

    public void setInvestigation_witness_mobile(String investigation_witness_mobile) {
        this.investigation_witness_mobile = investigation_witness_mobile;
    }

    public String getInvestigation_witness_photo() {
        return investigation_witness_photo;
    }

    public void setInvestigation_witness_photo(String investigation_witness_photo) {
        this.investigation_witness_photo = investigation_witness_photo;
    }

    public String getVictim_name() {
        return victim_name;
    }

    public void setVictim_name(String victim_name) {
        this.victim_name = victim_name;
    }

    public String getVictim_address() {
        return victim_address;
    }

    public void setVictim_address(String victim_address) {
        this.victim_address = victim_address;
    }

    public String getVictim_gender() {
        return victim_gender;
    }

    public void setVictim_gender(String victim_gender) {
        this.victim_gender = victim_gender;
    }

    public String getVictim_mobile_no() {
        return victim_mobile_no;
    }

    public void setVictim_mobile_no(String victim_mobile_no) {
        this.victim_mobile_no = victim_mobile_no;
    }

    public String getVictim_photo() {
        return victim_photo;
    }

    public void setVictim_photo(String victim_photo) {
        this.victim_photo = victim_photo;
    }

    public String getSuspect_dob() {
        return suspect_dob;
    }

    public void setSuspect_dob(String suspect_dob) {
        this.suspect_dob = suspect_dob;
    }

    public String getVictim_dob() {
        return victim_dob;
    }

    public void setVictim_dob(String victim_dob) {
        this.victim_dob = victim_dob;
    }
}

