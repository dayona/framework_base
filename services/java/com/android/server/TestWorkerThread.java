package com.android.server;
import android.os.Looper;
import android.os.Handler;
import com.android.server.TestWorkerHandler;

public class TestWorkerThread extends Thread {
		TestWorkerHandler mHandler;

    	public TestWorkerThread(String name){
    		super(name);
    	}
    	public void run(){
    		Looper.prepare();
    		mHandler = new TestWorkerHandler();
    		Looper.loop();
    	}
}