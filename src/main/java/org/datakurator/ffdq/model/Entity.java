/** Entity.java
 *
 * Copyright 2017 President and Fellows of Harvard College
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.datakurator.ffdq.model;

import org.cyberborean.rdfbeans.annotations.RDF;
import org.cyberborean.rdfbeans.annotations.RDFBean;
import org.cyberborean.rdfbeans.annotations.RDFNamespaces;
import org.cyberborean.rdfbeans.annotations.RDFSubject;

import java.util.UUID;

/**
 * Representation of prov:Entity that can be used as an abstraction
 * of data objects associated with responses from tests (as objects
 * for bdqffdq:hasResponseResult and other properties associated with
 * bdqffdq:Assertion).
 * 
 * Enables serialization of results into RDF using RDFBeans.
 * 
 */
@RDFNamespaces({
        "bdqffdq = http://rs.tdwg.org/bdqffdq/terms/",
        "prov = http://www.w3.org/ns/prov#"
})
@RDFBean("prov:Entity")
public class Entity {
    private String id = "urn:uuid:" + UUID.randomUUID();
    private Object value;

    @RDFSubject
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @RDF("prov:value")
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
