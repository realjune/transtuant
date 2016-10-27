package com.example.t;

import java.util.Map;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ResponseDelivery;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyPost {
	Context context;

	public VolleyPost(Context context) {
		this.context = context;
	}

	public static void postVolley(Context context, String url,
			final Map<String, String> params, Response.Listener rListener,
			Response.ErrorListener eListener) {

		// 初始化一个请求队列
		RequestQueue queue = Volley.newRequestQueue(context);

		// 根据给定的URL新建一个请求
		StringRequest stringRequest = new StringRequest(Request.Method.POST,
				url, rListener, eListener) {
			protected Map<String, String> getParams() throws AuthFailureError {
				return params;
			}
		};
		// 把这个请求加入请求队列
		queue.add(stringRequest);
	}
	
	public interface OnResponseListener<T> extends Response.Listener<T>,Response.ErrorListener{
		
	}

}
