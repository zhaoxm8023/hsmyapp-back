package com.hsmy.app.bean;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HsmyInfoPub {
    private String infoSerno;

    private String openId;

    private String mobileNo;

    private String infoTitle;

    private String infoEnum;

    private String infoWorkdata;

    private String infoEnddata;

    private String infoDesc;

    private String picsDesc;

    private Date lastDate;

    public String getInfoSerno() {
        return infoSerno;
    }

    public void setInfoSerno(String infoSerno) {
        this.infoSerno = infoSerno;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle == null ? null : infoTitle.trim();
    }

    public String getInfoEnum() {
        return infoEnum;
    }

    public void setInfoEnum(String infoEnum) {
        this.infoEnum = infoEnum == null ? null : infoEnum.trim();
    }

    public String getInfoWorkdata() {
        return infoWorkdata;
    }

    public void setInfoWorkdata(String infoWorkdata) {
        this.infoWorkdata = infoWorkdata == null ? null : infoWorkdata.trim();
    }

    public String getInfoEnddata() {
        return infoEnddata;
    }

    public void setInfoEnddata(String infoEnddata) {
        this.infoEnddata = infoEnddata == null ? null : infoEnddata.trim();
    }

    public String getInfoDesc() {
        return infoDesc;
    }

    public void setInfoDesc(String infoDesc) {
        this.infoDesc = infoDesc == null ? null : infoDesc.trim();
    }

    public String getPicsDesc() {
        return picsDesc;
    }

    public void setPicsDesc(String picsDesc) {
        this.picsDesc = picsDesc == null ? null : picsDesc.trim();
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

}