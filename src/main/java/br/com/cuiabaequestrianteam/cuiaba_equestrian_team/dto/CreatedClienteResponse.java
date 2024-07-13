package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto;

import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.Cliente;
import lombok.Value;


@Value
public class CreatedClienteResponse {

    Long id;
    String nome;
    String cpf;
    String telefone;

    public static CreatedClienteResponse of(final Cliente cliente) {
        return new CreatedClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getTelefone()
        );
    }
}
