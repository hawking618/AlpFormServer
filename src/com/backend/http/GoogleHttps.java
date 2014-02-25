package com.backend.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.http.conn.scheme.SchemeRegistry;

import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;

@SuppressWarnings("unused")
public class GoogleHttps {
	public void googleHttps(String id){
		
	}
	public void  test(){
		String urlString="bwcalp.appspot.com";
		try {
			String message=URLEncoder.encode("my message","UTF-8");
	    URL url=new URL(urlString);
	    HttpURLConnection connection=(HttpURLConnection) url.openConnection();
	    connection.setDoOutput(true);
	    connection.setRequestMethod("POST");
	    OutputStreamWriter writer=new OutputStreamWriter(connection.getOutputStream());
	    writer.write("message="+message);
	    if(connection.getResponseCode()==HttpURLConnection.HTTP_OK){
	    	String value=connection.getContentEncoding();
	    	System.out.println(value);
	    }
    } catch (MalformedURLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
    } catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
    }
	}
}
