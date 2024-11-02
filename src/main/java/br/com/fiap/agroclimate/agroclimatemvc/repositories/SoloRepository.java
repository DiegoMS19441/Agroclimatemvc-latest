package br.com.fiap.agroclimate.agroclimatemvc.repositories;

import br.com.fiap.agroclimate.agroclimatemvc.model.Solo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoloRepository extends JpaRepository<Solo, Long> {
}
