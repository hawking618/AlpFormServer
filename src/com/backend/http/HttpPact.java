package com.backend.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;


@SuppressWarnings("deprecation")
public class HttpPact{
	//create method
	HttpClient httpClient=new DefaultHttpClient();
  /**
  String strResult=null;
* @Author:wangxiongfei
* @Param:The method for post
* @Return:No
* @Exceptio:
*/
public HttpResponse httpPost(List<NameValuePair> params ,String action,String url){
  //Post 运作传送变量必须用NameValuePair[]数组储存
  HttpResponse httpResponse = null;
  HttpPost postMethod;
  URI uri=null;
  try {
      uri= URIUtils.createURI("http",url,-1,"/"+action, URLEncodedUtils.format(params,"UTF-8"),null);
  } catch (URISyntaxException e) {
      e.printStackTrace();
  }
  postMethod=new HttpPost(uri);
  try {
      postMethod.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
      //执行post方法
      httpResponse=httpClient.execute(postMethod);
  } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
  } catch (ClientProtocolException e) {
      e.printStackTrace();
  } catch (IOException e) {
      e.printStackTrace();
  }
  return httpResponse;
}
}
