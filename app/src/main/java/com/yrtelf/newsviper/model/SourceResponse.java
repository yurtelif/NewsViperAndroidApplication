package com.yrtelf.newsviper.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SourceResponse {

    @SerializedName("status")
    private String responseStatus;

    @SerializedName("sources")
    private List<Source> sourcesList;

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public List<Source> getSourcesList() {
        return sourcesList;
    }

    public void setSourcesList(List<Source> sourcesList) {
        this.sourcesList = sourcesList;
    }
}
