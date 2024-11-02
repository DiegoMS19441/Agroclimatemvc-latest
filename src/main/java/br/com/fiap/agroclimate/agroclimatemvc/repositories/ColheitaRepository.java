package br.com.fiap.agroclimate.agroclimatemvc.repositories;

import br.com.fiap.agroclimate.agroclimatemvc.model.Colheita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColheitaRepository extends JpaRepository<Colheita, Long> {
}
