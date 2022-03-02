package com.mhk.beauty.repository;

import com.mhk.beauty.entity.Treatment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

  List<Treatment> findByClientId(Long clientId);
}
