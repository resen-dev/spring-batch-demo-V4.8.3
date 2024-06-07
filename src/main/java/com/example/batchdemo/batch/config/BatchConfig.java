package com.example.batchdemo.batch.config;

import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public BatchConfigurer batchConfigurer(DataSource dataSource, PlatformTransactionManager transactionManager) {
        return new DefaultBatchConfigurer() {
            @Override
            protected JobRepository createJobRepository() throws Exception {
                JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
                factory.setDataSource(dataSource);
                factory.setTransactionManager(transactionManager);
                factory.setTablePrefix("custom_schema.BATCH_");
                return factory.getObject();
            }

            @Override
            protected JobExplorer createJobExplorer() throws Exception {
                JobExplorerFactoryBean factory = new JobExplorerFactoryBean();
                factory.setDataSource(dataSource);
                factory.setTablePrefix("custom_schema.BATCH_");
                factory.afterPropertiesSet();
                return factory.getObject();
            }
        };
    }
}
