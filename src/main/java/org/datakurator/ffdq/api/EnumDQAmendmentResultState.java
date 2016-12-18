package org.datakurator.ffdq.api;

/**
 * Result types reflecting result states of amendment results.
 * Not actually an enum, but an extension of EnumDQResultState using the ResultState interface.
 * 
 * @author mole
 *
 */
public class EnumDQAmendmentResultState {

	// values from EnumDQResultState
	public static final ResultState NOT_RUN = EnumDQResultState.resultTypeFor("NOT_RUN", false);
	public static final ResultState AMBIGUOUS = EnumDQResultState.resultTypeFor("AMBIGUOUS", true);
	public static final ResultState INTERNAL_PREREQUISITES_NOT_MET  = EnumDQResultState.resultTypeFor("INTERNAL_PREREQUISITES_NOT_MET", true);
	public static final ResultState EXTERNAL_PREREQUISITES_NOT_MET = EnumDQResultState.resultTypeFor("EXTERNAL_PREREQUISITES_NOT_MET", true);
	public static final ResultState COMPLETED = EnumDQResultState.resultTypeFor("COMPLETED", true);
	
	// extended values for amendments
	public static final ResultState TRANSPOSED = EnumDQResultState.resultTypeFor("TRANSPOSED", true); 
	public static final ResultState CHANGED = EnumDQResultState.resultTypeFor("CHANGED", true); 
	public static final ResultState NO_CHANGE = EnumDQResultState.resultTypeFor("NO_CHANGE", true); 
	
}
