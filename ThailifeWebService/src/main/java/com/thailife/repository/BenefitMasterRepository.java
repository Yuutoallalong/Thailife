package com.thailife.repository;

import com.thailife.entity.BenefitMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenefitMasterRepository extends JpaRepository<BenefitMaster, String> {
    @Query(value = "SELECT * FROM policy_master WHERE encode(\"insureName\"::bytea, 'hex') = :insureName", nativeQuery = true)
    List<BenefitMaster> findByInsureName(@Param("insureName") String insureName);
}
