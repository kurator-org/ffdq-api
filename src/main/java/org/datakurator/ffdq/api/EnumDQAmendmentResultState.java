package org.datakurator.ffdq.api;

/**
 * Result types reflecting result states of amendment results.
 * Not actually an enum, but an extension of EnumDQResultState using the ResultState interface.
 * 
 * @author mole
 *
 */
public class EnumDQAmendmentResultState extends EnumDQResultState {

	// extended values for amendments
	public static final ResultState TRANSPOSED = EnumActualDQResultState.resultTypeFor("TRANSPOSED", true); 
	public static final ResultState AMENDED = EnumActualDQResultState.resultTypeFor("AMENDED", true);
	public static final ResultState FILLED_IN = EnumActualDQResultState.resultTypeFor("FILLED_IN", true);
	public static final ResultState NOT_AMENDED = EnumActualDQResultState.resultTypeFor("NOT_AMENDED", true); 
	
}
