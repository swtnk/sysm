package com.swetanksubham.sysm.service.systeminfo.model;

import java.util.List;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.Builder.Default;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ResourceInfo {

    @NonNull
    MemoryInfo memory;

    double systemLoadAverage;

    @Default
    double cpuLoad = 0;

    @NonNull
    List<DiskPartitionInfo> diskPartition;

}
