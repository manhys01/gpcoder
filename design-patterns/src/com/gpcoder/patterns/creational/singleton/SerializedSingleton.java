package com.gpcoder.patterns.creational.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Đôi khi trong các hệ thống phân tán (distributed system),
 * chúng ta cần implement interface Serializable trong lớp Singleton
 * để chúng ta có thể lưu trữ trạng thái của nó trong file hệ thống và truy xuất lại nó sau.
 */
public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = 1741825395699241705L;

    private SerializedSingleton() {
    }

    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }

    /**
     * Special hook provided by serialization where developer can control what object needs to sent.
     * However this method is invoked on the new object instance created by de serialization process.
     *
     * @return
     * @throws ObjectStreamException
     */
//    private Object readResolve() throws ObjectStreamException {
//        return SingletonHelper.instance;
//    }
}
