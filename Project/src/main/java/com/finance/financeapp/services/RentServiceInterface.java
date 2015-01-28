package com.finance.financeapp.services;

import java.util.List;

import com.finance.financeapp.ejb.Alquiler;


public interface RentServiceInterface {

	Boolean saveRent(Alquiler alquiler);

	List<Alquiler> getNoUserRentList(List<Integer> rentIds);

	Alquiler getAlquiler(int idAlquiler);

}
