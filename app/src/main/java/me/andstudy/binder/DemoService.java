package me.andstudy.binder;

import android.app.Service;
import android.content.Intent;
import android.os.Debug;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;


public class DemoService extends Service {

    IDemoInterface.Stub binder = new IDemoInterface.Stub() {
        @Override
        public void showMessage(String message) throws RemoteException {
            Toast.makeText(DemoService.this, message, Toast.LENGTH_LONG)
                    .show();

        }
    };

//    IAddService.Stub addBinder = new IAddService.Stub() {
//        @Override
//        public int add(int num1, int num2) throws RemoteException {
//            return num1 + num2;
//        }
//    };

    public DemoService() {
        Debug.waitForDebugger();
    }
    
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return binder;
    }
}
