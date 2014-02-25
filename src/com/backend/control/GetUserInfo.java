package com.backend.control;

import com.backend.nosql.NoSqlMananger;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

/**
 * 
 * 
 * @ClassName:GetUserInfo
 * @Author:wangxiongfei
 * @Description:Control the methods,get user Informations
 * @version:v2.0
 * @Date:2013.10.18
 * 
 */
public class GetUserInfo {
	//create method
	NoSqlMananger noSqlMananger=new NoSqlMananger();
	/*
	 * @Author:wangxiongfei
	 * @Param:Get user information
	 * @Return:
	 * @Exception:
	 * 
	 */
	public JSONObject getUser(String kind,long userId){
		//create JSONObject
		JSONObject userInfo=new JSONObject();
		//Get the return
		userInfo=noSqlMananger.getUserAccount(kind, userId);
		return userInfo;
	}
}
