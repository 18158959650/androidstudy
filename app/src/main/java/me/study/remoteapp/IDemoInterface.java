/*
 * This file is auto-generated.  DO NOT MODIFY.
 * 由AIDL文件自动生成，移到此处便于研究学习。
 */
package me.study.remoteapp;

public interface IDemoInterface extends android.os.IInterface {
    /**
     * Local-side IPC implementation stub class.
     */
    abstract class Stub extends android.os.Binder implements IDemoInterface {
        private static final String DESCRIPTOR = "me.study.remoteapp.IDemoInterface";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an me.me.andstudy.binder.IDemoInterface interface,
         * generating a proxy if needed.
         */
        public static IDemoInterface asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            // 客户端和服务端在同一个进程中
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof IDemoInterface))) {
                return ((IDemoInterface) iin);
            }
            // 客户端和服务端不在同一个进程中
            return new Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            String descriptor = DESCRIPTOR;
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(descriptor);
                    return true;
                }
                case TRANSACTION_showMessage: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    this.showMessage(_arg0);
                    reply.writeNoException();
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }

        /**
         * 不同进程间通讯处理
         */
        private static class Proxy implements IDemoInterface {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            /**
             * Demonstrates some basic types that you can use as parameters
             * and return values in AIDL.
             *///    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);
            @Override
            public void showMessage(String message) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();

                try {
                    // 保存接口名称 函数编号 参数值
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(message);
                    // 读取接口函数相关数据
                    mRemote.transact(Stub.TRANSACTION_showMessage, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_showMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    }

    /**
     * 以下是客户端与服务端的接口函数
     */
    void showMessage(String message) throws android.os.RemoteException;
}
