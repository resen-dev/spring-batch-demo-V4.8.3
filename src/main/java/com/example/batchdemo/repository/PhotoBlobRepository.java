package com.example.batchdemo.repository;


import com.example.batchdemo.entity.PhotoBlob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoBlobRepository extends JpaRepository<PhotoBlob, Long> {
}
