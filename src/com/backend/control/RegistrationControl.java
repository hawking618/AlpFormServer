package com.backend.control;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.util.EntityUtils;

import com.backend.http.GoogleHttps;
import com.backend.http.HttpPact;
import com.backend.nosql.NoSqlMananger;
import com.google.appengine.api.urlfetch.HTTPResponse;

/**
 * 
 * @ClassName:RegistrationControl
 * @Author:wangxiongfei
 * @Description:Control the methods of register
 * @Version:v2.0
 * @Date:2013.10.17
 *
 */
public class RegistrationControl {
	//create NoSqlManagnger method
	NoSqlMananger noSqlMananger=new NoSqlMananger();
	//create configControl
	ConfigControl config=new ConfigControl();
	/*
	 * @Author:wangxiongfei
	 * @Param:Register a new Account
	 * @Return:Return an integer value:0 means register failed;-1 means the account is exist;
	 * @Exception:
	 */
	public Long registerAccount(String account,String password){
		//check the account if the account is exist
		boolean checkUser=noSqlMananger.checkUser(config.KIND_ACCOUNT, account);
		//According to checkUser to execute the next method,if checkUser is true,we cannot do the next ,else we can 
		if(checkUser){
			return (long) -1; //the account is exist
		}else{
			//create and get the account id
			long accountId=noSqlMananger.createAccount(config.KIND_ACCOUNT, account, password);
			//Determine the accountId
			if(accountId>0){
				//initialize common user
				boolean initial=noSqlMananger.initialization(config.KIND_USER_INFO_C, accountId, config.configField(config.KIND_USER_INFO_C), config.configValues(config.KIND_USER_INFO_C));
				System.out.println("Class registrationControl RegisterAccount:"+initial);
				//Determine if initialization is true;
				if(initial){
					return accountId;//initialization is true  and  return the id;
				}else{
					return (long)0; //false
				}
			}else{
				return (long)0;//false
			}
		}
	}
	/*
	 * 
	 * @Author:wangxiongfei
	 * @Param:control the method for register
	 * @Return:return a String value
	 * @Exception:no
	 * 
	 */
	public String stringUrl(String service){
		ConfigControl configControl=new ConfigControl();
		String s_url=configControl.getUrl(service);
		return s_url;
	}
	/*
	 * 
	 * @Author:wangxiongfei
	 * @Param:control the method for register,initialize  alp user
	 * @Return:return a String value
	 * @Exception:no
	 * 
	 */
	public int initializeUser(String url,String action,List<NameValuePair> params){
		HttpPact hp=new HttpPact();
//		GoogleHttps gh=new GoogleHttps();
//		int value=0;
//		gh.googleHttps(id);
//		return value;
		//初始化艳遇丽江用户
		HttpResponse httpResponse=hp.httpPost(params, action, url);
    try {
      if (httpResponse!=null&&httpResponse.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
          String theReturn= EntityUtils.toString(httpResponse.getEntity());
          int value=Integer.valueOf(theReturn);
          System.out.println("Class RegisterControl initializeUser:"+value);
          return value;
      }
		} catch (IOException e) {
		    e.printStackTrace();
		}
    return 0;
	}
	public String initializeUser1(String url,String action,List<NameValuePair> params){
		HttpPact hp=new HttpPact();
//		GoogleHttps gh=new GoogleHttps();
//		int value=0;
//		gh.googleHttps(id);
//		return value;
		//初始化艳遇丽江用户
		HttpResponse httpResponse=hp.httpPost(params, action, url);
    try {
      if (httpResponse!=null&&httpResponse.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
          String theReturn= EntityUtils.toString(httpResponse.getEntity());
//          int value=Integer.valueOf(theReturn);
//          System.out.println("Class RegisterControl initializeUser:"+value);
          return theReturn;
      }
		} catch (IOException e) {
		    e.printStackTrace();
		}
    return "no get message";
	}
}
