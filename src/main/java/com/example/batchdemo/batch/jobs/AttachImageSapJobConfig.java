package com.example.batchdemo.batch.jobs;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AttachImageSapJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job attachSapImageJob(
            @Qualifier("attachSapImageStep") Step attachSapImageStep) {
        return jobBuilderFactory
                .get("attachSapImageJob")
                .start(attachSapImageStep)
                .build();
    }
}
