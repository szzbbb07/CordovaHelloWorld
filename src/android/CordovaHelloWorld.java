package com.esquel.cordovaHelloWorld;

import java.util.HashMap;
import java.util.Map;

import org.apache.cordova.CordovaActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;

import org.apache.cordova.*;

public class CordovaHelloWorld extends CordovaPlugin {

    private CallbackContext onNewIntentCallbackContext = null;
    private Context ctx;

    //public boolean execute(String action, JSONArray args, String callbackId) {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        try {
            ctx = cordova.getActivity();


            if (action.equals("startActivity")) {
               
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK,"启动成功"));
                return true;
 
            
			} else if (action.equals("startConlose")) {
				 if (args.length() != 1) { 
                    setResult("未发现所需的参数"); 
                    return false;
                }
                JSONObject obj = args.getJSONObject(0);
                String str = obj.getString("str"); 
                setResult("获取到参数str值为：" + str); 
				
				return true;
			} 
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK,"未发现所需要的方法"));
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            String errorMessage=e.getMessage(); 
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK,errorMessage));
            return false;
        }
    }

    public void setResult(String s) {

        if (this.onNewIntentCallbackContext != null) {
            PluginResult result = new PluginResult(PluginResult.Status.OK, s);
            result.setKeepCallback(true);
            this.onNewIntentCallbackContext.sendPluginResult(result);
        }
    }

    
}
