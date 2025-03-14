package com.thailife.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyResponse {
    private HeaderData headerData;
    private ResponseRecord responseRecord;
    private ResponseStatus responseStatus;
}
