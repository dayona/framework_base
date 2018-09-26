 package com.android.server;
 import android.content.Context;
 import android.os.Handler;
 import android.os.ITestService;
 import android.os.Looper;
 import android.os.Message;
 import android.os.Process;
 import android.util.Log;
 public class TestService extends ITestService.Stub{
 	private static final String TAG = "TestService";
 	private TestWorkerThread mWorker;
 	private TestWorkerHandler mHandler;
    private Context mContext;
    public TestService(Context Context){
    	super();
    	mContext = Context;
    	mWorker = new TestWorkerThread("TestServiceWorker");
    	mWorker.start();    
    	Log.i(TAG, "Spawned worker thread");
    }
    public void setValue(int val){
    	Log.i(TAG, "setValue" + val);
    	Message msg = Message.obtain();
    	msg.what = TestWorkerHandler.MESSAGE_SET;
    	msg.arg1 = val;
    	mHandler.sendMessage(msg);
    }
    private class TestWorkerThread extends Thread{
    	public TestWorkerThread(String name){
    		super(name);
    	}
    	public void run(){
    		Looper.prepare();
    		mHandler = new TestWorkerHandler();
    		Looper.loop();
    	}
    }
    private class TestWorkerHandler extends Handler{
    	private static final int MESSAGE_SET =0;
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
 }
