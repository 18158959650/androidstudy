package me.study.remoteapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

public class DemoService extends Service {

    ICalcInterface.Stub binder = new ICalcInterface.Stub() {
        @Override
        public int add(int num1, int num2) throws RemoteException {
            return num1 + num2;
        }
    };

    public DemoService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "后台服务已运行", Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return binder;
    }
}
