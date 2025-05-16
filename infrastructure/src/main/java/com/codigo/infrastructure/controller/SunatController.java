package com.codigo.application.controller;

import com.codigo.domain.model.Empresa;
import com.codigo.application.response.BaseResponse;
import com.codigo.application.usecase.SunatUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sunat")
@RequiredArgsConstructor
public class SunatController {

    private final SunatUseCase sunatUseCase;

    @PostMapping("/resttemplate/{ruc}")
    public ResponseEntity<BaseResponse<Empresa>> registrarDesdeRestTemplate(@PathVariable String ruc) {
        Empresa empresa = sunatUseCase.guardarDesdeRestTemplate(ruc);
        return ResponseEntity.ok(BaseResponse.<Empresa>builder()
                .codigo(HttpStatus.CREATED.value())
                .mensaje("Registrado desde RestTemplate")
                .data(empresa)
                .build());
    }

    @PostMapping("/feign/{ruc}")
    public ResponseEntity<BaseResponse<Empresa>> registrarDesdeFeign(@PathVariable String ruc) {
        Empresa empresa = sunatUseCase.guardarDesdeFeign(ruc);
        return ResponseEntity.ok(BaseResponse.<Empresa>builder()
                .codigo(HttpStatus.CREATED.value())
                .mensaje("Registrado desde Feign")
                .data(empresa)
                .build());
    }

    @PostMapping("/retrofit/{ruc}")
    public ResponseEntity<BaseResponse<Empresa>> registrarDesdeRetrofit(@PathVariable String ruc) {
        Empresa empresa = sunatUseCase.guardarDesdeRetrofit(ruc);
        return ResponseEntity.ok(BaseResponse.<Empresa>builder()
                .codigo(HttpStatus.CREATED.value())
                .mensaje("Registrado desde Retrofit")
                .data(empresa)
                .build());
    }
}
