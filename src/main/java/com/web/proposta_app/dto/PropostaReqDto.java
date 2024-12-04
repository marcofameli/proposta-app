package com.web.proposta_app.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PropostaReqDto {

    private String nome;

    private String sobrenome;

    private String cpf;

    private String telefone;

    private Double renda;

    private Double valorSolicitado;

    private int prazoPagamento;
}
