package com.heavyduty.dropdemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class DropDemoConfiguration extends Configuration{

    private String databaseUrl ;

    @JsonProperty
    public String getDatabaseUrl() {
        return databaseUrl ;
    }

    public void setDatabaseUrl(String s) {
        databaseUrl = s ;
    }


}
