package com.gpcoder.combine;

import java.lang.annotation.*;

/**
 * Annotation sử dụng để đánh dấu đây là một phần cha và giá trị của nó là một Collection (có chứa tài liệu xml con).
 */
@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlElementWrapper {
    String name();
}
