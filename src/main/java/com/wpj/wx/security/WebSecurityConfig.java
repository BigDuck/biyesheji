/*
 * Copyright (c) 2016 - 2 - 29  4 : 22 :20
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.sql.DataSource;

/**
 * Name：WebSecurityConfig
 * Time：2016/2/29 16:22
 * author：WPJ587
 * description：spring security 的配置
 **/
@Configurable
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
    @Autowired
    private DataSource dataSource;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //允许所有用户访问”/”和”/home”
        http.authorizeRequests()
                .antMatchers("/login", "/ckeditor/**", "contentjs/**",
                        "/css/**", "/DatePicker/", "/font/**", "/i/**",
                        "/images/**", "/js/**", "/layer/**", "/plugins/**")
                .permitAll()
                .antMatchers("/admin/**")
                .hasAuthority("ADMIN").antMatchers("/**").permitAll()
                .and()
                .formLogin()
                //指定登录页是”/login”
                .loginPage("/login")
                .permitAll()
                //登录成功后可使用loginSuccessHandler()存储用户信息，可选。
                .successHandler(loginSuccessHandler())//code3
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("remember-me")
            //退出登录后的默认网址是”/home”
                .logoutSuccessUrl("/login")
                .permitAll()
                .invalidateHttpSession(true)
                .and()
                //登录后记住用户，下次自动登录
                //数据库中必须存在名为persistent_logins的表
                .rememberMe()
                .tokenValiditySeconds(1209600)
                //指定记住登录信息所使用的数据源
                .tokenRepository(tokenRepository());//

        super.configure(http);
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();//code6
    }

    @Bean
    public JdbcTokenRepositoryImpl tokenRepository() {
        JdbcTokenRepositoryImpl j = new JdbcTokenRepositoryImpl();
        logger.info("WebSecurityConfig{}", dataSource);
        j.setDataSource(dataSource);
        return j;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
// 指定密码加密所使用的加密器为passwordEncoder()
// 需要将密码加密后写入数据库
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
// 不删除凭据，以便记住用户
        auth.eraseCredentials(false);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }


}
