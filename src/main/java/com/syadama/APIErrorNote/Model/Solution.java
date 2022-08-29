package com.syadama.APIErrorNote.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_solution;
    private String ressource;
    private String temps_consacre;
    private String methodologie_adopte;

    @OneToOne(mappedBy = "solution")
    private Probleme probleme;



}
