package com.food.ordering.system.customer.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCustomerResponse {

    @NotNull
    private UUID customerId;
    @NotNull
    private String message;
}
