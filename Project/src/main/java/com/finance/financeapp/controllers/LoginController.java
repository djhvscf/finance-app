package com.finance.financeapp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.finance.financeapp.contracts.BaseResponse;
import com.finance.financeapp.contracts.LoginRequest;
import com.finance.financeapp.contracts.LoginResponse;
import com.finance.financeapp.ejb.Usuario;
import com.finance.financeapp.services.LoginServiceInterface;


/**
 * Handles requests for the application home page.
 */
@Component
@Path("/login")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class LoginController {
	
	@Autowired
	LoginServiceInterface loginService;
	
	@Autowired
	HttpServletRequest request;
	
	@Path("/checkuser")
	@POST
	@Transactional
	public BaseResponse checkuser(LoginRequest lr){	
		
		Usuario loggedUser = loginService.checkUser(lr);
		
		LoginResponse response = new LoginResponse();
		HttpSession currentSession = request.getSession();
		
		if(loggedUser == null){
			response.setCode(401);
			response.setErrorMessage("Unauthorized User");
		}else{
			
			
			response.setCode(200);
			response.setCodeMessage("User authorized");
			
			//CREATE AND SET THE VALUES FOR THE CONTRACT OBJECT
			response.setIdUsuario(loggedUser.getIdUsuario());
			response.setFirstName(loggedUser.getFirstname());
			response.setLastName(loggedUser.getLastname());
			//
			
			currentSession.setAttribute("idUser", loggedUser.getIdUsuario());
		}
		
		return response;
		
	}
}
