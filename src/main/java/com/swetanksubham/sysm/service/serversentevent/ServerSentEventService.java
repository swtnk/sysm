package com.swetanksubham.sysm.service.serversentevent;

import org.springframework.http.codec.ServerSentEvent;

import com.swetanksubham.sysm.service.systeminfo.model.ResourceInfo;
import com.swetanksubham.sysm.service.systeminfo.model.RunningProcesses;

import reactor.core.publisher.Flux;

public interface ServerSentEventService {
    
    Flux<ServerSentEvent<ResourceInfo>> streamSystemUsage();

    Flux<ServerSentEvent<RunningProcesses>> streamRunningProcesses();

}
