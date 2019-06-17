package com.gpcoder.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class ReflectionClassExample {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        getClassInfo();
    }

    static void getClassInfo() throws ClassNotFoundException, NoSuchMethodException {
        System.out.println("- Class name: ");
        Class<?> aClass = Class.forName("com.gpcoder.reflection.Cat");
        System.out.println(" + Name: " + aClass.getName());
        System.out.println(" + Simple name: " + aClass.getSimpleName());


        Package aPackage = aClass.getPackage();
        System.out.println("\n- Package name: " + aPackage.getName());

        System.out.println("\n- Modifier");
        int modifiers = aClass.getModifiers();
        boolean isPublic = Modifier.isPublic(modifiers);
        boolean isAbstract = Modifier.isAbstract(modifiers);
        boolean isInterface = Modifier.isInterface(modifiers);
        boolean isFinal = Modifier.isFinal(modifiers);

        System.out.println(" + Is Public: " + isPublic);
        System.out.println(" + Is Abstract: " + isAbstract);
        System.out.println(" + Is Interface: " + isInterface);
        System.out.println(" + Is Final: " + isFinal);

        System.out.println("\n- Super class: ");
        Class<?> superclass = aClass.getSuperclass();
        System.out.println(" + Name: " + superclass.getName());
        System.out.println(" + Simple name: " + superclass.getSimpleName());

        System.out.println("\n- Interfaces: ");
        Class<?>[] interfaces = aClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(" + " + anInterface.getSimpleName());
        }

        System.out.println("\n- Constructors: ");
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(" + " + constructor.getName() + " has " + constructor.getParameterCount() + (constructor.getParameterCount() > 1 ? " params" : " param"));
        }


        System.out.println("\n- Declared methods: ");
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(" + " + method.getName());
        }

        System.out.println("\n- Declared fields: ");
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(" + " + field.getName());
        }

        System.out.println("\n- Annotations: ");
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(" + " + annotation.annotationType().getSimpleName());
        }

    }


}
