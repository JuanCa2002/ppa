package com.puntopago.ppa.infrastructure.adapters.in.rest.controllers.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
public class PageResponse<T> {

    @JsonProperty("data")
    @Schema(description = "Return data")
    private T data;

    @JsonProperty("total")
    @Schema(description = "Total found records")
    private BigInteger total;

}
