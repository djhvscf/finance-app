package com.finance.financeapp.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PojoUtils {
	
	public static void pojoMappingUtility(Object pojo,Object origin){
		
		Method[] methods = pojo.getClass().getDeclaredMethods();
        //System.out.printf("%d methods:%n", methods.length);
        
        //Method[] methods2 = origin.getClass().getDeclaredMethods();
        //System.out.printf("%d methodsOrigin:%n", methods2.length);
        
        for (Method method : methods) {
            
        	//System.out.println(method.getName());
        	if(method.getName().contains("set")){
        		String getMethodName = method.getName().replace("set", "get");
        		try {
					method.invoke(pojo,origin.getClass().getDeclaredMethod(getMethodName).invoke(origin));
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
          
        }
        
	}

}
