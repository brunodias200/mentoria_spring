package com.treinamentospring.treinamentospring.server.infrastructure;

public record ExceptionResponse(
        String error,
        String message,
        String path,
        Integer status,
        String timestamp
){
}
