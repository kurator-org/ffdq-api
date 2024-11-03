package org.datakurator.ffdq.api.result;

import org.datakurator.ffdq.api.ResultValue;
import org.datakurator.ffdq.model.Entity;
/**
 * Class corresponding to object of bdqffdq:hasResponseResult for a bdqffdq:IssueAssertion.
 */
public class IssueValue implements ResultValue {
    private final String value;

    private IssueValue(String value) {
        if (value.equalsIgnoreCase("IS_ISSUE") || value.equalsIgnoreCase("NOT_ISSUE") || value.equalsIgnoreCase("POTENTIAL_ISSUE")) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Invalid value " + value + " for a validation result. Must one of " +
                   "\"IS_ISSUE\", \"POTENTIAL_ISSUE\" or \"NOT_ISSUE\".");
        }
    }

    @Override
    public String getObject() {
        return value;
    }

    @Override
    public Entity getEntity() {
        Entity entity = new Entity();
        entity.setValue(value);

        return entity;
    }

    public static IssueValue IS_ISSUE = new IssueValue("IS_ISSUE");
    public static IssueValue NOT_ISSUE = new IssueValue("NOT_ISSUE");
    public static IssueValue POTENTIAL_ISSUE = new IssueValue("POTENTIAL_ISSUE");
    
    public String getLabel() { 
    	return value;
    }
    
}
