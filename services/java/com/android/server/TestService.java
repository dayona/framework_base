 package com.android.server;
 import android.content.Context;
 import android.os.Handler;
 import android.os.ITestService;
 import android.os.Looper;
 import android.os.Message;
 import android.os.Process;
 import android.util.Log;
 import com.android.server.TestWorkerThread;
 import com.android.server.TestWorkerHandler;
 public class TestService extends ITestService.Stub{
 	private static final String TAG = "TestService";
 	TestWorkerThread mWorker;
 	TestWorkerHandler mHandler;
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
}
