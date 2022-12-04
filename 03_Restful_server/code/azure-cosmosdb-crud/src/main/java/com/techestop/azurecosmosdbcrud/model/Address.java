package com.techestop.azurecosmosdbcrud.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    @JsonProperty("Varos1")
    private String addressLine1;
    @JsonProperty("Varos2")
    private String addressLine2;
    @JsonProperty("Varos3")
    private String addressLine3;
    @JsonProperty("IsCurrentCity")
    private String isCurrentAddress;
    @JsonProperty("IsPermanentCity")
    private String isPermanentAddress;
    @JsonProperty("megyeid")
    private String megyeId;
    @JsonProperty("Megyeszekhely")
    private String megyeszekhely;
    @JsonProperty("megyeijogu")
    private String Megyeijogu;
}
