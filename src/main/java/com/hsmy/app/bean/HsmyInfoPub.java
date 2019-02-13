package com.hsmy.app.bean;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HsmyInfoPub {
    private Long id;

    private String openId;

    private String mobileNo;

    private String infoTitle;

    private String infoEnum;

    private String infoData;

    private String infoDesc;

    private Date lastDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getInfoData() {
        return infoData;
    }

    public void setInfoData(String infoData) {
        this.infoData = infoData == null ? null : infoData.trim();
    }

    public String getInfoDesc() {
        return infoDesc;
    }

    public void setInfoDesc(String infoDesc) {
        this.infoDesc = infoDesc == null ? null : infoDesc.trim();
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }
}