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

import java.util.UUID;

/**
 * Representation of prov:Entity that can be used as an abstraction
 * of data objects associated with responses from tests (as objects
 * for bdqffdq:hasResponseResult and other properties associated with
 * bdqffdq:Assertion).
 * 
 * This API has no RDF dependencies.  kurator-ffdq writes an Entity as RDF (in
 * org.datakurator.ffdq.rdf.FfdqApiRdf) as a prov:Entity with the id as its subject
 * and the value as its prov:value.
 */
public class Entity {
    private String id = "urn:uuid:" + UUID.randomUUID();
    private Object value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
