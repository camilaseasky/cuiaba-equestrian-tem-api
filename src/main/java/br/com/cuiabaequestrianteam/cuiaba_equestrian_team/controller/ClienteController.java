package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.controller;

import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.Cliente;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto.*;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.service.CavaloService;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.service.ClienteService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    private final CavaloService cavaloService;

    public ClienteController(ClienteService clienteService, CavaloService cavaloService) {
        this.cavaloService = cavaloService;
        this.clienteService = clienteService;
    }

    @GetMapping()
    public ResponseEntity<List<ClienteResponse>> findAll() {
        var clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> findById(@PathVariable Long id) {
        var cliente = clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping()
    public ResponseEntity<CreatedClienteResponse> create(@RequestBody CreateClienteRequest cliente) {
        var clienteCreated = clienteService.create(cliente);
        return ResponseEntity.ok(clienteCreated);
    }

    @PostMapping("/{id}/cavalo")
    public ResponseEntity<CavaloResponse> adicionarCavalo(
            @PathVariable("id") Long idCliente,
            @RequestBody CreateCavaloRequest cavalo) {
        var cavaloCreated = cavaloService.create(idCliente, cavalo);
        return ResponseEntity.ok(cavaloCreated);
    }

}
