package br.com.fiap.agroclimate.agroclimatemvc.repositories;

import br.com.fiap.agroclimate.agroclimatemvc.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long > {

    Usuario findByUsername(String username);
}
