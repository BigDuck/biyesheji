/*
 * Copyright (c) 2016 - 1 - 27  11 : 7 :22
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.component;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.runtime.parser.node.SimpleNode;

import java.io.IOException;
import java.io.Writer;

/**
 * Name：PageDirective
 * Time：2016/1/27 23:07
 * author：WPJ587
 * description：分页底部
 **/

public class PageDirective extends Directive {
    private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PageDirective.class);

    @Override
    public String getName() {
        return "pageBottom";//指令名字
    }

    @Override
    public int getType() {
        return BLOCK;//指定指令类型为块指令
    }

    @Override
    public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
        SimpleNode sn_region = (SimpleNode) node.jjtGetChild(0);
        String region = (String) sn_region.value(context);
        logger.info("sn_region:{} region", sn_region, region);
        StringBuffer sb = new StringBuffer();

        return false;
    }
}
