package com.swetanksubham.sysm.service.apphome;

import org.springframework.stereotype.Service;

import com.swetanksubham.sysm.service.apphome.functions.GetHealthInfo;
import com.swetanksubham.sysm.service.apphome.model.HealthInfo;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppHomeServiceV1 implements AppHomeService {

    private final GetHealthInfo getHealthInfo;
    
    @Override
    public HealthInfo getHealthInfo(
            @NonNull final HttpServletRequest request) {
        return this.getHealthInfo.apply(request);
    }

}
