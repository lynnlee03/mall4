package com.lynn.meta;

import java.math.BigInteger;

import javax.persistence.*;
@Entity
@Table(name = "trx")
public class Trx {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "contentId")
    private Integer contentId;
    @Column(name = "personId")
    private Integer personId;
    @Column(name = "price")
    private Integer buyPrice;
    @Column(name = "time")
    private BigInteger buyTime;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getContentId() {
        return contentId;
    }
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }
    public Integer getPersonId() {
        return personId;
    }
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
    public Integer getBuyPrice() {
        return buyPrice;
    }
    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }
    public BigInteger getBuyTime() {
        return buyTime;
    }
    public void setBuyTime(BigInteger buyTime) {
        this.buyTime = buyTime;
    }
}