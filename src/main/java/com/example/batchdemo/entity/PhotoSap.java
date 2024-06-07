package com.example.batchdemo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PHOTO_SAP")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PhotoSap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer hash;
}
