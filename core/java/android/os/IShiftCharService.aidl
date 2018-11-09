/*
* aidl file : frameworks/base/core/java/android/os/IShiftCharService.aidl
* This file contains definitions of functions which are exposed by service
*/

package android.os;

/**
 *  {@hide}
 */
interface IShiftCharService{
	void setValue(String name,String num);
	String getValue();
}
