package com.swetanksubham.sysm.service.systeminfo;

import com.swetanksubham.sysm.service.systeminfo.model.SystemInfo;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.swetanksubham.sysm.service.systeminfo.functions.GetSystemProperties;

@Service
@RequiredArgsConstructor
public class SystemInfoServiceV1 implements SystemInfoService {

    private final GetSystemProperties getSystemProperties;

    @Override
    public SystemInfo getSystemInfo() {
        return this.getSystemProperties.get();
    }

}
