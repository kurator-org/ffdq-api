package org.datakurator.ffdq.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The specification annotation should have as its value the concatnated
 * bdqffdq:hasExpectedResponse and bdqffdq:hasAuthoritiesDefaults for 
 * a bdqffdq:Specification.
 * 
 * Created by lowery on 2/15/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Specification {
    String value();
}
