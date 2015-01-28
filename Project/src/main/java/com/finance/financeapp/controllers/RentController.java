package com.finance.financeapp.controllers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.finance.financeapp.contracts.RentItemsResponse;
import com.finance.financeapp.contracts.RentResponse;
import com.finance.financeapp.ejb.Alquiler;
import com.finance.financeapp.ejb.Usuario;
import com.finance.financeapp.pojo.AlquilerPOJO;
import com.finance.financeapp.services.GeneralServiceInterface;
import com.finance.financeapp.services.RentServiceInterface;
import com.finance.financeapp.services.UsersServiceInterface;
import com.finance.financeapp.utils.PojoUtils;
import com.finance.financeapp.utils.Utils;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;


/**
 * Handles requests for the application home page.
 */
@Component
@Path("/protected/rent")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })

public class RentController {
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	GeneralServiceInterface generalService;
	
	@Autowired
	RentServiceInterface rentService;
	
	@Autowired
	UsersServiceInterface usersService;
	
	@Autowired
	HttpServletRequest request;
	
	@Path("/getAll")
	@GET
	@Transactional
	public RentItemsResponse getAll(){
		
		RentItemsResponse ris = new RentItemsResponse();
		
		HttpSession currentSession = request.getSession();
		//int idUser = Integer.parseInt((String) currentSession.getAttribute("idUser"));
		Usuario user = usersService.getSessionUser(1);
		
		List<Alquiler> list = user.getAlquileres();
		List<Integer> rentIds = new ArrayList<Integer>();
		for (Alquiler alq : list){
			rentIds.add(alq.getIdAlquiler());
		}
		
		List<Alquiler> noRentList = rentService.getNoUserRentList(rentIds);
		
		System.out.println(list.size());
		System.out.println(noRentList.size());
		
		List<AlquilerPOJO> viewList = new ArrayList<AlquilerPOJO>();
		for (Alquiler origin : noRentList){
			AlquilerPOJO target = new AlquilerPOJO();
			PojoUtils.pojoMappingUtility(target,origin);
			viewList.add(target);
		}
		
		ris.setAlquileres(viewList);
		ris.setCode(200);
		
		return ris;
		
		
	}
	
	@Path("/getUserAll")
	@GET
	@Transactional
	public RentItemsResponse getUserAll(){
		
		RentItemsResponse ris = new RentItemsResponse();
		
		HttpSession currentSession = request.getSession();
		int idUser = Integer.parseInt((String) currentSession.getAttribute("idUser"));
		Usuario user = usersService.getSessionUser(idUser);
		
		List<Alquiler> list = user.getAlquileres();
	
		List<AlquilerPOJO> viewList = new ArrayList<AlquilerPOJO>();
		for (Alquiler origin : list){
			AlquilerPOJO target = new AlquilerPOJO();
			PojoUtils.pojoMappingUtility(target,origin);
			viewList.add(target);
		}
		
		ris.setAlquileres(viewList);
		ris.setCode(200);
		
		return ris;
		
	}
	
	@Path("/rent")
	@GET
	@Transactional
	public RentItemsResponse rent(@QueryParam("id") int idAlquiler){
		RentItemsResponse rr = new RentItemsResponse();
		
		Alquiler alquiler = rentService.getAlquiler(idAlquiler);
		
		HttpSession currentSession = request.getSession();
		int idUser = Integer.parseInt((String)currentSession.getAttribute("idUser"));
		Usuario user = usersService.getSessionUser(idUser);
		
		List<Alquiler> list = user.getAlquileres();
		list.add(alquiler);
		user.setAlquileres(list);
		Boolean state = usersService.saveUser(user);
		
		if(state){
			rr.setCode(200);
			rr.setCodeMessage("rent item succesfully");

		}else{
			rr.setCode(409);
			rr.setErrorMessage("rent item with errors");
		}
		return rr;
	}
	
	@Path("/create")
	@Consumes(MediaType.MULTIPART_FORM_DATA)  
	@POST
	public RentResponse create(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail,
			@FormDataParam("idTipoAlquiler") int idTipoAlquiler,
			@FormDataParam("name") String name,
			@FormDataParam("description") String description){	
		
		RentResponse rs = new RentResponse();
		String resultFileName = Utils.writeToFile(uploadedInputStream,fileDetail,servletContext);
		if(!resultFileName.equals("")){
			
			Alquiler alquiler = new Alquiler();
			alquiler.setName(name);
			alquiler.setDescription(description);
			alquiler.setImage(resultFileName);
			alquiler.setTipoAlquiler(generalService.getTipoAlquilerById(idTipoAlquiler));
			
			Boolean state = rentService.saveRent(alquiler);
			
			if(state){
				rs.setCode(200);
				rs.setCodeMessage("rent created succesfully");
			}
			
		}else{
			//create a common webservice error codes enum or statics
			rs.setCode(409);
			rs.setErrorMessage("create/edit conflict");
		}
	
		return rs;		
	}
}
