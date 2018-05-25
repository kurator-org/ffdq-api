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
public class EnumDQResultState {
	
	// values from EnumDQResultState
	public static final ResultState NOT_RUN = EnumActualDQResultState.resultTypeFor("NOT_RUN", false);
	public static final ResultState AMBIGUOUS = EnumActualDQResultState.resultTypeFor("AMBIGUOUS", true);
	public static final ResultState INTERNAL_PREREQUISITES_NOT_MET  = EnumActualDQResultState.resultTypeFor("INTERNAL_PREREQUISITES_NOT_MET", true);
	public static final ResultState EXTERNAL_PREREQUISITES_NOT_MET = EnumActualDQResultState.resultTypeFor("EXTERNAL_PREREQUISITES_NOT_MET", true);
	public static final ResultState RUN_HAS_RESULT = EnumActualDQResultState.resultTypeFor("RUN_HAS_RESULT", true);
	
}
