package com.backend.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.backend.control.ConfigControl;
import com.backend.control.RegistrationControl;
import com.backend.http.GoogleHttps;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

/**
 * 
 * @ClassName:RegistrationServlet
 * @Author:wangxiongfei
 * @Description:Control the method of register
 * @Version:v2.0
 * @Date:2013.10.17
 *
 */
public class RegistrationServlet extends HttpServlet{

	/**
	 * Adds a generated serial version ID to the selected type.
	 * Use this option to add a compiler-generated ID if the 
	 * type did not undergo structural changes since its first 
	 * release.
	 * 
	 */
  private static final long serialVersionUID = 3596266284516550366L;
  /*
   * @Author:wangxiongfei
   * @Param: the method for doGet
   * @Return: no
   * @Exception:no
   */
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException{
		resp.setContentType("test/html;charset=UTF-8");
		//Jump to method doPost 跳转到doPost方法
		this.doPost(req,resp);
	}
  /*
   * @Author:wangxiongfei
   * @Param: the method for doPost
   * @Return: Return an integer value;0 means register failed, -1 means the account is exist,-2 means register successfully but initialize falide;bigger than 0 means register successfully
   * @Exception:no
   */
	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException{
		resp.setContentType("test/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		JSONObject jsonObject=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonObject2=new JSONObject();
		//Get the values from client
		String account=req.getParameter("account");//the new account
		String password=req.getParameter("pass");//the password for new account
		String service=req.getParameter("service");//the service values
		//Create method
		RegistrationControl registerControl=new RegistrationControl();
		long isRegister=registerControl.registerAccount(account, password);
		ConfigControl cfc=new ConfigControl();
		//Get the service stringUrl
		String s_url="";
		//登陆成功 则传去 服务器地址
		if(isRegister>0){
			//初始化艳遇丽江用户信息
			s_url=cfc.getUrl(service);
      String id=Long.toString(isRegister);
      resp.sendRedirect("http://"+s_url+"/initialize?id="+id);
		}else{
			try {
		    jsonObject2.put("s_url", s_url);
		    jsonObject2.put("isRegister", isRegister);
		    jsonArray.put(jsonObject2);
		    jsonObject.put("register", jsonArray);
	    } catch (JSONException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
	    }
			out.print(jsonObject.toString());
			out.flush();
			out.close();
		}
	}

}
