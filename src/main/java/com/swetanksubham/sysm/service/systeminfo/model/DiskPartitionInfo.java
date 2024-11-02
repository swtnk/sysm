package com.swetanksubham.sysm.service.systeminfo.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class DiskPartitionInfo {

    @NonNull
    String path;

    long totalSpace;

    long freeSpace;

    long usableSpace;

}
