package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.service;

import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.Cavalo;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.ParticipacaoProva;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.Vacina;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto.CavaloResponse;
import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.dto.CreateCavaloRequest;

public interface CavaloService {

    Cavalo getById(Long id);
    CavaloResponse create(Long idCliente, CreateCavaloRequest cavalo);

    void registrarParticipacaoProva(Long idCavalo, ParticipacaoProva participacaoProva);
    void registrarVacina(Long idCavalo, Vacina vacina);
}
