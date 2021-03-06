package com.gpcoder.combine;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlAttribute {
    String name();
}
