/** ResultState.java
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

@RDFNamespaces({
        "ffdq = http://example.com/ffdq/",
        "rdfs = http://www.w3.org/2000/01/rdf-schema#",
        "rs = http://example.com/ffdq/rs/"
})
@RDFBean("ffdq:ResultState")
public class ResultState {
    private String id;
    private String label;

    public ResultState(String label) {
        this.id = label.toLowerCase();
        this.label = label;
    }

    public ResultState() {
        // default constructor
    }

    @RDFSubject(prefix = "rs:")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @RDF("rdfs:label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    // for all tests
    
    public static ResultState INTERNAL_PREREQUISITES_NOT_MET = new ResultState("DATA_PREREQUISITES_NOT_MET");
    public static ResultState EXTERNAL_PREREQUISITES_NOT_MET = new ResultState("EXTERNAL_PREREQUISITES_NOT_MET");
    
    // for validations and measures
    
    public static ResultState RUN_HAS_RESULT = new ResultState("HAS_RESULT");

    // for amendments
    
    public static ResultState AMENDED = new ResultState("AMENDED");
    public static ResultState NOT_AMENDED = new ResultState("NOT_AMENDED");
    
    // State for an unused Response object
    public static ResultState NOT_RUN = new ResultState("NOT_RUN");
 
    // subtypes of amendments
    @Deprecated
    /** use ResultState.NOT_AMENDED with ambiguity described in comments.  */
    public static ResultState AMBIGUOUS = new ResultState("AMBIGUOUS");
    @Deprecated
    /**  use ResultState.AMENDED with note that empty values are being filled in in comments */
    public static ResultState FILLED_IN = new ResultState("FILLED_IN");
    @Deprecated
    /** use ResultState.AMENDED with transposition described in comments */
    public static ResultState TRANSPOSED = new ResultState("TRANSPOSED");

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ResultState) {
            return this.getId().equals(((ResultState)obj).getId());
        }

        return false;
    }
}
