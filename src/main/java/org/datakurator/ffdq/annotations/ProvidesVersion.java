package org.datakurator.ffdq.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * In the @ProvidesVersion(value) annotation, the value is the Term IRI  
 * for a test that is implemented by the annotated method suffixed by 
 * a / and the DateLastModified for the test.  Note that this is 
 * different from the IRI, where the Term IRI is suffixed by a - and 
 * the issued date.
 * 
 * Created by Paul J. Morris on 2023-06-05.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ProvidesVersion {
    String value();
}
