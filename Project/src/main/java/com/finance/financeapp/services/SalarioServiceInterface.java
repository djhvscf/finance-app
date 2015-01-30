package com.finance.financeapp.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.finance.financeapp.contracts.SalarioRequest;
import com.finance.financeapp.ejb.Salario;;

public interface SalarioServiceInterface {

	Page<Salario> getAll(SalarioRequest salarioRequest);
	Boolean saveSalario (Salario salario);
	List<Salario> getByFecha(Date fecha);
	List<Salario> getByMonto(double monto);
	Salario getByIdSalario(int idSalario);
}
