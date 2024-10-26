package com.swetanksubham.sysm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swetanksubham.sysm.service.systeminfo.model.SystemInfo;
import com.swetanksubham.sysm.service.systeminfo.SystemInfoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping("/api/v1/")
@RestController
@RequiredArgsConstructor
public class SystemInfoController {

    private final SystemInfoService service;
    @GetMapping("system")
    public SystemInfo getSystemInfo() {
        return this.service.getSystemInfo();
    }
    
}
