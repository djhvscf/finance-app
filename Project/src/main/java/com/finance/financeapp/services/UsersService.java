package com.finance.financeapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.financeapp.contracts.UsersRequest;
import com.finance.financeapp.ejb.Usuario;
import com.finance.financeapp.repositories.UsersRepository;

@Service
public class UsersService implements UsersServiceInterface{

	@Autowired
	UsersRepository usersRepository;
	
	@Override
	@Transactional
	public Page<Usuario> getAll(UsersRequest ur) {
	
		PageRequest pr;
		Sort.Direction direction = Sort.Direction.DESC;
		if(ur.getDirection().equals("ASC")){
			direction = Sort.Direction.ASC;
		}
		
		if(ur.getSortBy().size() > 0){
			Sort sort = new Sort(direction,ur.getSortBy());
			pr = new PageRequest(ur.getPageNumber(),ur.getPageSize(),sort);
		}else{
			pr = new PageRequest(ur.getPageNumber(),ur.getPageSize());
		}
		
		Page<Usuario> result;
		if(ur.getSearchColumn().toLowerCase().equals("all")){
			result = usersRepository.findAll(pr);
		}else if(ur.getSearchColumn().toLowerCase().equals("firstname")){
			result = usersRepository.findByFirstnameContaining(ur.getSearchTerm(),pr);
		} else if(ur.getSearchColumn().toLowerCase().equals("lastname")){
			result = usersRepository.findByLastnameContaining(ur.getSearchTerm(),pr);
		}else{
			result = usersRepository.findAll(pr);
		}
		return result;
		
	}

	@Override
	@Transactional
	public Boolean saveUser(Usuario user) {
		
		Usuario nuser = usersRepository.save(user);
	
		Boolean result = true;
		if(nuser == null){
			result = false;
		}
		return result;
		
	}

	@Override
	public Usuario getSessionUser(int idUser) {
		return usersRepository.findOne(idUser);
	}
}