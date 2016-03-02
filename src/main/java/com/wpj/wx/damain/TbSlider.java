package com.wpj.wx.damain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.List;

@Table(name = "tb_slider")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)//自动忽略空字段
public class TbSlider  extends BaseDamain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer tb_id;

    private String theme;

    @Column(name = "sliderConfig")
    private String sliderConfig;

    @Column(name = "className")
    private String classname;

    @Column(name = "html_id")
    private String id;
    @Transient
    private List<TbSlidercontent> content;

    public List<TbSlidercontent> getContent() {
        if(this.content!=null&&this.content.size()<=0){
            this.content=null;
        }
        return content;
    }

    public void setContent(List<TbSlidercontent> content) {
        this.content = content;
    }

    public Integer getTb_id() {
        return tb_id;
    }

    public void setTb_id(Integer tb_id) {
        this.tb_id = tb_id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSliderConfig() {
        return sliderConfig;
    }

    public void setSliderConfig(String sliderConfig) {
        this.sliderConfig = sliderConfig;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TbSlider{" +
                "tb_id=" + tb_id +
                ", theme='" + theme + '\'' +
                ", sliderConfig='" + sliderConfig + '\'' +
                ", classname='" + classname + '\'' +
                ", id='" + id + '\'' +
                ", content=" + content +
                '}';
    }
}