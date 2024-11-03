package org.datakurator.ffdq.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * Annotation for a method parameter corresponding to a bdqffdq:Parameter
 * which takes a bdqffdq:Argument value to alter the default behavior of a test.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Parameter {
    String name();
}
