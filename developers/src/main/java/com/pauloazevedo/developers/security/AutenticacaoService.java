package com.pauloazevedo.developers.security;


import com.pauloazevedo.developers.models.UsuarioApi;
import com.pauloazevedo.developers.repository.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author paulo
 */
@Service
public class AutenticacaoService implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    
    
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        //Optional<Empresa> empresa = empresaRepository
        Optional<UsuarioApi> usuario = usuarioRepository.findByLogin(login);
        if(usuario.isPresent()){
            return usuario.get();
        }
        throw new UsernameNotFoundException("Dados incorretos!");
    }
    
}
