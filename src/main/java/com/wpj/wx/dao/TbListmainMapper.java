package com.wpj.wx.dao;

import com.wpj.wx.common.Page;
import com.wpj.wx.daomain.TbListmain;
import com.wpj.wx.util.MyMapper;

import java.util.List;
import java.util.Map;

/**
 * The interface Tb listmain mapper.
 */
public interface TbListmainMapper extends MyMapper<TbListmain> {
    /**
     * Select content map by id map.
     *
     * @param id the id
     * @return the map
     */
    Map<String,Object> selectContentMapById(int id);

    /**
     * Select all count int.
     *
     * @return the int
     */
    int selectAllCount();

    /**
     * Select list main by page list.
     *
     * @param page the page
     * @return the list
     */
    List<TbListmain> selectListMainByPage(Page page);

    /**
     * 根据list的id获取ListMain
     *
     * @param ListId the list id
     * @return the by list id
     */
    List<TbListmain>  getByListId(int ListId);
}