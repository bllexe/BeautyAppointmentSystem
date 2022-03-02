package com.mhk.beauty.service;

import com.mhk.beauty.entity.Treatment;
import java.util.List;

public interface TreatmentService {

  Treatment save(Long clientId, Treatment treatment);

  Treatment findById(Long id);

  List<Treatment> findByClientId(Long clientId);

  Treatment update(Long id, Treatment treatment);


}
