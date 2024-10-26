package com.swetanksubham.sysm.service.systeminfo.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ProcessorInfo {
    
    int available;

}
