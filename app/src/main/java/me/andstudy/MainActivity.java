package me.andstudy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import me.andstudy.binder.IDemoInterface;
import me.study.remoteapp.ICalcInterface;

public class MainActivity extends AppCompatActivity {

    private IDemoInterface demoInterface;
    private IAddService addService;
    private ICalcInterface calcInterface;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
//            demoInterface = IDemoInterface.Stub.asInterface(iBinder);
//            try {
//                demoInterface.showMessage("Hello");
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }

            addService = IAddService.Stub.asInterface(iBinder);
            try {
                int result = addService.add(1, 2);
                Toast.makeText(MainActivity.this, String.valueOf(result), Toast.LENGTH_LONG)
                        .show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG)
                        .show();
            }

//            calcInterface = ICalcInterface.Stub.asInterface(iBinder);
//            try {
//                int result = calcInterface.add(100, 200);
//                Toast.makeText(MainActivity.this, String.valueOf(result), Toast.LENGTH_LONG)
//                        .show();
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 绑定本地服务
        Intent intent = new Intent();
        intent.setPackage("me.andstudy");
        intent.setAction("me.andstudy.binder.DemoService");
//        Intent intent = new Intent(this, DemoService.class);
        // 绑定远程服务
//        intent.setPackage("me.study.remoteapp");
//        intent.setAction("DemoService");

        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
