package com.yepao.pojo;

import java.util.Date;

public class Media {
    private Integer id;

    private Integer talentId;

    private String talentName;

    private String vediosrc;

    private String imgsrc;

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

    public String getVediosrc() {
        return vediosrc;
    }

    public void setVediosrc(String vediosrc) {
        this.vediosrc = vediosrc == null ? null : vediosrc.trim();
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc == null ? null : imgsrc.trim();
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }
}