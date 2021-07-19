package battlemovies.controller;

import battlemovies.dao.UsuarioDaoImpl;
import battlemovies.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDaoImpl usuarioDao;

    @GetMapping //Teste de exibição
    public String mensagem(){
        return "Usuarios!";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
     //solicitação: Post>Body>raw>JSON {"nome": "nomeDoUsuario", "senha": "senhaDoUsuario"}
    public String getNovoUsuario(@RequestBody Usuario usuario) {
        if(validarCriacao(usuario)){
        usuarioDao.adicionar(usuario);
            return "Criado com sucesso!";
        }
        return "Erro, não atende os requisitos!";
    }

    //Valida requisitos de nome e senha
    public boolean validarCriacao(Usuario usuario){
        //TODO necessário aprimorar com char especial e espaço
        return usuario.getNome().length() >= 5 && usuario.getNome().length() <= 10 && usuario.getSenha().length() >= 4 && usuario.getSenha().length() <= 8;
    }


}
