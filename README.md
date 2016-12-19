# ffdq-api

API for making Fittness For Use Framework assertions in Data Quality reports.

# Include using maven

Available in Maven Central

    <dependency>
        <groupId>org.datakurator</groupId>
        <artifactId>ffdq-api</artifactId>
        <version>0.0.1</version>
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

    mvn package

# Developer deployment: 

To deploy a snapshot to the snapshotRepository:

    mvn clean deploy

To deploy a new release to maven central, set the version in pom.xml to a non-snapshot version, then deploy with the release profile (which adds package signing and deployment to release staging:

    mvn clean deploy -P release

After this, you will need to login to the sonatype oss repository hosting nexus instance, find the staged release in the staging repositories, and perform the release.  It should be possible (haven't verified this yet) to perform the release from the command line instead by running:

    mvn nexus-staging:release -P release

