package com.backend.control;

import java.util.ArrayList;
import java.util.List;

import com.backend.nosql.NoSqlMananger;

/**
 * 
 * @ClassName:UpdateControl
 * @Author:wangxiongfei
 * @Description:Control some methods for update
 * @version:v2.0
 * @Date:2013.10.18
 *
 */
public class UpdateControl {
	//create method
	NoSqlMananger noSqlMananger=new NoSqlMananger();
	//create configControl method
	ConfigControl config=new ConfigControl();
	/*
	 * 
	 */
	public int updateUserInfo(long user_id,String user_type,String user_name,String user_sex,String user_address,String user_mail,String user_country,String user_province,String user_city,String user_avatar){
		List<String> listValues=new ArrayList<>();
		List<String> listField=new ArrayList<>();
		listValues=config.formatValues(user_type, user_name, user_sex, user_address, user_mail, user_country, user_province, user_city, user_avatar);
		listField=config.formatField(user_type);
		noSqlMananger.update(config.KIND_USER_INFO_C, user_id, listField, listValues);
		return 1;
	}
}
