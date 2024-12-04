package com.web.proposta_app.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PropostaResDto {
    @Id

    private Long id;

    private String nome;

    private String sobrenome;

    private String cpf;

    private String telefone;

    private Double renda;

    private String valorSolicitadoFmt;

    private int prazoPagamento;

    private Boolean aprovada;

    private String observacao;

}
