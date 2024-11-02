package com.swetanksubham.sysm.service.systeminfo.model;

import java.util.List;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class RunningProcesses {

    @NonNull
    List<ProcessInfo> processes;

}
