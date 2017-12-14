package com.other.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.yepao.pojo.BanquetHall;
import com.yepao.pojo.Celebration;
import com.yepao.pojo.Combo;
import com.yepao.pojo.WeddingTalent;

public class Orders1 {
    private Long id;

    private String vaidateCode;
    
    private String twoBarCode;

    public String getTwoBarCode() {
		return twoBarCode;
	}

	public void setTwoBarCode(String twoBarCode) {
		this.twoBarCode = twoBarCode;
	}

	private Date reservedDate;

    private List<BanquetHall> hall;

    private List<Combo> combo;

    private List<Celebration> celebration;

    private List<WeddingTalent> talent;

    private BigDecimal obligation;
    
    private BigDecimal count;

    public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVaidateCode() {
        return vaidateCode;
    }

    public void setVaidateCode(String vaidateCode) {
        this.vaidateCode = vaidateCode == null ? null : vaidateCode.trim();
    }

    public Date getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(Date reservedDate) {
        this.reservedDate = reservedDate;
    }

    public List<BanquetHall> getHall() {
        return hall;
    }

    public void setHall(List<BanquetHall> hall) {
        this.hall = hall ;
    }

    public List<Combo> getCombo() {
        return combo;
    }

    public void setCombo(List<Combo> combo) {
        this.combo = combo;
    }

    public List<Celebration> getCelebration() {
        return celebration;
    }

    public void setCelebration(List<Celebration> celebration) {
        this.celebration = celebration;
    }

    public List<WeddingTalent> getTalent() {
        return talent;
    }

    public void setTalent(List<WeddingTalent> talent) {
        this.talent = talent;
    }

    public BigDecimal getObligation() {
        return obligation;
    }

    public void setObligation(BigDecimal obligation) {
        this.obligation = obligation;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}