package com.swetanksubham.sysm.service.systeminfo.functions;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetApplicationVersion implements Supplier<String> {

    @Value("${app.version}")
    private String version;

    @Override
    public String get() {
        return this.version;
    }
}
