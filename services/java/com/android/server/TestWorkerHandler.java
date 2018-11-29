package com.android.server;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
 
public class TestWorkerHandler extends Handler {
	private static final String TAG = "TestService";
    public static final int MESSAGE_SET =0;
	@Override
	public void handleMessage(Message msg){
		try{
			if(msg.what == MESSAGE_SET){
				Log.i(TAG,"Set message received: " + msg.arg1);
			}
		}catch (Exception e){
			Log.e(TAG, "exception in TestWorkerHandler.handleMessage", e);
		}
	}
}