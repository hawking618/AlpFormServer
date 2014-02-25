package com.backend.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backend.control.SignInControl;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class SignInServlet extends HttpServlet{
	/**
	 * Adds a generated serial version ID to the selected type.
	 * Use this option to add a compiler-generated ID if the 
	 * type did not undergo structural changes since its first 
	 * release.
	 * 
	 */
  private static final long serialVersionUID = -8841678385595771154L;
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
   * @Return:Return a integer value：if it bigger than 0, means login successfully;0 means the account is not exist;-1 means the password is wrong
   * @Exception:no
   */
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		resp.setContentType("test/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		JSONObject jsonObject=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonObject2=new JSONObject();
		//Get the values from client
		String account=req.getParameter("account");
		String password=req.getParameter("pass");
		String serviceValue=req.getParameter("service");
		SignInControl signInControl=new SignInControl();
		//Get the return value of checkLogin
		long checkLogin= signInControl.signIn("Account", account, password);
		//Get the service stringUrl
		String s_url="";
		//登陆成功 则传去 服务器地址
		if(checkLogin>0){
			s_url=signInControl.stringUrl(serviceValue);
		}
		try {
	    jsonObject2.put("s_url", s_url);
	    jsonObject2.put("checkLogin", checkLogin);
	    jsonArray.put(jsonObject2);
	    jsonObject.put("login", jsonArray);
    } catch (JSONException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
    }
		out.print(jsonObject.toString());
		out.flush();
		out.close();
	}
}
