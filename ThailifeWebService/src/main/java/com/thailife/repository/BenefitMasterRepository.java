package com.thailife.repository;

import com.thailife.entity.BenefitMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenefitMasterRepository extends JpaRepository<BenefitMaster, String> {
    List<BenefitMaster> findByInsureName(String insureName);
}

