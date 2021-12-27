package com.ozguryazilim.veteriner.Request;

import lombok.Data;

@Data
public class AuthorizationRequest {
    String name;
    String password;
}
