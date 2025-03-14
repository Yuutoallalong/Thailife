package com.thailife.dto;

import com.thailife.entity.BenefitMaster;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseRecord {
    private List<BenefitMaster> policy;
}
