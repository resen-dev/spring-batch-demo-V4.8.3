package com.example.batchdemo.repository;

import com.example.batchdemo.entity.PhotoSap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoSapRepository extends JpaRepository<PhotoSap, Long> {
}
