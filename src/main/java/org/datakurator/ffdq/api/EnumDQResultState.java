package org.datakurator.ffdq.api;

/**
 * Created by lowery on 12/14/16.
 */
public enum EnumDQResultState {
    NOT_RUN,
    AMBIGUOUS, 
    INTERNAL_PREREQISITES_NOT_MET,
    EXTERNAL_PREREQUISITES_NOT_MET,
    COMPLETED;
}
