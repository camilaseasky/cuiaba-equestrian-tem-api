package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.repository;

import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {
}
