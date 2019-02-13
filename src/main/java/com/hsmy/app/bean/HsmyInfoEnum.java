package com.hsmy.app.bean;

import org.springframework.stereotype.Component;

@Component
public class HsmyInfoEnum {
    private String infoenum;

    private String infodesc;

    public String getInfoenum() {
        return infoenum;
    }

    public void setInfoenum(String infoenum) {
        this.infoenum = infoenum == null ? null : infoenum.trim();
    }

    public String getInfodesc() {
        return infodesc;
    }

    public void setInfodesc(String infodesc) {
        this.infodesc = infodesc == null ? null : infodesc.trim();
    }
}