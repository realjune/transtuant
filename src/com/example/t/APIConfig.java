package com.example.t;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.t.VolleyPost.OnResponseListener;

/**
 * Created by junxuwang on 16-9-4.
 */
public class APIConfig {
	public static final String HOST_ADRESS = "http://121.199.32.243:80";
	public static final String BASE_URL = HOST_ADRESS
			+ "/LServer/mapi/restaurant/";
	// 获取主页菜品类别和属性
	public static final String API_INDEX = BASE_URL + "index.do";
	// 根据菜品分类查询菜品
	public static final String API_FOOD_BYCATE = BASE_URL
			+ "getFoodByCategoryId.do";
	// 根据菜品属性分类查询菜品
	public static final String API_FOOD_BYPORP = BASE_URL
			+ "getFoodByPropCategoryId.do";
	// 菜品详情
	public static final String API_FOOD_DETAIL = BASE_URL + "foodDetailById.do";
	// 添加菜品到购物车
	public static final String API_ADD_FOOD_TO_CART = BASE_URL
			+ "addShopCart.do";
	// 查找购物车
	public static final String API_FIND_SHOP_CART = BASE_URL
			+ "findShopCart.do";
	// 从购物车删除
	public static final String API_DEL_SHOP_CART = BASE_URL + "delShopCart.do";
	// 下单
	public static final String API_MAKE_ORDER = BASE_URL + "makeOrder.do";

	/**
	 * @param merchantId
	 * @return
	 */
	public static String generateRequestIndexParam(String merchantId) {
		return new StringBuilder()/* .append('?') */
		.append("merchantId").append('=').append(merchantId).toString();
	}

	/**
	 *
	 merchantId锛氬晢鎴穒d , 浼� foodId锛氳彍鍝乮d
	 * deviceId锛氳澶囧敮涓�爣璇嗙锛屽缓璁紶IPAD鐨凪AC鍦板潃锛堣繖鐜
	 * ╂剰鏉ュ尯鍒嗚澶囷紝澧炲姞鍒犻櫎鏌ヨ璐墿杞﹀拰涓嬪崟閮借鐢ㄥ埌鐨勶級 carnum锛氳喘鐗╄溅鑿滃搧鏁伴噺
	 * type锛�type鏈変互涓嬪嚑绉嶏細 2/3/鍏朵粬鏁板�)锛岃繖鐜╂剰鐧句俊鎶勮繃鏉ョ殑锛屼綘鎳傜殑 op锛�op鏈変互涓嬪嚑绉嶏細
	 * add/update) 杩斿洖锛� status锛�0000 琛ㄧず鎴愬姛锛屽叾浠栬〃绀哄け璐� * @return
	 */
	public static String generateRequestAddCartParam(String merchantId,
			String foodId, String deviceId, String carnum, int type, int op) {
		return new StringBuilder(API_INDEX).append('?').append("merchantId")
				.append('=').append(merchantId).append("foodId").append('=')
				.append(foodId).append("deviceId").append('=').append(deviceId)
				.append("carnum").append('=').append(carnum).append("type")
				.append('=').append(type).append("op").append('=').append(op)
				.toString();
	}

	public static void loadIndex(Context context) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("merchantId", "0");
		VolleyPost.postVolley(context, API_INDEX, params, l, l);
	}

	public static void loadBycate(Context context) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("merchantId", "0");
		params.put("categoryId","35dcebf34a424b6a9bf4e9baea0530dd");
		VolleyPost.postVolley(context, API_FOOD_BYCATE, params, l, l);
	}

	static OnResponseListener l = new OnResponseListener<String>() {

		@Override
		public void onResponse(String arg0) {
			LogUtils.d("volley back  " + arg0);
			// TODO Auto-generated method stub

		}

		@Override
		public void onErrorResponse(VolleyError error) {
			LogUtils.d("volley back  " + error);
			// TODO Auto-generated method stub
			// 在这里进行出错之后的处理
		}
	};

}
