package br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.repository;

import br.com.cuiabaequestrianteam.cuiaba_equestrian_team.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
