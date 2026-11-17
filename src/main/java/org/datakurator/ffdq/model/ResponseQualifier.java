/** ResponseQualifier.java
 *
 * Copyright 2026 President and Fellows of Harvard College
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
 * A Response.qualifier: structured information that qualifies a Response beyond its status, result,
 * and comment, corresponding to bdqffdq:ResponseQualifier (related to a Response by
 * bdqffdq:hasResponseQualifier).
 *
 * The BDQ standard defines bdqffdq:ResponseQualifier only as an extension point, "intended for
 * qualifying information about uncertainty or ambiguity", and prescribes no structure for it.  This
 * class is a proof of concept of such a structure: a label naming the kind of qualification (e.g.
 * {@value #AMBIGUOUS}), an optional value (e.g. a potential interpretation of the data), and an
 * optional human-readable comment.  Neither the labels nor this structure are BDQ terms.
 */
public class ResponseQualifier {

    /** Label for a qualifier stating that the data could be interpreted in more than one way. */
    public static final String AMBIGUOUS = "AMBIGUOUS";

    private String label;
    private String value;
    private String comment;

    public ResponseQualifier() {
        // default constructor
    }

    /**
     * @param label the kind of qualification, e.g. {@value #AMBIGUOUS}
     * @param value an optional value, e.g. a potential interpretation of the data, or null
     * @param comment an optional human-readable comment, or null
     */
    public ResponseQualifier(String label, String value, String comment) {
        this.label = label;
        this.value = value;
        this.comment = comment;
    }

    /** @return the kind of qualification, e.g. {@value #AMBIGUOUS} */
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    /** @return the qualifying value, e.g. a potential interpretation of the data, or null */
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /** @return a human-readable comment, or null */
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return label + (value == null ? "" : " [" + value + "]") + (comment == null ? "" : ": " + comment);
    }
}
