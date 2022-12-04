package com.techestop.azurecosmosdbcrud.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;


@Getter
@Setter
@Container(containerName = "Varos", ru = "400")
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;
    private String nev;

    @PartitionKey
    private Integer megyeid;
    private Boolean megyeszekhely;
    private Boolean megyeijogu;

    public Customer(String nev, Integer megyeid, Boolean megyeszekhely, Boolean megyeijogu){

        this.nev = nev;
        this.megyeid = megyeid;
        this.megyeszekhely = megyeszekhely;
        this.megyeijogu = megyeijogu;
    }


}
