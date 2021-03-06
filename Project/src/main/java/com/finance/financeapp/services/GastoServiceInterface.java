package com.finance.financeapp.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.finance.financeapp.contracts.GastoRequest;
import com.finance.financeapp.ejb.Gasto;

public interface GastoServiceInterface {

	Page<Gasto> getAll(GastoRequest gastoRequest);
	Boolean saveGasto(Gasto gasto);
	List<Gasto> getByMonto(Float monto);
	List<Gasto> getByLugar(String lugar);
	List<Gasto> getByFecha(String fecha);
	Gasto getByIdGasto(int idGasto);
	Boolean deleteGasto(int idGasto);
}
