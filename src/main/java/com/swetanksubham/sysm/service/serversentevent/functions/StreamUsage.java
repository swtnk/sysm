package com.swetanksubham.sysm.service.serversentevent.functions;

import java.time.Duration;
import java.util.function.Supplier;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;

import com.swetanksubham.sysm.service.systeminfo.functions.GetResourceUsage;
import com.swetanksubham.sysm.service.systeminfo.model.ResourceInfo;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class StreamUsage implements Supplier<Flux<ServerSentEvent<ResourceInfo>>> {

    private final GetResourceUsage getResourceUsage;
    
    @Override
    public Flux<ServerSentEvent<ResourceInfo>> get() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> this.sse(sequence));
    }

    private ServerSentEvent<ResourceInfo> sse(
            final long sequence) {
        return ServerSentEvent.<ResourceInfo>builder()
            .id(String.valueOf(sequence))
            .event("resource-utilization")
            .data(this.getResourceUsage.get())
            .build();
    }

}
