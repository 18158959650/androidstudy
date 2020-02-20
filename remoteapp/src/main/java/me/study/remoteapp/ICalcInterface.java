/*
 * This file is auto-generated.  DO NOT MODIFY.
 * 由AIDL文件自动生成，移到此处便于研究学习。
 */
package me.study.remoteapp;

public interface ICalcInterface extends android.os.IInterface {
    /**
     * Local-side IPC implementation stub class.
     */
    abstract class Stub extends android.os.Binder implements ICalcInterface {
        private static final String DESCRIPTOR = "me.study.remoteapp.ICalcInterface";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an me.me.andstudy.binder.ICalcInterface interface,
         * generating a proxy if needed.
         */
        public static ICalcInterface asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            // 客户端和服务端在同一个进程中
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof ICalcInterface))) {
                return ((ICalcInterface) iin);
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
                case TRANSACTION_add: {
                    data.enforceInterface(descriptor);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _result = this.add(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result);
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
        private static class Proxy implements ICalcInterface {
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
            public int add(int num1, int num2) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();

                int _result;
                try {
                    // 保存接口名称 函数编号 参数值
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(num1);
                    _data.writeInt(num2);
                    // 读取接口函数相关数据
                    mRemote.transact(Stub.TRANSACTION_add, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }
        }

        static final int TRANSACTION_add = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    }

    /**
     * 以下是客户端与服务端的接口函数
     */
    int add(int num1, int num2) throws android.os.RemoteException;
}
