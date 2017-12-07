package com.yepao.pojo;

public class ChineseCalendar {
    private Integer id;

    private Integer year;

    private Integer month;

    private Integer day;

    private String yi;

    private String ji;
    
    private boolean goodFlag;
    
    private boolean reservedFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getYi() {
        return yi;
    }

    public void setYi(String yi) {
        this.yi = yi == null ? null : yi.trim();
    }

    public String getJi() {
        return ji;
    }

    public void setJi(String ji) {
        this.ji = ji == null ? null : ji.trim();
    }

	public boolean isGoodFlag() {
		return goodFlag;
	}

	public void setGoodFlag(boolean goodFlag) {
		this.goodFlag = goodFlag;
	}

	public boolean isReservedFlag() {
		return reservedFlag;
	}

	public void setReservedFlag(boolean reservedFlag) {
		this.reservedFlag = reservedFlag;
	}
    
    
}