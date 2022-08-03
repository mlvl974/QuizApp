package com.ncs.login.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	private User mySecuredUsers;

	public MyUserDetails(User mySecuredUsers) {
		super();
		this.mySecuredUsers = mySecuredUsers;
	}

	public MyUserDetails() {

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// String authority = user.getRole();
		SimpleGrantedAuthority a = new SimpleGrantedAuthority(mySecuredUsers.getRole());
		System.out.println("--->> Inside MyUserDetails class :- " + a.getAuthority());
		return Arrays.asList(a);
	}

	@Override
	public String getPassword() {
		String password = mySecuredUsers.getPassword();
		return password;
	}

	@Override
	public String getUsername() {
		String username = mySecuredUsers.getUsername();
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
