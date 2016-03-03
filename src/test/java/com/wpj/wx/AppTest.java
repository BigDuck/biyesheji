package com.wpj.wx;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wpj.wx.common.Page;
import com.wpj.wx.daomain.*;
import com.wpj.wx.serviceImpl.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */

public class AppTest extends BaseTest
{
    @Autowired
    HeaderServiceImpl headerService;
    @Autowired
    MenuServiceImpl menuService;
    @Autowired
    SliderServiceImpl sliderService;
    @Autowired
    ListServiceImpl listService;
    @Autowired
    ListMainServiceImpl listMainService;
    /**
     * header
     */
    @Test
   public void insert(){
        TbHeader tbHeader=new TbHeader();
        tbHeader.setTitle("测试");
        tbHeader.setFixed(false);
      int  result=  headerService.save(tbHeader);
        System.out.println("result:"+result);
    }
    @Test
    public void select(){
        System.out.println("result:"+ headerService.findDataMapById(1));
        headerService.selectByKey(1);
    }
    /**
     * menu
     */
    @Test
    public void selectMenu(){

     TbMenu tbMenu=menuService.findAllMenuMessageById(1);
        System.out.println(tbMenu.toString());
        System.out.println(tbMenu.getContent());

    }
    @Test
    public void tbSlider(){
       TbSlider tbSlider= sliderService.findAllMenuMessageById(1);
        System.out.println(tbSlider.toString()+"--");
        System.out.println(tbSlider.toString());

    }
    @Test
    public void selectList(){

       TbList tbList= listService.findALlListById(1);
        System.out.println("----->"+tbList.toString());
    }
    @Test
    public void detailListMain(){
        Map<String,Object> result=new HashMap<>();
        result = listMainService.findContentMessageById(2);
        for (Map.Entry<String,Object> entry:result.entrySet()){
            System.out.println(entry.getKey()+"--------"+entry.getValue());
        }

    }
    @Test
    public void testPage(){
        Example example=new Example(TbList.class);
        PageHelper.startPage(1, 3);
         List<TbList> tbLists= listService.selectByExample(example);
        PageInfo<TbList> tbListPageInfo=new PageInfo<>(tbLists);
        System.out.println("---------------------------");
        System.out.println(tbListPageInfo.getList().get(0).toString());
        System.out.println("---------------------------");
       // List<TbList> list= listMainService.selectByExample(example);
     //   System.out.println(list.toString());
    }
    @Test
    public void testMainPage(){
        Example example=new Example(TbListmain.class);
        PageHelper.startPage(1, 3);
        List<TbListmain> tbLists= listMainService.selectByExample(example);
        PageInfo<TbListmain> tbListPageInfo=new PageInfo<>(tbLists);
        System.out.println("---------------------------");
        System.out.println("--->"+tbListPageInfo.toString());
        System.out.println(tbListPageInfo.getList().toString());
        System.out.println("---------------------------");
        // List<TbList> list= listMainService.selectByExample(example);
        //   System.out.println(list.toString());
    }

    /**
     * 测试自己写的简单分页吧
     */
    @Test
    public void myPage(){
        Page page=new Page();
        page.setCount(8);
        page.setPageSize(3);
        page.setPageNo(1);
       List<TbListmain> listmains= listMainService.findListMainByPage(page);
        System.out.println("----------->"+listmains.toString());
    }


}
