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
    	params=URLEncoder.encode(params);// ����������Ҫ����URL����
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
    		//��������ʽΪPOST
    		conn.setRequestMethod("POST");
    		//����post�����Ҫ������ͷ
    		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// ����ͷ, ��������
    		conn.setRequestProperty("Content-Length", data.length + "");// ע�����ֽڳ���, �����ַ�����
    		/* optional request header */  
      
            /* optional request header */  
    		conn.setRequestProperty("Accept", "application/json");  
//    		conn.setCreator(java.net.URLEncoder.encode(conn.getCreator(), "utf-8"));  

    		conn.setDoOutput(true);// ׼��д��
    		conn.setDoInput(true);
    		conn.getOutputStream().write(data);// д������
    		LogUtils.d( conn.getResponseMessage());
    		
    		
    		if (conn.getResponseCode() == 200) {  
                // ��ȡ��Ӧ������������  
                InputStream is = conn.getInputStream();  
                // �����ֽ����������  
                ByteArrayOutputStream baos = new ByteArrayOutputStream();  
                // �����ȡ�ĳ���  
                int len = 0;  
                // ���建����  
                byte buffer[] = new byte[1024];  
                // ���ջ������Ĵ�С��ѭ����ȡ  
                while ((len = is.read(buffer)) != -1) {  
                    // ���ݶ�ȡ�ĳ���д�뵽os������  
                    baos.write(buffer, 0, len);  
                }  
                // �ͷ���Դ  
                is.close();  
                baos.close();  
                // �����ַ���  
                final String result = new String(baos.toByteArray());  
  
                return result;
  
            } else {  
                System.out.println("����ʧ��.........");  
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
