package com.yepao.pojo;

import java.util.Date;

public class Celebrationpicture {
    private Integer id;

    private Long celebrationId;

    private String celebrationName;

    private String src;

    private Date uptime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCelebrationId() {
        return celebrationId;
    }

    public void setCelebrationId(Long celebrationId) {
        this.celebrationId = celebrationId;
    }

    public String getCelebrationName() {
        return celebrationName;
    }

    public void setCelebrationName(String celebrationName) {
        this.celebrationName = celebrationName == null ? null : celebrationName.trim();
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