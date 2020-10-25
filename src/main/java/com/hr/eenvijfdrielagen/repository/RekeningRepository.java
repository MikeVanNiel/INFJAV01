package com.hr.eenvijfdrielagen.repository;

import com.hr.eenvijfdrielagen.model.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RekeningRepository extends JpaRepository<Rekening, Long> {

}
