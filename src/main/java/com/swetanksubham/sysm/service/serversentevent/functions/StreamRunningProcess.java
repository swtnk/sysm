package com.swetanksubham.sysm.service.serversentevent.functions;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Supplier;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;

import com.swetanksubham.sysm.service.systeminfo.functions.GetRunningProcesses;
import com.swetanksubham.sysm.service.systeminfo.model.RunningProcesses;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@RequiredArgsConstructor
public class StreamRunningProcess implements Supplier<Flux<ServerSentEvent<RunningProcesses>>> {

    private final GetRunningProcesses runningProcesses;

    @Override
    public Flux<ServerSentEvent<RunningProcesses>> get() {
        return Flux.interval(Duration.ofSeconds(1))
                .onBackpressureLatest()
                .map(sequence -> this.sse(sequence))
                .doOnError(IOException.class, e -> log.warn("IOException: Possible disconnect."))
                .onErrorResume(IOException.class, e -> Flux.empty()) // Resume with empty stream
                .doOnCancel(() -> log.info("SSE stream canceled by client."))
                .doOnTerminate(() -> System.out.println("SSE stream completed"))
                .doFinally(signalType -> log.info("SSE stream ended with signal: {}", signalType));
    }

    private ServerSentEvent<RunningProcesses> sse(final long sequence) {
        return ServerSentEvent.<RunningProcesses>builder()
                .id(String.valueOf(sequence))
                .event("processes")
                .data(this.runningProcesses.get())
                .build();
    }
}
