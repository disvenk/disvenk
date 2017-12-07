package com.yepao.pojo;

import java.util.Date;

public class Picture {
    private Integer id;

    private Integer talentId;

    private String talentName;

    private String src;

    private Date uptime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTalentId() {
        return talentId;
    }

    public void setTalentId(Integer talentId) {
        this.talentId = talentId;
    }

    public String getTalentName() {
        return talentName;
    }

    public void setTalentName(String talentName) {
        this.talentName = talentName == null ? null : talentName.trim();
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src == null ? null : src.trim();
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }
}