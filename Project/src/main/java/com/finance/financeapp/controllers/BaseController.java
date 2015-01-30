package com.finance.financeapp.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {

	public static int successCode = 200;
	
	public BaseController() {
		super();
	}
	
	public String getDate() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateobj = new Date();
		return df.format(dateobj);
	}
	
	
}