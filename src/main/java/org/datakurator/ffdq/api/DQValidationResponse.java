/** DQValidationResponse.java
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

/**
 * Created by lowery on 12/14/16.
 * 
 * @author lowery
 * @author mole
 */
public interface DQValidationResponse {
	
	/**
	 * Obtain the result state (completed or some problem condition) of the validation.
	 * 
	 * @return the result state of the test that attempted to perform a validation, EnumDQResultState.RUN_HAS_RESULT if successful.
	 */
	ResultState getResultState();
    
    /**
     * Obtain the result of the validation test.
     * 
     * @return the result of the test.
     */
    EnumDQValidationResult getResult();
    
    /**
     * Obtain the human readable comments associated with the validation.
     * 
     * @return a string comment.
     */
    String getComment();
}
