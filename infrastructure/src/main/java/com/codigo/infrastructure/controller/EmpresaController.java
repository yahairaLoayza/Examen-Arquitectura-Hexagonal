package com.codigo.application.controller;

import com.codigo.application.response.BaseResponse;
import com.codigo.application.service.EmpresaService;
import com.codigo.domain.model.Empresa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping("/registrar/{ruc}")
    public ResponseEntity<BaseResponse<Empresa>> registrarEmpresaPorRuc(@PathVariable String ruc) {
        return ResponseEntity.ok(empresaService.registrarEmpresaPorRuc(ruc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Empresa>> obtenerEmpresaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.obtenerEmpresaPorId(id));
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<Empresa>>> obtenerTodasLasEmpresas() {
        return ResponseEntity.ok(empresaService.obtenerTodasLasEmpresas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<Empresa>> actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        return ResponseEntity.ok(empresaService.actualizarEmpresa(id, empresa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> eliminarEmpresa(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.eliminarEmpresa(id));
    }
}
