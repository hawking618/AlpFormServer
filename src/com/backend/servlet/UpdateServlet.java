package com.backend.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.backend.control.UpdateControl;

public class UpdateServlet extends HttpServlet{
	/**
	 * Adds a generated serial version ID to the selected type.
	 * Use this option to add a compiler-generated ID if the 
	 * type did not undergo structural changes since its first 
	 * release.
	 * 
	 */
  private static final long serialVersionUID = 704587585981868155L;
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
		//create method
		UpdateControl updateControl=new UpdateControl();
		//get the values from client
		long user_id=Long.parseLong(req.getParameter("id"));//get the userId from client and transform it to long
		String user_type=req.getParameter("userType");
		String user_name=req.getParameter("userName");
		String user_sex=req.getParameter("sex");
		String user_mail=req.getParameter("mail");
		String user_country=req.getParameter("country");
		String user_province=req.getParameter("province");
		String user_city=req.getParameter("city");
		String user_avatar=req.getParameter("avatar");
		String user_address=req.getParameter("address");
		updateControl.updateUserInfo(user_id, user_type, user_name, user_sex, user_address, user_mail, user_country, user_province, user_city, user_avatar);
		out.flush();
		out.close();
	}
;
}
