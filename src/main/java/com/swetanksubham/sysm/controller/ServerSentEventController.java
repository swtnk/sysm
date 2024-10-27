package com.swetanksubham.sysm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swetanksubham.sysm.service.serversentevent.ServerSentEventService;
import com.swetanksubham.sysm.service.systeminfo.model.ResourceInfo;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping("/api/v1/sse")
@RestController
@RequiredArgsConstructor
public class ServerSentEventController {

    private final ServerSentEventService service;

    @GetMapping(path = "/memory", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<ResourceInfo>> streamEvents() {
        return this.service.steamSystemUsage();
    }

}
