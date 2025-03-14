package com.thailife.service;

import com.thailife.entity.BenefitMaster;
import com.thailife.repository.BenefitMasterRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class PolicyService {

    private final BenefitMasterRepository repository;

    public PolicyService(BenefitMasterRepository repository) {
        this.repository = repository;
    }
    
    @Query("SELECT b FROM BenefitMaster b WHERE b.insureName COLLATE 'th_TH.UTF-8' = :insureName")
    public List<BenefitMaster> findByInsureName(@Param("insureName") String insureName) {
        return repository.findByInsureName(insureName.trim().toLowerCase(Locale.forLanguageTag("th-TH")));
    }

}
