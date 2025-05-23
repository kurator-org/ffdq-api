/** AmendmentValue.java
 *
 * Copyright 2017 President and Fellows of Harvard College
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
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
package org.datakurator.ffdq.api.result;

import org.datakurator.ffdq.api.ResultValue;
import org.datakurator.ffdq.model.Entity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Class corresponding to object of bdqffdq:hasResponseResultValue for a bdqffdq:AmendmentAssertion,
 * with the value represented as a map of key:value pairs, with the term for which a change is 
 * proposed as a key and the proposed new value as the value.
 */
public class AmendmentValue implements ResultValue {
    private int score = 1; // TODO: For ranking of alternatives

    private String uuid = "urn:uuid:" + UUID.randomUUID();
    private Map<String, String> value = new HashMap<String, String>();

    public AmendmentValue(Map<String, String> value) {
        this.value = value;
    }

    @Override
    public Map<String, String> getObject() {
        return value;
    }

    @Override
    public Entity getEntity() {
        try {
            Entity entity = new Entity();
            entity.setValue(new URI(uuid));

            return entity;
        } catch (URISyntaxException e) {
            throw new RuntimeException("Invalid data resource uri", e);
        }
    }
}
