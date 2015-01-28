package com.finance.financeapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.finance.financeapp.ejb.Alquiler;

public interface RentRepository extends CrudRepository<Alquiler,Integer> {
	
	List<Alquiler> findByIdAlquilerNotIn(List<Integer> list);
	
}
