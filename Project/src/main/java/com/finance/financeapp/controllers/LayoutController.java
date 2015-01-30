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
	
	//****************
	//GASTOS
	//****************
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
	
	//****************
	//SALARIOS
	//****************
	@RequestMapping(value = "/salarios/all")
	public String getSalariosAllLayout()
	{
		return "layouts/salariosAll";
	}
	
	@RequestMapping(value = "/salarios/createSalarioModal")
	public String getCreateSalarioModal()
	{
		return "modals/createSalarioModal";
	}
	
	@RequestMapping(value = "/salarios/modifySalarioModal")
	public String getModifySalarioModal()
	{
		return "modals/modifySalarioModal";
	}
}
