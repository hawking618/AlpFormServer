package com.backend.control;

import com.backend.nosql.NoSqlMananger;

/**
 * 
 * 
 * @ClassName:SignInControl
 * @Author:wangxiongfei
 * @Description:Control the methods,when the user sign in 
 * @version:v2.0
 * @Date:2013.10.17  
 * 
 */
public class SignInControl {
	NoSqlMananger noSqlMananger =new NoSqlMananger();
	/*
	 * 
	 * @Author:wangxiongfei
	 * @Param:control the method for sign in
	 * @Return:return a long value
	 * @Exception:no
	 * 
	 */
	public long signIn(String kind,String account,String password){
			long checkLogin=noSqlMananger.checkLogin(kind, account, password);
			return checkLogin;
	}
	/*
	 * 
	 * @Author:wangxiongfei
	 * @Param:control the method for sign in
	 * @Return:return a String value
	 * @Exception:no
	 * 
	 */
	public String stringUrl(String service){
		ConfigControl configControl=new ConfigControl();
		String s_url=configControl.getUrl(service);
		return s_url;
	}
	
	
}
