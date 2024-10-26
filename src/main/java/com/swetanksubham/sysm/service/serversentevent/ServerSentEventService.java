package com.swetanksubham.sysm.service.serversentevent;

import org.springframework.http.codec.ServerSentEvent;

import com.swetanksubham.sysm.service.systeminfo.model.ResourceInfo;

import reactor.core.publisher.Flux;

public interface ServerSentEventService {
    
    Flux<ServerSentEvent<ResourceInfo>> steamSystemUsage();

}
