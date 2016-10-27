package com.example.t;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by junxuwang on 16-9-4.
 */
public class NetRequest {
    public static String getHttpURLConnection(String urlAdress){
        String result=null;
        if(urlAdress!=null)
        try {
            URL url = new URL(urlAdress);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            LogUtils.d("back "+connection.getResponseMessage());
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                result = connection.getResponseMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static String postHttpURLConnection(String address,String params){
    	params=URLEncoder.encode(params);// 中文数据需要经过URL编码
    	JSONObject jparams = new JSONObject();
        try {
        	jparams.put("merchantId", "0");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    		byte[] data = jparams.toString().getBytes();

    		URL url;
			try {
				url = new URL(address);
    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    		conn.setConnectTimeout(3000);
    		//这是请求方式为POST
    		conn.setRequestMethod("POST");
    		//设置post请求必要的请求头
    		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// 请求头, 必须设置
    		conn.setRequestProperty("Content-Length", data.length + "");// 注意是字节长度, 不是字符长度
    		/* optional request header */  
      
            /* optional request header */  
    		conn.setRequestProperty("Accept", "application/json");  
//    		conn.setCreator(java.net.URLEncoder.encode(conn.getCreator(), "utf-8"));  

    		conn.setDoOutput(true);// 准备写出
    		conn.setDoInput(true);
    		conn.getOutputStream().write(data);// 写出数据
    		LogUtils.d( conn.getResponseMessage());
    		
    		
    		if (conn.getResponseCode() == 200) {  
                // 获取响应的输入流对象  
                InputStream is = conn.getInputStream();  
                // 创建字节输出流对象  
                ByteArrayOutputStream baos = new ByteArrayOutputStream();  
                // 定义读取的长度  
                int len = 0;  
                // 定义缓冲区  
                byte buffer[] = new byte[1024];  
                // 按照缓冲区的大小，循环读取  
                while ((len = is.read(buffer)) != -1) {  
                    // 根据读取的长度写入到os对象中  
                    baos.write(buffer, 0, len);  
                }  
                // 释放资源  
                is.close();  
                baos.close();  
                // 返回字符串  
                final String result = new String(baos.toByteArray());  
  
                return result;
  
            } else {  
                System.out.println("链接失败.........");  
            }  
    		
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		return "";
    }


}
