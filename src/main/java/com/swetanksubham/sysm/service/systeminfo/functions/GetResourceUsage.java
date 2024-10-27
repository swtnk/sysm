package com.swetanksubham.sysm.service.systeminfo.functions;

import java.util.function.Supplier;

import org.springframework.stereotype.Service;

import com.sun.management.OperatingSystemMXBean;
import com.swetanksubham.sysm.service.systeminfo.model.MemoryInfo;
import com.swetanksubham.sysm.service.systeminfo.model.MemoryProperties;
import com.swetanksubham.sysm.service.systeminfo.model.ResourceInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetResourceUsage implements Supplier<ResourceInfo> {
    
    private final OperatingSystemMXBean osBean;

    @Override
    public ResourceInfo get() {
        return ResourceInfo.builder()
            .memory(this.getMemoryInfo())
            .systemLoadAverage(this.osBean.getSystemLoadAverage())
            .cpuLoad(this.osBean.getCpuLoad())
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

}
