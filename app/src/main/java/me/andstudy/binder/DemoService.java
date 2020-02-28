package me.andstudy.binder;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.List;
import java.util.Map;

import me.andstudy.IAddService;
import me.andstudy.ICallback;


public class DemoService extends Service {

    private Handler handler;

    IDemoInterface.Stub binder = new IDemoInterface.Stub() {
        @Override
        public void showMessage(final String message) throws RemoteException {

            System.out.println(message);

        }
    };

    IAddService.Stub addBinder = new IAddService.Stub() {
        @Override
        public int add(int num1, int num2) throws RemoteException {

            final int result = num1 + num2;
            if (result > 0) {
                throw new RuntimeException("error");
            }
//            // 如果服务在另外一个进程中 接口函数都是在线程中运行
//            // ui操作需要post到主线程中
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(DemoService.this, "远程服务返回:" + result, Toast.LENGTH_LONG)
//                            .show();
//                }
//            });

//            Toast.makeText(DemoService.this, "远程服务返回:" + result, Toast.LENGTH_LONG)
//                    .show();

            return result;
        }

        @Override
        public Bundle funBundle(Bundle bundle) throws RemoteException {
            return null;
        }

        @Override
        public void funHashmap(Map map) throws RemoteException {

        }

        @Override
        public void funList(List list) throws RemoteException {

        }

        @Override
        public void funBinder(ICallback callback) throws RemoteException {

        }

        @Override
        public void funCustomType(CustomType customType) throws RemoteException {

        }
    };

    public DemoService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler(getMainLooper());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return addBinder;
    }
}
