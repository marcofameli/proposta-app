package com.web.proposta_app.service;


import com.web.proposta_app.dto.PropostaReqDto;
import com.web.proposta_app.dto.PropostaResDto;
import com.web.proposta_app.entity.Proposta;
import com.web.proposta_app.mapper.PropostaMapper;
import com.web.proposta_app.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PropostaService {

    private PropostaRepository propostaRepository;

    private NotificacaoRabbitService notificacaoRabbitService;


    private String exchange;


    public PropostaService(PropostaRepository propostaRepository,
                           NotificacaoRabbitService notificacaoRabbitService,
                           @Value("${spring.rabbitmq.propostapendente.exchange}") String exchange) {
        this.propostaRepository = propostaRepository;
        this.notificacaoRabbitService = notificacaoRabbitService;
        this.exchange = exchange;
    }


    public PropostaResDto criar(PropostaReqDto reqDto) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(reqDto);
        propostaRepository.save(proposta);

        notificarRabbitMQ(proposta);


        return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }

    private void notificarRabbitMQ(Proposta proposta) {
        try {
            notificacaoRabbitService.notificar(proposta, exchange);
        } catch (RuntimeException ex) {
            proposta.setIntegrada(false);
            propostaRepository.save(proposta);
        }
    }


    public List<PropostaResDto> obterProposta() {
        return PropostaMapper.INSTANCE.convertListEntityToListDto(propostaRepository.findAll());

    }
}
