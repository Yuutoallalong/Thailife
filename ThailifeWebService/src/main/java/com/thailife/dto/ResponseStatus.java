package com.thailife.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStatus {
    private String status;
    private String errorCode;
    private String errorMessage;
}
