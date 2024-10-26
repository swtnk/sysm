package com.swetanksubham.sysm.service.apphome.functions;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.swetanksubham.sysm.service.apphome.model.HealthInfo;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetHealthInfo implements Function<HttpServletRequest, HealthInfo> {
    
    @Override
    public HealthInfo apply(
            @NonNull final HttpServletRequest request) {
        return HealthInfo.builder()
            .apiDoc(this.constructSwaggerUiUrl(request))
            .build();
    }

    private String constructSwaggerUiUrl(
            @NonNull final HttpServletRequest request) {
        final String scheme = request.getScheme();
        final String serverName = request.getServerName();
        int serverPort = request.getServerPort();

        final String portPart = (serverPort == 80 && "http".equals(scheme)) || (serverPort == 443 && "https".equals(scheme)) 
            ? "" 
            : ":" + serverPort;

        return scheme + "://" + serverName + portPart + "/swagger-ui/index.html";
    }
}
