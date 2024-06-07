package com.example.batchdemo.batch.writers;

import com.example.batchdemo.entity.PhotoSap;
import com.example.batchdemo.repository.PhotoSapRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class SendPhotoToSapWriterConfig {

    @Bean
    @StepScope
    public ItemWriter<PhotoSap> sendPhotoToSapWriter(PhotoSapRepository photoSapRepository){
        return list -> {
            log.info("Saved {} items to SAP repository", list.size());

            photoSapRepository.saveAll(list);
        };
    }
}
