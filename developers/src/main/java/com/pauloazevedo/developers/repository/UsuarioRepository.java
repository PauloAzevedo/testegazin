package com.pauloazevedo.developers.repository;


import com.pauloazevedo.developers.models.UsuarioApi;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author paulo
 */
public interface UsuarioRepository extends JpaRepository<UsuarioApi, Long> {
    
    Optional<UsuarioApi> findByLogin(String login);
    
    
}
