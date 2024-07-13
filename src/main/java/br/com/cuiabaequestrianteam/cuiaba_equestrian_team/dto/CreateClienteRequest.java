package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

@Value
public class CreateClienteRequest {

    String nome;
    String cpf;
    String telefone;

    @JsonCreator
    public CreateClienteRequest(
            final String nome,
            final String cpf,
            final String telefone
            ) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

}
