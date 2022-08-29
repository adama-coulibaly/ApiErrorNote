package com.syadama.APIErrorNote.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Entity

public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_etat;
    private String status;



}
