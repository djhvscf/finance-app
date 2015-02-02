package com.finance.financeapp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.finance.financeapp.contracts.UsersRequest;
import com.finance.financeapp.contracts.UsersResponse;
import com.finance.financeapp.ejb.Usuario;
import com.finance.financeapp.pojo.UsuarioPOJO;
import com.finance.financeapp.services.GeneralServiceInterface;
import com.finance.financeapp.services.UsersServiceInterface;
import com.finance.financeapp.utils.PojoUtils;


/**
 * Handles requests for the application home page.
 */
@Component
@Path("/protected/users")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class UsersController {

	@Autowired
	UsersServiceInterface usersService;

	@Autowired
	GeneralServiceInterface generalService;

	@Autowired
	HttpServletRequest request;

	@Path("/getAll")
	@POST
	@Transactional
	public UsersResponse getAll(UsersRequest ur){	

		ur.setPageNumber(ur.getPageNumber() - 1);
		Page<Usuario> users = usersService.getAll(ur);

		UsersResponse us = new UsersResponse();

		us.setCode(200);
		us.setCodeMessage("users fetch success");
		us.setTotalElements(users.getTotalElements());
		us.setTotalPages(users.getTotalPages());

		List<UsuarioPOJO> viewUsers = new ArrayList<UsuarioPOJO>();
		for (Usuario user : users.getContent()){
			UsuarioPOJO nuser = new UsuarioPOJO();
			PojoUtils.pojoMappingUtility(nuser,user);
			viewUsers.add(nuser);
		}

		us.setUsuarios(viewUsers);
		return us;		
	}

	@Path("/create")
	@POST
	public UsersResponse create(UsersRequest ur){	

		UsersResponse us = new UsersResponse();
		Usuario user = new Usuario();
		user.setIdUsuario(ur.getUser().getIdUsuario());		
		user.setFirstname(ur.getUser().getFirstname());
		user.setLastname(ur.getUser().getLastname());
		user.setEmail(ur.getUser().getEmail());
		user.setPassword(ur.getUser().getPassword());
		
		Boolean state = usersService.saveUser(user);
		if(state){
			us.setCode(200);
			us.setCodeMessage("user created succesfully");
		}
		return us;

	}
}