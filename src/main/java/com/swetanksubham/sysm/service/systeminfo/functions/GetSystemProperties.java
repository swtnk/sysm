package com.swetanksubham.sysm.service.systeminfo.functions;

import java.util.function.Supplier;

import org.springframework.stereotype.Service;

import com.sun.management.OperatingSystemMXBean;
import com.swetanksubham.sysm.service.systeminfo.model.OsInfo;
import com.swetanksubham.sysm.service.systeminfo.model.ProcessorInfo;
import com.swetanksubham.sysm.service.systeminfo.model.SystemInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetSystemProperties implements Supplier<SystemInfo> {

    private final OperatingSystemMXBean osBean;
    private final GetApplicationVersion applicationVersion;

    @Override
    public SystemInfo get() {
        return SystemInfo.builder()
            .operatingSystem(this.getOsInfo())
            .processor(this.getProcessorInfo())
            .applicationVersion(this.applicationVersion.get())
            .build();
    }

    private final OsInfo getOsInfo() {
        return OsInfo.builder()
            .name(this.osBean.getName())
            .version(this.osBean.getVersion())
            .architecture(this.osBean.getArch())
            .build();
    }

    private final ProcessorInfo getProcessorInfo() {
        return ProcessorInfo.builder()
            .available(this.osBean.getAvailableProcessors())
            .build();
    }
}
