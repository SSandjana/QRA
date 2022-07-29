package com.quick.response.application.client.entities;

import com.quick.response.application.global.entities.User;
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
public class Voertuig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String merk;
    @ManyToOne
    @JoinColumn(name = "voertuig_type", referencedColumnName = "id", nullable = false)
    private VoertuigType voertuigType;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    private Long bouwJaar;
    private String kentekenNummer;
}
