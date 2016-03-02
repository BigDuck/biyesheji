/*
 * Copyright (c) 2016 - 2 - 29  5 : 23 :36
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.damain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Name：SecurityUser
 * Time：2016/2/29 17:23
 * author：WPJ587
 * description：自己的用户类
 **/

public class SecurityUser extends SUser implements UserDetails {
    private static final long serialVersionUID = 4157094649883226833L;
    public SecurityUser(SUser suser) {
        if(suser != null)
        {
            this.setId(suser.getId());
            this.setName(suser.getName());
            this.setEmail(suser.getEmail());
            this.setPassword(suser.getPassword());
            this.setDob(suser.getDob());
            this.setSRoles(suser.getSRoles());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<SRole> userRoles = this.getSRoles();

        if(userRoles != null)
        {
            for (SRole role : userRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                authorities.add(authority);
            }
        }
        return authorities;

    }

    @Override
    public String getUsername() {
        return super.getName();
    }

    /**
     * 一下四个必须true才可以验证通过
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * @return password
     */
    @Override
    public String getPassword() {
        return super.getPassword();
    }


}
