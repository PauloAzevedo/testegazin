package com.pauloazevedo.developers.security;




import com.pauloazevedo.developers.models.UsuarioApi;
import com.pauloazevedo.developers.repository.UsuarioRepository;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;



public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {
    
    
    private TokenService tokenService;
    
    
    private UsuarioRepository usuarioRepository;

    public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
                
    }
    
    

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);
        //System.out.println(token);
        boolean valido = tokenService.isTokenValido(token);
        //System.out.println(valido);
        if(valido){
            autenticarCliente(token);
        }
        filterChain.doFilter(request, response);
    }
    
    private void autenticarCliente(String token) {
        Long idUsuario = tokenService.getIdUsuario(token);
        UsuarioApi usuario = usuarioRepository.findById(idUsuario).get();
        Authentication authetication = new UsernamePasswordAuthenticationToken(usuario,null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authetication);
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7, token.length());
    }

    
    
}
