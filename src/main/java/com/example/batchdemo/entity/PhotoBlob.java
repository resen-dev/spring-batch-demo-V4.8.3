package com.example.batchdemo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PHOTO_BLOB")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PhotoBlob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hash;
}
