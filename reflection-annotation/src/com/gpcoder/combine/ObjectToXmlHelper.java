package com.gpcoder.combine;

import sun.jvm.hotspot.runtime.ConstructionException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

public class ObjectToXmlHelper {

    private ObjectToXmlHelper() {
        throw new ConstructionException("Not support yet.");
    }

    public static <T> String convertToXml(T object) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("\n");
        sb.append(convertToXml(object, 0));
        return sb.toString();
    }

    private static <T> String convertToXml(T object, int numberOfTab) {
        StringBuilder sb = new StringBuilder();

        // Get class of object
        Class<?> objectClass = object.getClass();

        // Kiểm tra xem lớp này có được chú thích bởi XmlRootElement hay không?
        boolean isXmlDoc = objectClass.isAnnotationPresent(XmlRootElement.class);

        List<Field> fields;
        String name;
        String value;
        if (isXmlDoc) {
            // Lấy ra đối tượng XmlRootElement, chú thích trên lớp này
            XmlRootElement rootNode = objectClass.getAnnotation(XmlRootElement.class);

            sb.append(getTab(numberOfTab)); // add tab
            sb.append("<" + rootNode.name()); //
            if (isNotEmpty(rootNode.namespace())) {
                sb.append(" xmlns=\"" + rootNode.namespace() + "\"");
            }
            sb.append("\n");

            fields = getFields(objectClass, null);
            if (!fields.isEmpty()) {
                // Create xml elements
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.isAnnotationPresent(XmlElementWrapper.class)) {
                        sb.append(createXmlWrapper(field, object, numberOfTab + 1));
                    } else if (field.isAnnotationPresent(XmlElement.class)) {
                        sb.append(createXmlElement(field, object, numberOfTab + 2));
                    }
                }
            }
            sb.append(getTab(numberOfTab));
            sb.append("</" + rootNode.name() + ">");
        }
        return sb.toString();
    }

    private static boolean isNotEmpty(String str) {
        return str != null && !str.isEmpty();
    }

    private static <T> String createXmlElement(Field field, T object, int numberOfTab) {
        StringBuilder sb = new StringBuilder();
        XmlElement annotation = field.getAnnotation(XmlElement.class);

        String name = annotation.name();
        String value = getValueOfField(field, object);
        sb.append(getTab(numberOfTab));
        sb.append("<" + name + ">");
        sb.append(value);
        sb.append("</" + name + ">");
        sb.append("\n");
        return sb.toString();
    }

    private static <T> String createXmlWrapper(Field field, T object, int numberOfTab) {
        StringBuilder sb = new StringBuilder();
        XmlElementWrapper xmlElementWrapper = field.getAnnotation(XmlElementWrapper.class);
        String name = xmlElementWrapper.name(); // Get element's name
        sb.append(getTab(numberOfTab)); // create 1 tab
        sb.append("<" + name + ">"); // Start element
        sb.append("\n"); // Add new line
        Collection<?> listValueOfFields = getListValueOfFields(field, object);
        if (listValueOfFields != null && !listValueOfFields.isEmpty()) {
            // Create xml sub element
            for (Object collection : listValueOfFields) {
                sb.append(convertToXml(collection, numberOfTab + 1));
                sb.append("\n");
            }
        }
        sb.append(getTab(numberOfTab));
        sb.append("</" + name + ">");
        sb.append("\n");
        return sb.toString();
    }


    /**
     * Lấy giá trị của field
     *
     * @param field  Field
     * @param object Object
     * @return String
     */
    private static String getValueOfField(Field field, Object object) {
        String value = "";
        try {
            value = String.valueOf(field.get(object));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * Lấy về danh sách giá trị của field
     *
     * @param field  Field truyền vào
     * @param object Object truyền vào
     * @return Collection
     */
    private static Collection<?> getListValueOfFields(Field field, Object object) {
        Collection<?> collection = null;
        Object objectValue = null;
        try {
            objectValue = field.get(object);
            if (object instanceof Collection) {
                collection = (Collection<?>) objectValue;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return collection;
    }


    /**
     * Lấy danh sách field có sử dụng annotation
     *
     * @param clazz      Class có sử dụng annotation
     * @param annotation Class annotation
     * @param <T>        Kiểu của clazz
     * @return Danh sách field
     */
    private static <T> List<Field> getFields(Class<T> clazz, Class<? extends Annotation> annotation) {
        List<Field> fieldAttributes = new ArrayList<>();

        Field[] fields = clazz.getDeclaredFields();
        if (annotation == null) {
            fieldAttributes.addAll(Arrays.asList(fields));
        } else {
            for (Field field : fields) {
                if (field.isAnnotationPresent(annotation)) {
                    fieldAttributes.add(field);
                }
            }
        }
        return fieldAttributes;
    }


    /**
     * Lấy dấu tab
     *
     * @param numOfTab số dấu tab
     * @return String tab
     */
    private static String getTab(int numOfTab) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numOfTab; i++) {
            sb.append("\t"); // Thêm dấu tab
        }
        return sb.toString();
    }

}
