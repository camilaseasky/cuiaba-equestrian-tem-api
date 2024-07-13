package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto;

import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.Cavalo;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.Cliente;
import lombok.Value;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Value
public class CavaloResponse {

    private Long id;
    private String nome;
    private String sexo;
    private LocalDate dataNascimento;
    private Long numeroPassaporte;

    public static CavaloResponse of(final Cavalo cavalo) {
        return new CavaloResponse(
                cavalo.getId(),
                cavalo.getNome(),
                cavalo.getSexo(),
                cavalo.getDataNascimento(),
                cavalo.getNumeroPassaporte()
        );
    }
}
