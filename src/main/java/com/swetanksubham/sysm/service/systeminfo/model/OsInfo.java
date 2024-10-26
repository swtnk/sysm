package com.swetanksubham.sysm.service.systeminfo.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class OsInfo {

    @NonNull
    String name;

    @NonNull
    String version;

    @NonNull
    String architecture;

}
