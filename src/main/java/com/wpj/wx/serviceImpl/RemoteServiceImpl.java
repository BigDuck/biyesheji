/*
 * Copyright (c) 2016 - 2 - 23  9 : 13 :14
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.serviceimpl;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Bar;
import com.wpj.wx.dao.TbRemoteMapper;
import com.wpj.wx.daomain.TbRemote;
import com.wpj.wx.service.BaseService;
import com.wpj.wx.service.RemoteService;
import com.wpj.wx.util.DateUtil;
import com.wpj.wx.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Name：RemoteServiceImpl
 * Time：2016/2/23 9:12
 * author：WPJ587
 * description：远程调用统计业务层
 **/
@Service
public class RemoteServiceImpl extends BaseService<TbRemote> implements RemoteService {

    @Autowired
    TbRemoteMapper tbRemoteMapper;

    /**
     * 根据条件获取数据
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param ipAddress ip地址
     * @return
     */

    @Override
    @Cacheable(value = "myCache",key = "'remomte'+#startTime+#endTime")
    public List<TbRemote> findRemotebList(Date startTime, Date endTime, String ipAddress) {
        Map<String,Object> paramsMap=new HashMap<>();

        if(startTime!=null){
            paramsMap.put("startTime",startTime);
        }
        if(endTime!=null){
            paramsMap.put("endTime",endTime);
        }
        if(StringUtils.isNoneEmtryAndNull(ipAddress)){
            paramsMap.put("ipAddress",ipAddress);
            paramsMap.put("isIP",true);
        }


            return tbRemoteMapper.getTbRemote(paramsMap);
    }

    /**
     * 转换为echarts的数据
     * @param remotes
     * @return
     */
    @Override
    @Cacheable(value = "myCache",key = "'TbRemote'+#startTime+#endTime+#ip")
    public String toEchartData(List<TbRemote> remotes,Date startTime,Date endTime,String ip) {
        logger.info("---->{}",remotes);
        Option myOption=new Option();
        boolean isIP=StringUtils.isNoneEmtryAndNull(ip);
        if(isIP){
            myOption.title().text("【"+ip+"】的调用情况").subtext(DateUtil.date2Str(startTime)+" 至 "+DateUtil.date2Str(endTime));
        }else {
            myOption.title().text("IP调用详情").subtext(DateUtil.date2Str(startTime,DateUtil.YDM)+" 至 "+DateUtil.date2Str(endTime,DateUtil.YDM));
        }
        myOption.tooltip().trigger(Trigger.axis);
        myOption.legend("次数");
        myOption.toolbox().show(true).feature(Tool.mark, Tool.dataView,
                new MagicType(Magic.line, Magic.bar).show(true),
                Tool.restore, Tool.saveAsImage);
        myOption.calculable(true);
        List<Object> xData=new ArrayList<>();
        List<Object> yData=new ArrayList<>();
        List<Object> xIPData=new ArrayList<>();

        for (TbRemote t:remotes){
            xData.add(t.getRemoteIp());
            xIPData.add(DateUtil.date2Str(t.getRemoteDate()));
            yData.add(t.getRemoteCount());
        }
        if(isIP){
            myOption.xAxis(new CategoryAxis().data(xIPData.toArray()));
        }else{
            myOption.xAxis(new CategoryAxis().data(xData.toArray()));
        }
        myOption.yAxis(new ValueAxis());

        Bar bar = new Bar("访问情况");
        bar.data(yData.toArray());
        bar.markPoint().data(new PointData().type(MarkType.max).name("最大值"), new PointData().type(MarkType.min).name("最小值"));
        bar.markLine().data(new PointData().type(MarkType.average).name("平均值"));
        myOption.series(bar);
        logger.info("result---->{}",GsonUtil.prettyFormat(myOption));
        return GsonUtil.prettyFormat(myOption);
    }
}
