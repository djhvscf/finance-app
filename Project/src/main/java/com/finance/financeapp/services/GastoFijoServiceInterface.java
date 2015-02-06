package com.finance.financeapp.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.finance.financeapp.contracts.GastoFijoRequest;
import com.finance.financeapp.ejb.GastoFijo;

public interface GastoFijoServiceInterface {

	Page<GastoFijo> getAll(GastoFijoRequest gastoFijoRequest);
	Boolean saveGastoFijo (GastoFijo gastoFijo);
	List<GastoFijo> getByNombre (String nombre);
	List<GastoFijo> getByMonto (float monto);
	List<GastoFijo> getByPosibleFechaPago (String fecha);
	GastoFijo getByIdGastoFijo (int idGastoFijo);
	Boolean deleteGastoFijo (int idGastoFijo);
}
