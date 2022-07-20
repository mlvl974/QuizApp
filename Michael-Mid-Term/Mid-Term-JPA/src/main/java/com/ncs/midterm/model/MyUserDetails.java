package com.ncs.midterm.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	private MySecuredUsers user;

	public MyUserDetails(MySecuredUsers user) {
		super();
		this.user = user;
	}

	public MyUserDetails() {

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// String authority = user.getRole();
		SimpleGrantedAuthority a = new SimpleGrantedAuthority(user.getRole());
		System.out.println("--->> Inside MyUserDetails class :- " + a.getAuthority());
		return Arrays.asList(a);
	}

	@Override
	public String getPassword() {
		String password = user.getPassword();
		return password;
	}

	@Override
	public String getUsername() {
		String username = user.getUsername();
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
