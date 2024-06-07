package com.example.batchdemo.batch.processors;

import com.example.batchdemo.entity.PhotoBlob;
import com.example.batchdemo.entity.PhotoSap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ConvertPhotoBlobToSapProcessorConfig {

    @Bean
    @StepScope
    public ItemProcessor<PhotoBlob, PhotoSap> convertPhotoBlobToSapProcessor() {
        return photoBlob -> {
            log.info("Converting PhotoBlob to PhotoSap");
            return PhotoSap.builder()
                    .hash(Integer.valueOf(photoBlob.getHash()))
                    .build();
        };
    }
}
