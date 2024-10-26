package com.swetanksubham.sysm.service.apphome.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.Builder.Default;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class HealthInfo {
    
    @NonNull
    @Default
    String status = "Listening";

    @NonNull
    @Default
    String apiDoc = "/swagger-ui.html";

}
