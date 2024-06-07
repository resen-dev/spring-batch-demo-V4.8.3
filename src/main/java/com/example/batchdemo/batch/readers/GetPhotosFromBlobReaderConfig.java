package com.example.batchdemo.batch.readers;

import com.example.batchdemo.entity.PhotoBlob;
import com.example.batchdemo.repository.PhotoBlobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class GetPhotosFromBlobReaderConfig {

    @Bean
    @StepScope
    public ItemReader<PhotoBlob> getPhotosFromBlobReader(PhotoBlobRepository photoBlobRepository){
        log.error("GET PHOTOS FROM BLOB");
        return new ListItemReader<>(photoBlobRepository.findAll());
    }
}
