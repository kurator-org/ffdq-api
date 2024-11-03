/** DQAmendmentResponse.java
 * Copyright 2016 President and Fellows of Harvard College
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
package org.datakurator.ffdq.api;

import java.util.Map;

/**
 * Interface for bdqffdq:AmendmentAssertion.
 * 
 * Created by lowery on 12/14/16.
 * 
 * @author lowery
 * @author mole 
 */
public interface DQAmendmentResponse {
	/**
	 * Obtain the result state (completed or some problem condition) of the amendment.
	 * 
	 * @return the result state of the test that attempted to assert an amendment, EnumDQResultState.COMPLETED if successful.
	 * 
	 * @see org.datakurator.ffdq.api.EnumDQResultState
	 */
    ResultState getResultState();
    /**
     * Obtain a map of keys and values for the terms and new values proposed by the amendment.
     * 
     * @return a Map key, value of the new values and the terms they are proposed to apply to.
     */
    Map<String, String> getResult();
    /**
     * Obtain the human readable comments associated with the proposed amendment.
     * 
     * @return a string comment.
     */
    String getComment();
}
