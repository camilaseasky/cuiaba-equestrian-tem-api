package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.service.impl;

import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.Cavalo;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.ParticipacaoProva;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.Vacina;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.repository.CavaloRepository;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.repository.ClienteRepository;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.repository.ParticipacaoProvaRepository;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.repository.VacinaRepository;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto.CavaloResponse;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto.CreateCavaloRequest;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.service.CavaloService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CavaloServiceImpl implements CavaloService {

    private CavaloRepository cavaloRepository;
    private ClienteRepository clienteRepository;
    private ParticipacaoProvaRepository participacaoProvaRepository;
    private VacinaRepository vacinaRepository;

    public CavaloServiceImpl(CavaloRepository cavaloRepository,
                             ClienteRepository clienteRepository,
                             VacinaRepository vacinaRepository,
                             ParticipacaoProvaRepository participacaoProvaRepository) {
        this.cavaloRepository = cavaloRepository;
        this.clienteRepository = clienteRepository;
        this.vacinaRepository = vacinaRepository;
        this.participacaoProvaRepository = participacaoProvaRepository;
    }

    @Override
    public Cavalo getById(Long id) {
        return cavaloRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public CavaloResponse create(Long idCliente, CreateCavaloRequest cavalo) {
        var cliente = clienteRepository.findById(idCliente).orElseThrow(NoSuchElementException::new);
        if(cavaloRepository.existsByNumeroPassaporte(cavalo.getNumeroPassaporte())) {
            throw new IllegalArgumentException("Já existe um cliente com o cpf " + cavalo.getNumeroPassaporte());
        }
        var novoCavalo = new Cavalo();
        novoCavalo.setNome(cavalo.getNome());
        novoCavalo.setSexo(cavalo.getSexo());
        novoCavalo.setDataNascimento(cavalo.getDataNascimento());
        novoCavalo.setNumeroPassaporte(cavalo.getNumeroPassaporte());
        novoCavalo.setProprietario(cliente);
        var createdCavalo = cavaloRepository.save(novoCavalo);
        return CavaloResponse.of(novoCavalo);
    }

    @Override
    public void registrarParticipacaoProva(Long idCavalo, ParticipacaoProva participacaoProva) {
        final var cavalo = cavaloRepository.findById(idCavalo).orElseThrow(NoSuchElementException::new);
        participacaoProva.setCavalo(cavalo);
        participacaoProvaRepository.save(participacaoProva);
    }

    @Override
    public void registrarVacina(Long idCavalo, Vacina vacina) {
        final var cavalo = cavaloRepository.findById(idCavalo).orElseThrow(NoSuchElementException::new);
        vacina.setCavalo(cavalo);
        vacinaRepository.save(vacina);
    }
}
