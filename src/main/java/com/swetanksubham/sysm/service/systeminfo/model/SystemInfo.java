package com.swetanksubham.sysm.service.systeminfo.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class SystemInfo {

    @NonNull
    OsInfo operatingSystem;

    @NonNull
    ProcessorInfo processor;

    @NonNull
    String applicationVersion;

}
