package com.thailife.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeaderData {
    private String messageId;
    private String sentDateTime;
    private String responseDateTime;
}
