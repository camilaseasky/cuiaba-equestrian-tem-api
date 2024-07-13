package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto;

import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.Cavalo;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.Cliente;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class ClienteResponse {

    Long id;
    String nome;
    String cpf;
    String telefone;

    List<CavaloResponse> cavalos;
    public static ClienteResponse of(final Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getTelefone(),
                cliente.getCavalos().stream().map(CavaloResponse::of).collect(Collectors.toList())
        );
    }

    @Value
    public static class CavaloResponse {
        Long id;
        String nome;
        Long numeroPassaporte;

        public static CavaloResponse of(final Cavalo cavalo) {
            return new CavaloResponse(
                    cavalo.getId(),
                    cavalo.getNome(),
                    cavalo.getNumeroPassaporte()
            );
        }

    }

}
