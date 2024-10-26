package com.swetanksubham.sysm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swetanksubham.sysm.service.apphome.AppHomeService;
import com.swetanksubham.sysm.service.apphome.model.HealthInfo;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class AppHomeController {

    private final AppHomeService service;
    
    @GetMapping("")
    public HealthInfo healthInfo(
            @NonNull final HttpServletRequest request) {
        return this.service.getHealthInfo(request);
    }
    

}
