package com.example.batchdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/job")
@Slf4j
public class JobController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    @Qualifier("attachSapImageJob")
    private Job attachSapImageJob;

    @PostMapping("/start")
    public ExitStatus startJob(@RequestParam String ivSold,
                               @RequestParam String ivFeNum,
                               @RequestParam String ivQmNum) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        return jobLauncher
                .run(attachSapImageJob, new JobParametersBuilder()
                        .addLong("date", System.currentTimeMillis())
                        .addString("ivSold", ivSold)
                        .addString("ivFeNum", ivFeNum)
                        .addString("ivQmNum", ivQmNum)
                        .toJobParameters()).getExitStatus();
    }
}
