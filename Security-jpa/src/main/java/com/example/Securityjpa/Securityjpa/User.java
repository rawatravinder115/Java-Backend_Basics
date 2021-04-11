package com.example.Securityjpa.Securityjpa;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;

    boolean isActive;
    String authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities_list = new ArrayList<>();

        String[] auth_array= this.authorities.split(":");
        for(int i=0;i<auth_array.length;i++){
            GrantedAuthority obj=new SimpleGrantedAuthority("auth_array[i]");
            authorities_list.add(obj);
        }

        return authorities_list;

        // admin : student

    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
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
        return this.isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User( String userName, String password, boolean isActive, String authorities) {
        this.userName = userName;
        this.password = password;
        this.isActive = isActive;
        this.authorities = authorities;
    }

    public User() {
    }
}
