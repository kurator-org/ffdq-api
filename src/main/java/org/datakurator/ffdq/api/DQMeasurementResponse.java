/** DQMeasurementResponse.java
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
 * Interface for returning results from FIT4U Framework measurements.
 * 
 * @author mole 
 */
public interface DQMeasurementResponse {
	
	/**
	 * Obtain the result state (completed or some problem condition) of the measurement.
	 * 
	 * @return the result state of the test that attempted to meake a mesaurement, EnumDQResultState.COMPLETED if successful.
	 */	
	
    EnumDQValidationState getResultState();
    /**
     * Obtain the value of the measurement.
     * 
     * @return the value of the measurement (which may be a DQMesurementResult or a numeric value.
     */
    Object getValue();
    
    /**
     * Obtain the human readable comments associated with the proposed amendment.
     * 
     * @return a string comment.
     */    
    String getComment();
}
