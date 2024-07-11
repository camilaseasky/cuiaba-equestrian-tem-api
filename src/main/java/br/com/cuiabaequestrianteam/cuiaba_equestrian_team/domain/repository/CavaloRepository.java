package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.repository;

import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.Cavalo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CavaloRepository extends JpaRepository<Cavalo, Long> {
}
