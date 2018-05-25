/** EnumDQResultState.java
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

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Extensible enumeration of standard data quality test result types.
 * Applies generally to results of measurements, validations, and amendments.  
 * Extended for amendments.
 * 
 * Extensible using the method described in https://blogs.oracle.com/darcy/entry/enums_and_mixins 
 * used in javax.tools.StandardLocation, javax.tools.FileManager.Location 
 * 
 * Created by lowery on 12/14/16.
 * @author lowery
 * @author mole
 */
enum EnumActualDQResultState implements ResultState {
    NOT_RUN,
    AMBIGUOUS, 
    INTERNAL_PREREQUISITES_NOT_MET,
    EXTERNAL_PREREQUISITES_NOT_MET,
    RUN_HAS_RESULT;

	@Override
	public String getName() {
		// return the exact name of the enum instance.
		return name();
	}

	@Override
	public boolean isComplete() {
		boolean result = false;
		if(this==AMBIGUOUS ||
		   this==RUN_HAS_RESULT || 
		   this==INTERNAL_PREREQUISITES_NOT_MET ||
		   this==EXTERNAL_PREREQUISITES_NOT_MET
		   ) 
		{ 
			result = true;
		}
		return false;
	}
	
	/**
	 * Allow extension of the enumeration by adding strings that can lookup the ResultState.
	 */
    private static ConcurrentMap<String,ResultState> resultTypes = new ConcurrentHashMap<String,ResultState>();	
    
    /** Factory method to add result types to the enumeration.
     * 
     * @param name the name of the result type.
     * @param isComplete value to return on calling isComplete() on the returned resultType object.
     * 
     * @return a ResultState object conforming to the provided name and isComplete value
     */
    public static ResultState resultTypeFor(final String name, final boolean isComplete) {
    	// make sure that map of result types is populated with values from standard enum
        if (resultTypes.isEmpty()) {
        	for(EnumActualDQResultState c : EnumActualDQResultState.values()) {
                resultTypes.putIfAbsent(c.getName(), c);
        	}
        }
        // then, if it is new, add the provided string.
        resultTypes.putIfAbsent(
        		name.toString(), 
        		new ResultState() {
                    public String getName() { 
                    	return name; 
                    }
                    public boolean isComplete() { 
                	     return isComplete; 
                    }
                }
        );
        return resultTypes.get(name);
    }
}
