package com.hr.eenvijfdrielagen.repository;

import com.hr.eenvijfdrielagen.model.CombiRekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombiRekeningRepository extends JpaRepository<CombiRekening, Long> {
}
