package com.android.server;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.IShiftCharService;
import android.os.Message;
import android.os.Process;
import java.util.ArrayList;
import android.util.Log; 
public class ShiftCharService extends IShiftCharService.Stub {
	String str;
	private String RESULT_VALUE= "myPref";
	private Context scontext;
	private WorkerThread thread;
	private static final String TAG = "ShiftCharService";

	public ShiftCharService(Context context) {
        super();
        scontext=context;
        thread=new WorkerThread();
        thread.start();
	}

	public void setValue(String N, String num) {
		int i=Integer.parseInt(num);
		ArrayList<String> Name = new ArrayList<>();
		Name.add( N.toString()) ;
		String s="";
		for (String n:Name)
   			s+= n;
		char[] c = s.toCharArray();
		for(int no=i;no>0;no--) {
   			char last = c[c.length - 1];         
 			for (int index = c.length - 2; index >= 0; index--)
           		c[index + 1] = c[index];
			c[0] = last;     
   		}
   		RESULT_VALUE=new String(c);
		    
    }

    public String getValue() {
    	return RESULT_VALUE;
    }

	private class WorkerThread extends Thread{
		public void run(){
			Looper.prepare();
			Looper.loop();
		}
	}
}
				
            	
