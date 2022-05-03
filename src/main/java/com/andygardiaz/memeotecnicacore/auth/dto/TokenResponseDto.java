package com.andygardiaz.memeotecnicacore.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class TokenResponseDto {
    private String accessToken;
}