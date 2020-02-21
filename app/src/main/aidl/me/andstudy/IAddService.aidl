// IAddService.aidl
package me.andstudy;

import android.os.Bundle;
import android.os.IBinder;
import java.util.Map;
import java.util.List;

import me.andstudy.ICallback;
import me.andstudy.binder.CustomType;
// Declare any non-default types here with import statements

interface IAddService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
     int add(int num1, int num2);

     Bundle funBundle(inout Bundle bundle);

     void funHashmap(in Map map);

     void funList(in List list);

     void funBinder(ICallback callback);

     void funCustomType(in CustomType customType);
}
