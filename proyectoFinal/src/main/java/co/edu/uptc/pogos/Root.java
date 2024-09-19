package co.edu.uptc.pogos;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

class Approval{
    public int reviewedAt;
    public boolean reviewedAutomatically;
    public String state;
    public int submissionId;
    public String submissionObject;
    public String submissionOutcome;
    public int submittedAt;
    public String targetAudience;
    public int workflowId;
    public SubmissionDetails submissionDetails;
    public SubmissionOutcomeApplication submissionOutcomeApplication;
    public Submitter submitter;
}

 class ClientContext{
    public ArrayList<Object> clientContextVariables;
    public InheritedVariables inheritedVariables;
}

 class Column{
    public int id;
    public String name;
    public String dataTypeName;
    public String fieldName;
    public int position;
    public String renderTypeName;
    public Format format;
    public ArrayList<String> flags;
    public String description;
    public int tableColumnId;
    public ComputationStrategy computationStrategy;
}

 class ComputationStrategy{
    public ArrayList<String> source_columns;
    public String type;
    public Parameters parameters;
}

 class CustomFields{
    @JsonProperty("Temporal") 
    public Temporal temporal;
    @JsonProperty("Identification") 
    public Identification identification;
    @JsonProperty("Notes") 
    public Notes notes;
}

 class Format{
    public String align;
}

 class Grant{
    public boolean inherited;
    public String type;
    public ArrayList<String> flags;
}

 class Identification{
    @JsonProperty("Originator") 
    public String originator;
    @JsonProperty("Metadata Language") 
    public String metadataLanguage;
}

 class InheritedVariables{
}

 class License{
    public String name;
    public String termsLink;
}

 class Meta{
    public View view;
}

 class Metadata{
    public CustomFields custom_fields;
    public String rowLabel;
    public ArrayList<String> availableDisplayTypes;
}

 class Notes{
    @JsonProperty("1. ") 
    public String _1 ;
    @JsonProperty("2. ") 
    public String _2 ;
    @JsonProperty("3. ") 
    public String _3 ;
    @JsonProperty("4. ") 
    public String _4 ;
}

 class Owner{
    public String id;
    public String displayName;
    public String profileImageUrlLarge;
    public String profileImageUrlMedium;
    public String profileImageUrlSmall;
    public String screenName;
    public String type;
    public ArrayList<String> flags;
}

 class Parameters{
    public String region;
    public String primary_key;
}

 class Query{
}

public class Root{
    public Meta meta;
    public List<List<Object>> data;
}

 class SubmissionDetails{
    public String permissionType;
}

 class SubmissionOutcomeApplication{
    public int failureCount;
    public String status;
}

 class Submitter{
    public String id;
    public String displayName;
}

 class TableAuthor{
    public String id;
    public String displayName;
    public String profileImageUrlLarge;
    public String profileImageUrlMedium;
    public String profileImageUrlSmall;
    public String screenName;
    public String type;
    public ArrayList<String> flags;
}

 class Temporal{
    @JsonProperty("Posting Frequency") 
    public String postingFrequency;
    @JsonProperty("Period of Time") 
    public String periodofTime;
}

 class View{
    public String id;
    public String name;
    public String assetType;
    public String attribution;
    public int averageRating;
    public String category;
    public int createdAt;
    public String description;
    public String displayType;
    public int downloadCount;
    public boolean hideFromCatalog;
    public boolean hideFromDataJson;
    public String licenseId;
    public boolean locked;
    public boolean newBackend;
    public int numberOfComments;
    public int oid;
    public String provenance;
    public boolean publicationAppendEnabled;
    public int publicationDate;
    public int publicationGroup;
    public String publicationStage;
    public int rowsUpdatedAt;
    public String rowsUpdatedBy;
    public int tableId;
    public int totalTimesRated;
    public int viewCount;
    public int viewLastModified;
    public String viewType;
    public ArrayList<Approval> approvals;
    public ClientContext clientContext;
    public ArrayList<Column> columns;
    public ArrayList<Grant> grants;
    public License license;
    public Metadata metadata;
    public Owner owner;
    public Query query;
    public ArrayList<String> rights;
    public TableAuthor tableAuthor;
    public ArrayList<String> tags;
    public ArrayList<String> flags;
}