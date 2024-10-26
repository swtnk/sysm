package com.swetanksubham.sysm.service.apphome;

import com.swetanksubham.sysm.service.apphome.model.HealthInfo;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;

public interface AppHomeService {
    
    HealthInfo getHealthInfo(
        @NonNull final HttpServletRequest request);

}
