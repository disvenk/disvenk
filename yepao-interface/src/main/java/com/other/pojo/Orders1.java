package com.other.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.yepao.pojo.WeddingTalent;

public class Orders1 {
    private Long id;

    private String vaidateCode;

    private Date reservedDate;

    private List<OrderAsistant> hall;

    private List<OrderAsistant> combo;

    private List<CelebrationAsistant> celebration;

    private List<WeddingTalent> talent;

    private BigDecimal prepay;

    private BigDecimal obligation;

    private BigDecimal count;

    private Date weddingdate;

    private String status;

    private String checked;

    private Date created;

    private Date closed;

    private Date prepayed;

    private Date payed;

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

    public List<OrderAsistant> getHall() {
        return hall;
    }

    public void setHall(List<OrderAsistant> hall) {
        this.hall = hall ;
    }

    public List<OrderAsistant> getCombo() {
        return combo;
    }

    public void setCombo(List<OrderAsistant> combo) {
        this.combo = combo;
    }

    public List<CelebrationAsistant> getCelebration() {
        return celebration;
    }

    public void setCelebration(List<CelebrationAsistant> celebration) {
        this.celebration = celebration;
    }

    public List<WeddingTalent> getTalent() {
        return talent;
    }

    public void setTalent(List<WeddingTalent> talent) {
        this.talent = talent;
    }

    public BigDecimal getPrepay() {
        return prepay;
    }

    public void setPrepay(BigDecimal prepay) {
        this.prepay = prepay;
    }

    public BigDecimal getObligation() {
        return obligation;
    }

    public void setObligation(BigDecimal obligation) {
        this.obligation = obligation;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public Date getWeddingdate() {
        return weddingdate;
    }

    public void setWeddingdate(Date weddingdate) {
        this.weddingdate = weddingdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked == null ? null : checked.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getClosed() {
        return closed;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }

    public Date getPrepayed() {
        return prepayed;
    }

    public void setPrepayed(Date prepayed) {
        this.prepayed = prepayed;
    }

    public Date getPayed() {
        return payed;
    }

    public void setPayed(Date payed) {
        this.payed = payed;
    }
}