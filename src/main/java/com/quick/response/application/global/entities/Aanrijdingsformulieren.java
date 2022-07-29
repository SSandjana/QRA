package com.quick.response.application.global.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Aanrijdingsformulieren {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String idNumber;
    private String username;
    private String naam;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String afgehandeld;

}
