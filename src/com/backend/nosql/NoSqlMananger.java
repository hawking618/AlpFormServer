package com.backend.nosql;

import java.util.List;

import javax.print.attribute.standard.Finishings;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

/**
 * 
 * @ClassName:NoSqlMananger
 * @Author:wangxiongfei
 * @Description:The method for noSql
 * @version:v2.0
 * @Date:2013.10.17
 *
 */
public class NoSqlMananger {
	DatastoreService datastore=DatastoreServiceFactory.getDatastoreService();
	/*
	 * @Author:wangxiongfei
	 * @Param:create a entity
	 * @Return:Return an Long value;if value bigger than 0 ,it means  register successfully!
	 * @Exception:no
	 */
	public long createAccount(String kind,String account,String password){
		Entity entity=new Entity(kind);
		entity.setProperty("user_account", account);
		entity.setProperty("user_pass", password);
		datastore.put(entity);
		Long id=entity.getKey().getId();
		return id;
	}
	/*
	 * @Author:wangxiongfei
	 * @Param:check account
	 * @Return:Return a boolean value: true means the account is exist,false means the account is not exist!
	 * @Exception:
	 */
	public Boolean checkUser(String kind,String account){
		boolean IsUserExist=false;
		@SuppressWarnings("deprecation")
    Query checkUser=new Query(kind).addFilter("user_account", FilterOperator.EQUAL, account);
		PreparedQuery pq=datastore.prepare(checkUser);
		for(Entity u1:pq.asIterable()){
			IsUserExist=true;
		}
		return IsUserExist;
	}
	/*
	 * @Author:wangxiongfei
	 * @Param:check the user by userId
	 * @Return:Return a boolean value: true means the account is exist,false means the account is not exist!
	 * @Exception:
	 */
	public Boolean checkUser(String kind,long userId){
		boolean IsUserExist=false;
    Query checkUser=new Query(kind);
		PreparedQuery pq=datastore.prepare(checkUser);
		for(Entity u1:pq.asIterable()){
			if(u1.getKey().getId()==userId){
				IsUserExist=true;
			}
		}
		return IsUserExist;
	}
	/*
	 * @Author:wangxiongfei
	 * @Param:check account
	 * @Return:return a long value
	 * @Exception:
	 */
	@SuppressWarnings("deprecation")
  public long checkLogin(String kind,String account,String password){
		long returnValue=0;
		//create Query for searching
		Query checkUser=new Query(kind);
		//add searching values 
		checkUser.addFilter("user_account", FilterOperator.EQUAL, account);
		//searching
		PreparedQuery pq=datastore.prepare(checkUser);
		for(Entity u1:pq.asIterable()){
			if(password.equals(u1.getProperty("user_pass"))){
				long loginId=u1.getKey().getId();
				returnValue=loginId;
			}else{
				returnValue=-1;
			}
		}
		return returnValue;
	}
	/*
	 * @Author:wangxiongfei
	 * @Param:Get user informations
	 * @Return: return a PreparedQuery value
	 * @Exception:
	 */
	public JSONObject getUserAccount(String kind,long userId){
		//create JSONObject
		JSONObject userInfo=new JSONObject();
		//create Query
		Query getInfo=new Query(kind);
		PreparedQuery pq=datastore.prepare(getInfo);
		for(Entity e1:pq.asIterable()){
			if(e1.getKey().getId()==userId){
				try {
	        userInfo.put("user_account",e1.getProperty("user_account").toString());
					userInfo.put("user_pass",e1.getProperty("user_pass").toString());
        } catch (JSONException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
				break;
			}
		}
		return userInfo;
	}
	/*
	 * @Author:wangxiongfei
	 * @Param:create an entity  has the same userId with account
	 * @Return:Return a boolean value ;true means initialization successfully,false means failed.
	 * @Excetion:
	 */
	public boolean initialization(String kind,long userId,List<String> field,List<String> values){
		boolean initial=false;
		//create a new entity
		Entity entity=new Entity(kind,userId);
		if(field.size()==values.size()){
			for(int i=0;i<field.size();i++){
				entity.setProperty(field.get(i), values.get(i));
			}
			datastore.put(entity);
			initial=true;
		}
//		boolean initial=this.checkUser(kind, userId);
		System.out.println("Class NoSqlMananger Initialization:"+initial);
		return initial;
	}
	/*
	 * @Author:wangxiongfei
	 * @Param:create an entity  has the same userId with account
	 * @Return:Return a boolean value ;true means initialization successfully,false means failed.
	 * @Excetion:
	 */
	public boolean update(String kind,long userId,List<String> field,List<String> values){
		//create a new entity
		Entity entity=new Entity(kind,userId);
		if(field.size()==values.size()){
			for(int i=0;i<field.size();i++){
				entity.setProperty(field.get(i), values.get(i));
			}
			datastore.put(entity);
		}
		boolean initial=this.checkUser(kind, userId);
		if(initial){
			return true;
		}else{
			return false;
		}
	}
}
