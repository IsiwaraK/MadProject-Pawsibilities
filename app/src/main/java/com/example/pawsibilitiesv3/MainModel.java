package com.example.pawsibilitiesv3;

public class MainModel {

    String name, email, mobile, province, vurl;

    MainModel(){

    }
    public MainModel(String name, String email, String mobile, String province, String vurl) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.province = province;
        this.vurl = vurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getVurl() {
        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl;
    }
}
