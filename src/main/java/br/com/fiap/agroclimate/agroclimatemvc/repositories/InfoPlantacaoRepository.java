package br.com.fiap.agroclimate.agroclimatemvc.repositories;

import br.com.fiap.agroclimate.agroclimatemvc.model.InfoPlantacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoPlantacaoRepository extends JpaRepository<InfoPlantacao, Long> {
}
