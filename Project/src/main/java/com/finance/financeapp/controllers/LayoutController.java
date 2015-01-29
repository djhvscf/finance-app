package com.finance.financeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/layoutservice")
public class LayoutController {			
	

	@RequestMapping(value = "/loginlayout")
	public String getLoginLayout()
	{
		return "layouts/login";
	}
	
	@RequestMapping(value = "/userslayout")
	public String getUsersLayout()
	{
		return "layouts/users";
	}
	
	@RequestMapping(value = "/user/createUserModal")
	public String getCreateUserModal()
	{
		return "modals/createUserModal";
	}
	
	@RequestMapping(value = "/user/modifyUserModal")
	public String getModifyUserModal()
	{
		return "modals/modifyUserModal";
	}
	
	@RequestMapping(value = "/rent/list")
	public String getRentListLayout()
	{
		return "layouts/rentList";
	}
	
	@RequestMapping(value = "/rent/create")
	public String getRentCreateLayout()
	{
		return "layouts/rentCreate";
	}
	
	@RequestMapping(value = "/rent/do")
	public String getRentDoLayout()
	{
		return "layouts/rentDo";
	}
	
	@RequestMapping(value = "/gastos/all")
	public String getGastosAllLayout()
	{
		return "layouts/gastosAll";
	}
	
	@RequestMapping(value = "/gastos/createGastoModal")
	public String getCreateGastoModal()
	{
		return "modals/createGastoModal";
	}
	
	@RequestMapping(value = "/gastos/modifyGastoModal")
	public String getModifyGastoModal()
	{
		return "modals/modifyGastoModal";
	}
}
