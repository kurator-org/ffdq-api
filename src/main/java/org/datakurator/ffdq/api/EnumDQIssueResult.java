/**
 * EnumDQIssueResult.java
 */
package org.datakurator.ffdq.api;

/**
 * Enumeration of the possible results from an Issue/Problem, inverse of 
 * EnumDQValidationResult, but includes POTENTIAL_ISSUE to flag potential 
 * data quality issues that need human evaluation.
 * 
 * @author mole
 *
 */
public enum EnumDQIssueResult {
	
	ISSUE,
	POTENTIAL_ISSUE,
	NO_ISSUE

}
