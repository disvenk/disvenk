package com.yepao.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
    private Long id;

    private String vaidateCode;

    private Long hotelId;

    private String weipayid;

    private String prepayId;

    private String customerName;

    private String tel;

    private String gender;

    private String customerId;

    private Date reservedDate;

    private String hall;

    private String combo;

    private String celebration;

    private String description;

    private String talent;

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

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getWeipayid() {
        return weipayid;
    }

    public void setWeipayid(String weipayid) {
        this.weipayid = weipayid == null ? null : weipayid.trim();
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId == null ? null : prepayId.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public Date getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(Date reservedDate) {
        this.reservedDate = reservedDate;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall == null ? null : hall.trim();
    }

    public String getCombo() {
        return combo;
    }

    public void setCombo(String combo) {
        this.combo = combo == null ? null : combo.trim();
    }

    public String getCelebration() {
        return celebration;
    }

    public void setCelebration(String celebration) {
        this.celebration = celebration == null ? null : celebration.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTalent() {
        return talent;
    }

    public void setTalent(String talent) {
        this.talent = talent == null ? null : talent.trim();
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
    
    public Long getOid(){
    	return id;
    }
}