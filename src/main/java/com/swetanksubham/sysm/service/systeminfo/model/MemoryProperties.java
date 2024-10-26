package com.swetanksubham.sysm.service.systeminfo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class MemoryProperties {
    
    double total;

    double free;

    @JsonProperty("used")
    public double used() {
        return total - free;
    }

}
