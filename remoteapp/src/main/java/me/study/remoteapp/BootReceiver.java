package me.study.remoteapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
    public BootReceiver() {
    }
    
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, DemoService.class);
        context.startService(service);
    }
}
