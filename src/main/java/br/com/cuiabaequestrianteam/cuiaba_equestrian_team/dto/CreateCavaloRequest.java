package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Value;

import java.time.LocalDate;

@Value
public class CreateCavaloRequest {

    private String nome;
    private String sexo;
    private LocalDate dataNascimento;
    private Long numeroPassaporte;

    @JsonCreator
    public CreateCavaloRequest(
            final String nome,
            final String sexo,
            final LocalDate dataNascimento,
            Long numeroPassaporte
    ) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.numeroPassaporte = numeroPassaporte;
    }
}
