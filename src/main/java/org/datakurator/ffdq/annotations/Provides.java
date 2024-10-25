package org.datakurator.ffdq.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * In the @Provides(value) annotation, the value is the term_localName 
 * for a test that is implemented by the annotated method.
 * 
 * Created by lowery on 12/14/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Provides {
    String value();
}
