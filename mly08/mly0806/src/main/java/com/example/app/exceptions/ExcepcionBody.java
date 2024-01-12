package com.example.app.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
class ExcepcionBody {
    private LocalDateTime timestamp;
    private HttpStatusCode status;
    private String message;
    private String path;
}
