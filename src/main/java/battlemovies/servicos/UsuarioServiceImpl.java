package battlemovies.servicos;

import battlemovies.dao.UsuarioDaoImpl;
import battlemovies.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class UsuarioServiceImpl{
    private UsuarioDaoImpl usuarioDaoImpl;

//    @Autowired
    public Usuario criarUsuario(Usuario usuario){
        //Será realizado o cadastro em UsuarioDaoImpl
        //Também pode ser ignorado essa classe e enviado direto para DAO.. a definir
        return usuarioDaoImpl.adicionar(usuario);
    }
}
