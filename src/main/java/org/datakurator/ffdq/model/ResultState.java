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

/**
 * Class corresponding to bdqffdq:ResponseStatus.
 *
 * The labels of RUN_HAS_RESULT, AMENDED, NOT_AMENDED, FILLED_IN, INTERNAL_PREREQUISITES_NOT_MET, and
 * EXTERNAL_PREREQUISITES_NOT_MET are those of the bdqffdq:ResponseStatus terms of the BDQ standard
 * (e.g. https://rs.tdwg.org/bdqffdq/terms/RUN_HAS_RESULT).  NOT_RUN, for a response object that
 * has not been run, and the deprecated AMBIGUOUS and TRANSPOSED are not BDQ terms, and should not
 * be returned by implementations of BDQ Tests.
 *
 * This API has no RDF dependencies.  kurator-ffdq writes a ResultState as RDF (in
 * org.datakurator.ffdq.rdf.FfdqApiRdf) as its bdqffdq:ResponseStatus term.
 */
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    // for all tests
    
    public static ResultState INTERNAL_PREREQUISITES_NOT_MET = new ResultState("INTERNAL_PREREQUISITES_NOT_MET");
    public static ResultState EXTERNAL_PREREQUISITES_NOT_MET = new ResultState("EXTERNAL_PREREQUISITES_NOT_MET");
    
    // for validations and measures
    
    public static ResultState RUN_HAS_RESULT = new ResultState("RUN_HAS_RESULT");

    // for amendments
    
    public static ResultState AMENDED = new ResultState("AMENDED");  // non-empty value was changed
    public static ResultState NOT_AMENDED = new ResultState("NOT_AMENDED");  // value was not changed
    public static ResultState FILLED_IN = new ResultState("FILLED_IN");  // empty value was filled in
    
    // State for an unused Response object
    public static ResultState NOT_RUN = new ResultState("NOT_RUN");
 
    // subtypes of amendments
    @Deprecated
    /** use ResultState.NOT_AMENDED with ambiguity described in comments or response.qualifiers. */
    public static ResultState AMBIGUOUS = new ResultState("AMBIGUOUS");
    @Deprecated
    /** use ResultState.AMENDED with transposition described in comments or response qualifiers */
    public static ResultState TRANSPOSED = new ResultState("TRANSPOSED");

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ResultState) {
            return this.getId().equals(((ResultState)obj).getId());
        }

        return false;
    }
}
