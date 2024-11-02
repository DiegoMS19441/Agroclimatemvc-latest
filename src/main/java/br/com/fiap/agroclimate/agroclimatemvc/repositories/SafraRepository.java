package br.com.fiap.agroclimate.agroclimatemvc.repositories;

import br.com.fiap.agroclimate.agroclimatemvc.model.Safra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SafraRepository extends JpaRepository<Safra, Long> {

    List<Safra> findAllById(Iterable<Long> ids);

}
