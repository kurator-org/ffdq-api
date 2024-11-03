package org.datakurator.ffdq.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for a method corresponding to an implementation of a bdqffdq:Validation.
 * 
 * Created by lowery on 12/19/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Validation {
    String label();
    String description();
}
