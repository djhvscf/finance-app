package com.finance.financeapp.contracts;

import com.finance.financeapp.pojo.UsuarioPOJO;

public class UsersRequest extends BasePagingRequest {
	
	private UsuarioPOJO user;
	
	public UsersRequest() {
		super();
	}
	
	public UsuarioPOJO getUser() {
		return user;
	}
	
	public void setUser(UsuarioPOJO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UsersRequest [user=" + user + "]";
	}
}
