package battlemovies.controller;

import battlemovies.modelo.*;
import battlemovies.servicos.UsuarioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {

    @GetMapping //Pra teste de exibição
    public String mensagem(){
        return "Usuarios!";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioServiceImpl addUsuario(@RequestBody String nome, String senha) {
        if(validaEntrada(nome, senha)){
            return UsuarioServiceImpl.criarUsuario(nome, senha);
        }
        return null;
    }

    public boolean validaEntrada(String nome, String senha){
        //validação simples, necessário aprimorar com char especial e espaço
        return nome.length() >= 5 && nome.length() <= 10 && senha.length() >= 4 && senha.length() <= 8;
    }
}
