package com.thailife.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyRequest {
    private HeaderData headerData;
    private RequestRecord requestRecord;
}
