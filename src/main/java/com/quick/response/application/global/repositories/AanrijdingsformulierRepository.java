package com.quick.response.application.global.repositories;

import com.quick.response.application.global.entities.Aanrijdingsformulieren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AanrijdingsformulierRepository extends JpaRepository<Aanrijdingsformulieren, Long> {

    Aanrijdingsformulieren findAanrijdingsformulierenByNaamContaining(String naam);

    List<Aanrijdingsformulieren> findAll();

    @Transactional
    @Modifying
    @Query(value = "update aanrijdingsformulieren a set a.afgehandeld = :status where a.naam = :naam", nativeQuery = true)
    void change(@Param("status") String status, @Param("naam") String naam);


}
