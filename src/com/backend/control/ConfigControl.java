package com.backend.control;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:ConfigControl;
 * @Author:wangxiongfei
 * @Description:Is globally defined fields
 * @Version:v2.0
 * @Date:2013.10.18
 *
 */
public class ConfigControl {
	/*
	 * create a kind name 
	 */
	public String KIND_ACCOUNT="Account";//user register
	public String KIND_USER_INFO_C="User_c";//common user informations
	public String KIND_USER_INFO_B="User_s";//business user informations
	public String INITIALIZE="initialize";
	public String ALP_URL_GOOGLE="bwcalp.appspot.com";// the address for alp
	public String ALP_URL="alpbackendtest20130910.bllijiang.com";//the address for alp
	public List<String> list=new ArrayList<String>();//list for field
	public List<String> listValues=new ArrayList<String>();//list for initializeValues
	public List<String> configField(String kind){
		//the  field for account
		if(kind.equals(KIND_ACCOUNT)){
			list.add("user_account");
			list.add("user_pass");
		}
		//the  field for user_c
		if(kind.equals(KIND_USER_INFO_C)){
			list.add("user_type");
			list.add("user_nickname");
			list.add("user_sex");
			list.add("user_mail");
			list.add("user_country");
			list.add("user_province");
			list.add("user_city");
			list.add("user_regtime");
			list.add("user_status");
			list.add("user_point1");
			list.add("user_point2");
			list.add("user_point3");
		}
		//the  field for user_b
		if(kind.equals(KIND_USER_INFO_B)){
			list.add("user_type");
			list.add("user_nickname");
			list.add("user_class");
			list.add("user_sub_class");
			list.add("user_mail");
			list.add("user_country");
			list.add("user_province");
			list.add("user_city");
			list.add("user_address");
			list.add("user_regtime");
			list.add("user_status");
			list.add("user_point1");
			list.add("user_point2");
			list.add("user_point3");
			list.add("user_point4");
		}
		return list;
	}
	public List<String> configValues(String kind){
		//the  field for account
		if(kind.equals(KIND_ACCOUNT)){
			listValues.add("YYLJ");	//values for user_account
			listValues.add("test123");//values for user_pass
		}
		//the  field for user_c
		if(kind.equals(KIND_USER_INFO_C)){
			listValues.add("1");
			listValues.add("");//values for user_nickname
			listValues.add("3");//values for user_sex
			listValues.add("");//values for user_mail
			listValues.add("");//values for user_country
			listValues.add("");//values for user_province
			listValues.add("");//values for user_city
			listValues.add("");//values for user_regtime
			listValues.add("0");//values for user_status
			listValues.add("");//values for user_point1
			listValues.add("");//values for user_point2
			listValues.add("");//values for user_point3
		}
		//the  field for user_b
		if(kind.equals(KIND_USER_INFO_B)){
			listValues.add("2");//values for user_type initialize
			listValues.add("");//values for user_nickname
			listValues.add("");//values for user_class
			listValues.add("");//values for user_sub_class
			listValues.add("");//values for user_mail
			listValues.add("");//values for user_country
			listValues.add("");//values for user_province
			listValues.add("");//values for user_city
			listValues.add("");//values for user_address
			listValues.add("");//values for user_regtime
			listValues.add("");//values for user_status
			listValues.add("");//values for user_point1
			listValues.add("");//values for user_point2
			listValues.add("");//values for user_point3
			listValues.add("");//values for user_point4
		}
		return listValues;
	}
	public List<String> formatValues(String type,String user_name,String user_sex,String user_address,String user_mail,String user_country,String user_province,String user_city,String user_avatar){
		List<String> listFormat=new ArrayList<String>();
		if(type=="1"){
			listFormat.add(user_name);
			listFormat.add(user_sex);
			listFormat.add(user_mail);
			listFormat.add(user_country);
			listFormat.add(user_province);
			listFormat.add(user_city);
			listFormat.add(user_avatar);
		}else{
			listFormat.add(user_name);
			listFormat.add(user_mail);
			listFormat.add(user_country);
			listFormat.add(user_province);
			listFormat.add(user_city);
			listFormat.add(user_address);
			listFormat.add(user_avatar);
		}
		return listFormat;
	}
	public List<String> formatField(String user_type){
		List<String> listFormatField=new ArrayList<String>();
		if(user_type=="1"){
			listFormatField.add("user_name");
			listFormatField.add("user_sex");
			listFormatField.add("user_mail");
			listFormatField.add("user_country");
			listFormatField.add("user_province");
			listFormatField.add("user_city");
			listFormatField.add("user_avatar");
		}else{
			listFormatField.add("user_name");
			listFormatField.add("user_mail");
			listFormatField.add("user_country");
			listFormatField.add("user_province");
			listFormatField.add("user_city");
			listFormatField.add("user_address");
			listFormatField.add("user_avatar");
			
		}
		return listFormatField;
	}
	
	public String getUrl(String service){
		String url="";
		switch (service) {
			case "1":
				url=ALP_URL;
				break;
			case "2":
				url="31231";
				break;
		}
		return url;
	}
}
