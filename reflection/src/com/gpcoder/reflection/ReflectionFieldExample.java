package com.gpcoder.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ReflectionFieldExample {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // Lấy ra đối tượng mô tả class Cat
        Class<Cat> catClass = Cat.class;

        // Lấy ra toàn bộ field được khai báo là public
        // Kể cả các field được kế thừa và interface
        System.out.println("\nFields: ");
        Field[] fields = catClass.getFields();
        for (Field field : fields) {
            System.out.println(" + " + field.getName());
        }

        // Lấy ra field có tên là NUMBER_OF_LEGS
        System.out.println("- Public field: ");
        Field numberOfLegs = catClass.getField("NUMBER_OF_LEGS");

        // Lấy thông tin kiểu của field
        Class<?> type = numberOfLegs.getType();
        System.out.println(" + Type of field numberOfLegs is " + type.getSimpleName());

        // Khởi tạo đối tượng cat
        Cat tom = new Cat("Tom", 3);

        // Lấy ra giá trị của age theo cách của reflection
        Field ageField = catClass.getDeclaredField("age");
        ageField.setAccessible(true);
        System.out.println("Tom age: " + ageField.get(tom));
        ageField.set(tom, 10);
        System.out.println("Tom age: " + ageField.get(tom));

        // Lấy ra annotation của field
        Annotation[] annotations = ageField.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getSimpleName() );
        }

    }
}
