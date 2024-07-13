package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.service;

import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.Cliente;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto.ClienteResponse;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto.CreateClienteRequest;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto.CreatedClienteResponse;

import java.util.List;

public interface ClienteService {

    List<ClienteResponse> findAll();

    ClienteResponse findById(Long id);

    CreatedClienteResponse create(CreateClienteRequest cliente);


}
