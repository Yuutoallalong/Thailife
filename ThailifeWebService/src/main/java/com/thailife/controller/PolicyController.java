package com.thailife.controller;

import com.thailife.dto.*;
import com.thailife.dto.ResponseStatus;
import com.thailife.entity.BenefitMaster;
import com.thailife.service.PolicyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping("/getPolicyInfo")
    public ResponseEntity<PolicyResponse> getPolicyInfo(@RequestBody PolicyRequest request) {

        if (request == null || request.getRequestRecord() == null) {
            System.out.println("Request or RequestRecord is NULL!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        PolicyResponse response = new PolicyResponse();
        HeaderData headerData = new HeaderData();
        ResponseStatus responseStatus = new ResponseStatus();
        ResponseRecord responseRecord = new ResponseRecord();

        headerData.setMessageId(request.getHeaderData().getMessageId());
        headerData.setSentDateTime(request.getHeaderData().getSentDateTime());
        headerData.setResponseDateTime(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        try {
            String decodedInsureName = new String(
                    request.getRequestRecord().getInsureName().getBytes(StandardCharsets.UTF_8),
                    StandardCharsets.UTF_8);

            System.out.println("? Received InsureName (RAW): " + request.getRequestRecord().getInsureName());
            System.out.println("? Decoded InsureName: " + decodedInsureName);
            System.out.println("? Received InsureName (HEX): " +
                    bytesToHex(request.getRequestRecord().getInsureName().getBytes(StandardCharsets.UTF_8)));

            List<BenefitMaster> policies = policyService.findByInsureName(decodedInsureName.trim());

            if (policies.isEmpty()) {
                responseStatus.setStatus("E");
                responseStatus.setErrorCode("404");
                responseStatus.setErrorMessage("No records found");
            } else {
                responseStatus.setStatus("S");
                responseStatus.setErrorCode("000");
                responseStatus.setErrorMessage("Success");
                responseRecord.setPolicy(policies);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseStatus.setStatus("E");
            responseStatus.setErrorCode("500");
            responseStatus.setErrorMessage("Encoding error occurred");
        }

        response.setHeaderData(headerData);
        response.setResponseRecord(responseRecord);
        response.setResponseStatus(responseStatus);

        return ResponseEntity.ok(response);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

}
