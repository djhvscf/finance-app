package com.finance.financeapp.services;

import java.util.Date;
import java.util.List;

import com.finance.financeapp.contracts.GastoFijoRequest;
import com.finance.financeapp.ejb.GastoFijo;

public interface GastoFijoServiceInterface {

	List<GastoFijo> getAll(GastoFijoRequest gastoFijoRequest);
	Boolean saveGastoFijo (GastoFijo gastoFijo);
	List<GastoFijo> getByNombre (String nombre);
	List<GastoFijo> getByMonto (double monto);
	List<GastoFijo> getByPosibleFechaPago (Date fecha);
	GastoFijo getByIdGastoFijo (int idGastoFijo);
}
