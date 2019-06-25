package com.gpcoder.annotation;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;

public class ObjectToXmlHelper {

    private ObjectToXmlHelper() {
        throw new UnsupportedOperationException();
    }

    public static <T> String convertToXml(T object) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("\n");
        sb.append(convertToXml(object, 0));
        return sb.toString();
    }

    private static <T> String convertToXml(T object, int tabNumber) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();

        Class<?> clazz = object.getClass();

        // kiem tra xem lop nay co duoc danh dau boi XmlRootElement hay khong
        boolean isXmlDoc = clazz.isAnnotationPresent(XmlRootElement.class);

        if (isXmlDoc) {
            // Lay ra doi tuong duoc chu thich tren lop nay
            XmlRootElement rootNode = clazz.getAnnotation(XmlRootElement.class);
            // them tab
            sb.append(getTab(tabNumber));
            String xmlTagName = rootNode.value().trim().isEmpty() ? clazz.getSimpleName() : rootNode.value();
            String namespace = rootNode.namespace().trim();
            sb.append("<").append(xmlTagName);
            sb.append(namespace.isEmpty() ? "" : " xmlns=\"" + namespace + "\"");
            sb.append(">");
            sb.append("\n");

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(XmlAttribute.class)) {
                    XmlAttribute annotation = field.getAnnotation(XmlAttribute.class);
                    String value = annotation.value();
                    String attribute = " ";
                    if (value.trim().isEmpty()) {
                        attribute += field.getName();
                    } else {
                        attribute += value;
                    }
                    attribute += "=\"" + field.get(object) + "\"";
                    sb.insert(sb.length() - 2, attribute);
                }
                if (field.isAnnotationPresent(XmlElement.class)) {
                    String xmlElement = createXmlElement(object, tabNumber + 1, field);
                    sb.append(xmlElement);
                } else if (field.isAnnotationPresent(XmlElementWrapper.class)) {
                    String xmlElementWrapper = createXmlElementWrapper(object, tabNumber, field);
                    sb.append(xmlElementWrapper);
                }
            }
            sb.append(getTab(tabNumber));
            sb.append("</").append(xmlTagName).append(">");
        }
        return sb.toString();
    }

    private static <T> String createXmlElementWrapper(T object, int tabNumber, Field field) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        XmlElementWrapper elementWrapper = field.getAnnotation(XmlElementWrapper.class);
        String annotationValue = elementWrapper.value();
        String tagName;
        if (annotationValue.trim().isEmpty()) {
            tagName = field.getName();
        } else {
            tagName = annotationValue;
        }
        Object value = field.get(object);
        if (value instanceof Collection) {
            Collection collection = (Collection) value;
            sb.append(getTab(tabNumber + 1));
            sb.append("<").append(tagName).append(">");
            sb.append("\n");
            for (Object o : collection) {
                sb.append(convertToXml(o, tabNumber + 2));
                sb.append("\n");
            }
            sb.append(getTab(tabNumber + 1));
            sb.append("</").append(tagName).append(">");
            sb.append("\n");
        }
        return sb.toString();
    }

    private static <T> String createXmlElement(T object, int tabNumber, Field field) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        if (object != null) {
            sb.append(getTab(tabNumber));
            XmlElement element = field.getAnnotation(XmlElement.class);
            String value = element.value();
            String tagName = "";
            if (value.trim().isEmpty()) {
                tagName += field.getName();
            } else {
                tagName += value;
            }
            sb.append("<").append(tagName).append(">");
            sb.append(field.get(object));
            sb.append("</").append(tagName).append(">");
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String getTab(int tabNumber) {
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < tabNumber; i++) {
            tab.append("\t");
        }
        return tab.toString();
    }

}
