package com.swetanksubham.sysm.service.systeminfo.model;

import java.util.Optional;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ProcessInfo {
    
    @NonNull
    String pid;

    @NonNull
    Optional<String> user;

    @NonNull
    String processName;

    @NonNull
    Optional<String> elapsedTime;

    @NonNull
    Optional<String> cpuTime;

    @NonNull
    Optional<String> cpuUsage;

    @NonNull
    Optional<String> memoryUsage;

}
