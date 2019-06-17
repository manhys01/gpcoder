package com.gpcoder.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionMethodExample {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Class<Cat> catClass = Cat.class;
        Method[] declaredMethods = catClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }

        Method setNameMethod = catClass.getDeclaredMethod("setName", String.class);
        System.out.println((Modifier.isPrivate(setNameMethod.getModifiers()) ? "private " : " ") +  setNameMethod.getName());

        Cat tom = new Cat("tom", 0);
        System.out.println(tom);
        Method setAgeMethod = catClass.getDeclaredMethod("setAge", int.class);
        setAgeMethod.invoke(tom, 1);
        System.out.println(tom);



    }
}
