/*
 * Copyright (c) 2016 - 3 - 3  4 : 11 :58
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller.admin;

import com.wpj.wx.common.Config;
import com.wpj.wx.daomain.SRole;
import com.wpj.wx.daomain.SUser;
import com.wpj.wx.service.SRoleService;
import com.wpj.wx.service.SUserService;
import com.wpj.wx.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Name：LoginController
 * Time：2016/3/3 16:11
 * author：WPJ587
 * description：登录相关控制器
 **/
@Controller
public class LoginController {
    @Autowired
    SUserService sUserService;
    @Autowired
    SRoleService sRoleService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Object login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object authLogin(HttpSession session,
                            @RequestParam(value = "username", required = true) String username,
                            @RequestParam(value = "password", required = true) String password,
                            HttpServletResponse response,
                            HttpServletRequest request, ModelMap map

    ) throws IOException {
        SUser sUser = sUserService.login(username, MD5Utils.encode(password).toUpperCase());
        if (sUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return null;
        } else {
            SRole sRole = new SRole();
            sRole.setUid(sUser.getId());
            List<SRole> sRoleList = sRoleService.findByUser(sRole);
            if (sRoleList != null && sRoleList.size() > 0) {
                session.setAttribute("role", sRoleList.get(0).getName().toLowerCase());
            }
            try {
                request.getRequestDispatcher("/admin/menu").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @RequestMapping("/logout")
    public Object logout(HttpSession session,
                         HttpServletResponse response,
                         HttpServletRequest request) throws IOException {
        session.removeAttribute("role");
        response.sendRedirect(request.getContextPath() + "/login");
        return null;
    }
}
