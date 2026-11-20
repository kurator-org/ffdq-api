# ffdq-api

API for making Fittness For Use Framework assertions in Data Quality reports.


[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.891415.svg)](https://doi.org/10.5281/zenodo.891415)



# Include using maven

Available in Maven Central

    <dependency>
        <groupId>org.datakurator</groupId>
        <artifactId>ffdq-api</artifactId>
        <version>3.0.0</version>
    </dependency>

# Using

This project is intended to serve as an API between generic implementations of data quality buisness logic and an overlying layer which outputs reports using the concepts of the Fitt4U Framework.  

A example of a layering of this API with other components can be visualzed as: 

    kurator-akka - workflow framework to run actors composed into workflows.

    kurator-ffdq - actors that obtain Darwin Core data and invoke internals to make data quality assertions in terms of the Fit4U Framework.

    ffdq-api - API to connect actors to internals

    event_date_qc - implementation of buisness logic for making data quality assertions about Darwin Core Event terms.


## Annotations

Provides a set of annotations that can be applied to methods to allow them to be used with Fitness For Use Framework reports.  
Annotations available are Provides, PreEnhancement, PostEnhancement, ActedUpon, and Consulted.  An example of the use of each of these follows:

    @Provides(value = "EVENTDATE_FILLED_IN_FROM_VERBATIM")
    @PreEnhancement
    @PostEnhancement
    public static EventDQAmendment extractDateFromVerbatim(@ActedUpon(value = "dwc:eventDate") String eventDate, @Consulted(value = "dwc:verbatimEventDate") String verbatimEventDate) { 
    

## Interfaces

Interfaces are provided to support reporting from methods that implement the internal buisness logic of data quality operations to workflow actors that make assertions in terms of the Fit4U Framework, these interfaces allow tests that perform measurements, validations, or propose amendments to report status of the test using a controled vocabulary, the value returned from the test, and human readable comments on the tests. 

The following unit test demonstrates use of an implementation of the DQMeaurementResponse interface (which provides getResultState(), getValue(), and getComment() methods) returned from a method (that could be used to report a data quality measure), which measures the number of seconds in a Darwin Core eventDate:

    @Test
    public void testMeasureDuration() { 
        DQMeasurementResponse<Long> measure = DwCEventDQ.measureDurationSeconds("1880-05-08");
        Long seconds = (60l*60l*24l)-1l; 
        assertEquals(seconds, measure.getValue());
        assertEquals(EnumDQResultState.RUN_HAS_RESULT, measure.getResultState());
        
        measure = DwCEventDQ.measureDurationSeconds("1880-05");
        seconds = (60l*60l*24l*31)-1l; 
        assertEquals(seconds, measure.getValue());      
        assertEquals(EnumDQResultState.RUN_HAS_RESULT, measure.getResultState());
        
        measure = DwCEventDQ.measureDurationSeconds("");
        assertEquals(EnumDQResultState.INTERNAL_PREREQUISITES_NOT_MET, measure.getResultState());
        System.out.println(measure.getComment());
    }

Constants are provided for validation results (COMPLIANT, NOT_COMPLIANT) and measurement results (COMPLETE, NOT_COMPLETE) for mapping onto data quality reports, and for test result states (NOT_RUN, RUN_HAS_RESULT, AMBIGUOUS, INTERNAL_PREREQUSITES_NOT_MET, EXTERNAL_PREREQUISITES_NOT_MET) for handing test success or error conditions, and for result states specific to ammendment results (TRANSPOSED, FILLED_IN, CHANGED).


# Building

    mvn install

# Developer deployment: 

To deploy a snapshot to the snapshotRepository:

    mvn clean deploy

To deploy a new release to maven central, set the version in pom.xml to a non-snapshot version, then deploy with the release profile (which adds package signing and deployment to release staging:

    mvn clean deploy -P release

## Related BDQ libraries and applications

This library is one of a set of libraries and applications for the draft TDWG [BDQ Standard](https://bdq.tdwg.org/) (Biodiversity Data Quality), about to go into public review ([review draft](https://bdq.tdwg.org/draft/)). None of them are part of the standard.

| Repository | Kind | Role | Available from |
|---|---|---|---|
| [ffdq-api](https://github.com/kurator-org/ffdq-api) (this repository) | Library | Java annotations and result API for Test implementations | [Maven Central](https://central.sonatype.com/artifact/org.datakurator/ffdq-api), [latest release](https://github.com/kurator-org/ffdq-api/releases/latest) |
| [kurator-ffdq](https://github.com/kurator-org/kurator-ffdq) | Library | bdqffdq model, RDF reports, Test RDF generation and Test runner | [Maven Central](https://central.sonatype.com/artifact/org.datakurator/kurator-ffdq), [latest release](https://github.com/kurator-org/kurator-ffdq/releases/latest) |
| [sci_name_qc](https://github.com/FilteredPush/sci_name_qc) | Test implementations | NAME Tests | [Maven Central](https://central.sonatype.com/artifact/org.filteredpush/sci_name_qc), [latest release](https://github.com/FilteredPush/sci_name_qc/releases/latest) |
| [event_date_qc](https://github.com/FilteredPush/event_date_qc) | Test implementations | TIME Tests | [Maven Central](https://central.sonatype.com/artifact/org.filteredpush/event_date_qc), [latest release](https://github.com/FilteredPush/event_date_qc/releases/latest) |
| [rec_occur_qc](https://github.com/FilteredPush/rec_occur_qc) | Test implementations | OTHER (metadata) Tests and SingleRecord Measures | [Maven Central](https://central.sonatype.com/artifact/org.filteredpush/rec_occur_qc), [latest release](https://github.com/FilteredPush/rec_occur_qc/releases/latest) |
| [geo_ref_qc](https://github.com/FilteredPush/geo_ref_qc) | Test implementations | SPACE Tests | [Maven Central](https://central.sonatype.com/artifact/org.filteredpush/geo_ref_qc), [latest release](https://github.com/FilteredPush/geo_ref_qc/releases/latest) |
| [bdqtestrunner](https://github.com/FilteredPush/bdqtestrunner) | Application | Checks Test implementations against the BDQ Test validation data | [latest release](https://github.com/FilteredPush/bdqtestrunner/releases/latest) |
| [bdq_workbench](https://github.com/FilteredPush/bdq_workbench) | Application | Runs BDQ Tests over Darwin Core data for a Use Case | [latest release](https://github.com/FilteredPush/bdq_workbench/releases/latest) |
| [bdq_usecase_builder](https://github.com/FilteredPush/bdq_usecase_builder) | Application | Authors Use Cases and Test definitions | [latest release](https://github.com/FilteredPush/bdq_usecase_builder/releases/latest) |
| [bdq_issue_to_csv](https://github.com/kurator-org/bdq_issue_to_csv) | Application | Converts tdwg/bdq Test issues to a term-version CSV | [latest release](https://github.com/kurator-org/bdq_issue_to_csv/releases/latest) |
