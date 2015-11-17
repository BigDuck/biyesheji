package com.wpj.wx.daomain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Table(name = "tb_list")
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)//自动忽略空字段
public class TbList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id")
    private Integer list_id;

    @Column(name = "html_id")
    private String id;
    @Column(name = "class_name")
    private String className;
    private String theme;
    @JsonIgnore
    private String type;
    @JsonIgnore
    @Column(name = "thumb_position")
    private String thumbPosition;
    @JsonIgnore
    private String title;
    @JsonIgnore
    private String link;
    @JsonIgnore
    @Column(name = "con_class_name")
    private String conClassName;
    @JsonIgnore
    @Column(name = "more_text")
    private String moreText;
    @JsonIgnore
    @Column(name = "more_position")
    private String morePosition;//值：top、bottom

    @Transient
    private HashMap<String, Object> options;
    @Transient
    private HashMap<String, Object> content;
    @Transient
    @JsonIgnore
    private List<TbListmain> main;

    public HashMap<String, Object> getOptions() {
        HashMap<String,Object> map=new HashMap<>();
        if(this.type!=null){
            map.put("type",type);
        }
        if(this.thumbPosition!=null){
            map.put("thumbPosition",thumbPosition);
        }
        if(map.size()<=0){
            map=null;
        }
        this.options=map;
        return options;
    }

    public void setOptions(HashMap<String, Object> options) {
        this.options = options;
    }

    public HashMap<String, Object> getContent() {
        HashMap<String,Object> header=new HashMap<>();
        if(this.title!=null){
            header.put("title",this.title);
        }
        if (this.getLink()!=null){
            header.put("link",link);
        }
        if(this.conClassName!=null){
            header.put("className",conClassName);
        }
        if(this.moreText!=null){
            header.put("moreText",moreText);
        }
        if(this.morePosition!=null){

            header.put("morePosition",morePosition);
        }
        System.out.println("--->"+this.title+link+conClassName+morePosition);
        if(header.size()<=0){
            header=null;
        }
        HashMap<String,Object> data=new HashMap<>();
        data.put("header",header);
        if(this.main!=null){
            data.put("main",main);
        }
        this.content=data;

        return content;
    }

    public void setContent(HashMap<String, Object> content) {
        this.content = content;
    }

    public List<TbListmain> getMain() {
        return main;
    }

    public void setMain(List<TbListmain> main) {
        this.main = main;
    }

    public Integer getList_id() {
        return list_id;
    }

    public void setList_id(Integer list_id) {
        this.list_id = list_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getThumbPosition() {
        return thumbPosition;
    }

    public void setThumbPosition(String thumbPosition) {
        this.thumbPosition = thumbPosition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getConClassName() {
        return conClassName;
    }

    public void setConClassName(String conClassName) {
        this.conClassName = conClassName;
    }

    public String getMoreText() {
        return moreText;
    }

    public void setMoreText(String moreText) {
        this.moreText = moreText;
    }

    public String getMorePosition() {
        return morePosition;
    }

    public void setMorePosition(String morePosition) {
        this.morePosition = morePosition;
    }

    @Override
    public String toString() {
        return "TbList{" +
                "list_id=" + list_id +
                ", id='" + id + '\'' +
                ", className='" + className + '\'' +
                ", theme='" + theme + '\'' +
                ", type='" + type + '\'' +
                ", thumbPosition='" + thumbPosition + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", conClassName='" + conClassName + '\'' +
                ", moreText='" + moreText + '\'' +
                ", morePosition='" + morePosition + '\'' +
                ", options=" + options +
                ", content=" + content +
                ", main=" + main +
                '}';
    }
}