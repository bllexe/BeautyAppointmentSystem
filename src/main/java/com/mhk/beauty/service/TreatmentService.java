package com.mhk.beauty.service;

import com.mhk.beauty.entity.Treatment;
import java.util.List;
import org.springframework.data.domain.Sort;

public interface TreatmentService {

  Treatment save(Long clientId, Treatment treatment);

  Treatment findById(Long id);

  List<Treatment> findTreatmentsByClientId(Long clientId, Sort sort);

  Treatment update(Long id, Treatment treatment);


}
