package com.InfApp.InfApp.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "corona")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Corona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "link1")
    private String link1;

    @Column(name = "link2")
    private String link2;

    @Column(name = "link3")
    private String link3;

    @Column(name = "link4")
    private String link4;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "corona") //podlaczanie korony pod tabele user
    private User user;


}

