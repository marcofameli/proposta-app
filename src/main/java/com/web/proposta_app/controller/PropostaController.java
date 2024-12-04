package com.web.proposta_app.controller;

import com.web.proposta_app.dto.PropostaReqDto;
import com.web.proposta_app.dto.PropostaResDto;
import com.web.proposta_app.service.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/proposta")
public class PropostaController {


    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity<PropostaResDto> criar(@RequestBody PropostaReqDto reqDto) {
        PropostaResDto response = propostaService.criar(reqDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri()).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PropostaResDto>> obterProposta() {

        return ResponseEntity.ok(propostaService.obterProposta());

    }
}