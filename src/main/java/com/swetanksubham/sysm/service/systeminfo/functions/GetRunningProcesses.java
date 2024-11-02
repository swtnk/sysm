package com.swetanksubham.sysm.service.systeminfo.functions;

import com.swetanksubham.sysm.service.systeminfo.model.ProcessInfo;
import com.swetanksubham.sysm.service.systeminfo.model.RunningProcesses;

import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class GetRunningProcesses implements Supplier<RunningProcesses> {

    @NonNull
    private static final String OS_NAME = System.getProperty("os.name").toLowerCase();
    
    @NonNull
    private static final String OS_WIN = "win";

    @Override
    public RunningProcesses get() {
        try {
            return RunningProcesses.builder()
                .processes(this.getProcesses())
                .build();
        } catch (IOException e) {
            return RunningProcesses.builder()
                .processes(List.of())
                .build();
        }
    }

    private List<ProcessInfo> getProcesses() throws IOException {
        final List<String> command = determineCommand();

        final ProcessBuilder processBuilder = new ProcessBuilder(command);
        final Process process = processBuilder.start();

        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            return reader.lines()
                    .filter(line -> !line.trim().isEmpty())
                    .map(line -> line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1))
                    .filter(details -> details.length >= 7)
                    .map(details -> ProcessInfo.builder()
                            .pid(details[0])
                            .user(Optional.ofNullable(details[1]))
                            .elapsedTime(Optional.ofNullable(details[2]))
                            .cpuTime(Optional.ofNullable(details[3]))
                            .cpuUsage(Optional.ofNullable(details[4]))
                            .memoryUsage(Optional.ofNullable(details[5]))
                            .processName(details[6].replaceAll("\"", "").trim())
                            .build())
                    .collect(Collectors.toList());
        }
    }

    private List<String> determineCommand() {

        if (OS_NAME.contains(OS_WIN)) {
            return List.of("tasklist");
        } else {
            return List.of("sh", "-c", 
                "ps -ero pid=,user=,etime=,time=,%cpu=,%mem=,args= | awk 'BEGIN { OFS=\",\" } { $7=\"\\\"\" $7; for (i=8; i<=NF; i++) $7=$7 \" \" $i; $7=$7 \"\\\"\"; print $1, $2, $3, $4, $5, $6, $7 }' | head -n 50");
        }
    }
}
