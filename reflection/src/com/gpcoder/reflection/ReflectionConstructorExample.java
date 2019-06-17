package com.gpcoder.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionConstructorExample {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // Lấy ra đối tượng mô tả class
        Class<Cat> catClass = Cat.class;

        // Lấy ra hàm khởi tạo có tham số (String, int)
        Constructor<Cat> catConstructor = catClass.getConstructor(String.class, int.class);

        // Lấy ra thông tin kiểu tham số của hàm tạo
        System.out.println("\n- Params: ");
        for (Class<?> parameterType : catConstructor.getParameterTypes()) {
            System.out.println(" + " + parameterType.getSimpleName());
        }

        // Khởi tạo đối tượng theo cách thông thường
        Cat tom1 = new Cat("Tom", 3);
        System.out.println(tom1);

        // Khởi tạo đối tượng theo reflection
        Constructor<Cat> constructor = Cat.class.getConstructor(String.class, int.class);
        Cat tom2 = constructor.newInstance("Tom", 3);
        System.out.println(tom2);
    }
}
