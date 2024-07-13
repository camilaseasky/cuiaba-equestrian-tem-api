package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.service.impl;

import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.Cliente;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.repository.ClienteRepository;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto.ClienteResponse;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto.CreateClienteRequest;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto.CreatedClienteResponse;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Override
    public List<ClienteResponse> findAll() {
        var clientes = clienteRepository.findAll();
        if(clientes == null || clientes.isEmpty()) {
            return new ArrayList<>();
        }
        return clientes.stream().map( cliente -> ClienteResponse.of(cliente)).collect(Collectors.toList());
    }

    @Override
    public ClienteResponse findById(Long id) {
       var cliente =  clienteRepository.findById(id).orElseThrow(NoSuchElementException::new);
       return ClienteResponse.of(cliente);
    }

    @Override
    public CreatedClienteResponse create(CreateClienteRequest cliente) {
        if(clienteRepository.existsByCpf(cliente.getCpf())) {
            throw new IllegalArgumentException("Já existe um cliente com o cpf " + cliente.getCpf());
        }
        var novoCliente = new Cliente();
        novoCliente.setNome(cliente.getNome());
        novoCliente.setCpf(cliente.getCpf());
        novoCliente.setTelefone(cliente.getTelefone());
        var createdCliente = this.clienteRepository.save(novoCliente);

        return CreatedClienteResponse.of(createdCliente);
    }
}
