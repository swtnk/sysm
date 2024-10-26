package com.swetanksubham.sysm.service.systeminfo.functions;

import java.util.function.Supplier;

import org.springframework.stereotype.Service;

import com.sun.management.OperatingSystemMXBean;
import com.swetanksubham.sysm.service.systeminfo.model.MemoryInfo;
import com.swetanksubham.sysm.service.systeminfo.model.MemoryProperties;
import com.swetanksubham.sysm.service.systeminfo.model.OsInfo;
import com.swetanksubham.sysm.service.systeminfo.model.ProcessorInfo;
import com.swetanksubham.sysm.service.systeminfo.model.SystemInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetSystemProperties implements Supplier<SystemInfo> {

    private final OperatingSystemMXBean osBean;

    @Override
    public SystemInfo get() {
        return SystemInfo.builder()
            .operatingSystem(this.getOsInfo())
            .memory(this.getMemoryInfo())
            .processor(this.getProcessorInfo())
            .systemLoadAverage(this.osBean.getSystemLoadAverage())
            .build();
    }

    private final OsInfo getOsInfo() {
        return OsInfo.builder()
            .name(this.osBean.getName())
            .version(this.osBean.getVersion())
            .architecture(this.osBean.getArch())
            .build();
    }

    private final MemoryInfo getMemoryInfo() {
        return MemoryInfo.builder()
            .physical(this.getPhysicalMemory())
            .swap(this.getSwapMemory())
            .build();
    }

    private final MemoryProperties getPhysicalMemory() {
        return MemoryProperties.builder()
            .total(this.osBean.getTotalMemorySize())
            .free(this.osBean.getFreeMemorySize())
            .build();
    }
    
    private final MemoryProperties getSwapMemory() {
        return MemoryProperties.builder()
            .total(this.osBean.getTotalSwapSpaceSize())
            .free(this.osBean.getFreeSwapSpaceSize())
            .build();
    }

    private final ProcessorInfo getProcessorInfo() {
        return ProcessorInfo.builder()
            .available(this.osBean.getAvailableProcessors())
            .build();
    }
}