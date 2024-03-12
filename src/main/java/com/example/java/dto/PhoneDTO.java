package com.example.java.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    @Schema(description = "Phone number", example = "1234567")
    private String number;
    @Schema(description = "Phone city code", example = "1")
    @JsonProperty("citycode")
    private String cityCode;
    @Schema(description = "Phone country code", example = "57")
    @JsonProperty("contrycode")
    private String countryCode;
}
