package com.example.batchdemo.batch.steps;

import com.example.batchdemo.entity.PhotoBlob;
import com.example.batchdemo.entity.PhotoSap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AttachSapImageStepConfig {

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step attachSapImageStep(
            @Qualifier("getPhotosFromBlobReader") ItemReader<PhotoBlob> getPhotosFromBlobReader,
            @Qualifier("convertPhotoBlobToSapProcessor") ItemProcessor<PhotoBlob, PhotoSap> convertPhotoBlobToSapProcessor,
            @Qualifier("sendPhotoToSapWriter") ItemWriter<PhotoSap> sendPhotoToSapWriter) {
        return stepBuilderFactory
                .get("attachSapImageStep")
                .<PhotoBlob, PhotoSap>chunk(8)
                .reader(getPhotosFromBlobReader)
                .processor(convertPhotoBlobToSapProcessor)
                .writer(sendPhotoToSapWriter)
                .build();
    }
}
