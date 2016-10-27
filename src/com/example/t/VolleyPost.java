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

		// ��ʼ��һ���������
		RequestQueue queue = Volley.newRequestQueue(context);

		// ���ݸ�����URL�½�һ������
		StringRequest stringRequest = new StringRequest(Request.Method.POST,
				url, rListener, eListener) {
			protected Map<String, String> getParams() throws AuthFailureError {
				return params;
			}
		};
		// �������������������
		queue.add(stringRequest);
	}
	
	public interface OnResponseListener<T> extends Response.Listener<T>,Response.ErrorListener{
		
	}

}
