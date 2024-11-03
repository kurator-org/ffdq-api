/**
 * DQIssueResponse.java
 * 
 * Copyright 2022 President and Fellows of Harvard College
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
 * Interface for bdqffdq:IssueAssertion.
 * 
 * Interface for responses for Issues from Problems, inverse of DQValidationResponse.
 * 
 * @author mole
 *
 */
public interface DQIssueResponse {
	
	/**
	 * Obtain the result state (completed or some problem condition) of the issue.
	 * 
	 * @return the result state of the test that attempted to perform a issue, EnumDQResultState.RUN_HAS_RESULT if successful.
	 */
	ResultState getResultState();
    
    /**
     * Obtain the result of the problem test.
     * 
     * @return the result of the test.
     */
    EnumDQValidationResult getResult();
    
    /**
     * Obtain the human readable comments associated with the issue.
     * 
     * @return a string comment.
     */
    String getComment();

}
