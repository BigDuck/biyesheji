package com.wpj.wx.damain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;

@Table(name = "tb_slidercontent")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)//自动忽略空字段

public class TbSlidercontent extends BaseDamain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    private String link;

    private String img;
    @Column(name = "'desc'")
    private String desc;

    private String other;
    @JsonIgnore
    @Column(name = "slider_id")
    private Integer sliderId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return other
     */
    public String getOther() {
        return other;
    }

    /**
     * @param other
     */
    public void setOther(String other) {
        this.other = other;
    }

    /**
     * @return slider_id
     */
    public Integer getSliderId() {
        return sliderId;
    }

    /**
     * @param sliderId
     */
    public void setSliderId(Integer sliderId) {
        this.sliderId = sliderId;
    }
}