package com.codeup.pawtify.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserWithRoles extends User implements UserDetails{


    private List<String> roles;

    public UserWithRoles(User user) {
        super(user);
    }

    public UserWithRoles(User user, List<String> roles) {
        super(user);
        this.roles = roles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String rolesString = "";
        for(String role : roles) {
            rolesString += "role-of-" + role + ",";
        }
        return AuthorityUtils.commaSeparatedStringToAuthorityList(rolesString);
    }

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


    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }




}
