package com.swetanksubham.sysm.service.serversentevent;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;

import com.swetanksubham.sysm.service.serversentevent.functions.StreamRunningProcess;
import com.swetanksubham.sysm.service.serversentevent.functions.StreamUsage;
import com.swetanksubham.sysm.service.systeminfo.model.ResourceInfo;
import com.swetanksubham.sysm.service.systeminfo.model.RunningProcesses;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ServerSentEventServiceV1 implements ServerSentEventService {

    private final StreamUsage streamUsage;
    private final StreamRunningProcess runningProcesses;
    
    @Override
    public Flux<ServerSentEvent<ResourceInfo>> streamSystemUsage() {
        return this.streamUsage.get();
    }

    @Override
    public Flux<ServerSentEvent<RunningProcesses>> streamRunningProcesses() {
        return this.runningProcesses.get();
    }

}
