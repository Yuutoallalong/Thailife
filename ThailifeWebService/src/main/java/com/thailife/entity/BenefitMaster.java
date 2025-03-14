package com.thailife.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "policy_master", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BenefitMaster {

    @Id
    @Column(name = "\"policyNo\"", nullable = false)
    private String policyNo;

    @Column(name = "\"policyType\"", nullable = false)
    private String policyType;

    @Column(name = "\"status\"", nullable = false)
    private String status;

    @Column(name = "\"agenID\"", nullable = false)
    private String agenID;

    @Column(name = "\"insureName\"", columnDefinition = "VARCHAR(255) COLLATE \"th_TH.UTF-8\"")
    private String insureName;

}
