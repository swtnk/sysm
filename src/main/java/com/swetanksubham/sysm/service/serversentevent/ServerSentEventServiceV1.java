package com.swetanksubham.sysm.service.serversentevent;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;

import com.swetanksubham.sysm.service.serversentevent.functions.StreamUsage;
import com.swetanksubham.sysm.service.systeminfo.model.ResourceInfo;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ServerSentEventServiceV1 implements ServerSentEventService {

    private final StreamUsage streamUsage;
    
    @Override
    public Flux<ServerSentEvent<ResourceInfo>> steamSystemUsage() {
        return this.streamUsage.get();
    }

}
