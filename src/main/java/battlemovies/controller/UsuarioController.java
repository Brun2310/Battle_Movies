package battlemovies.controller;

import battlemovies.modelo.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {
    private final List<Usuario> usuario = new ArrayList<>(); //??

    @GetMapping //Pra teste
    public String mensagem(){
        return "Usuarios!";
    }
    //Usuario = 5 a 10 caracteres; Senha = 4 a 8 caracteres(SHA-1); Sem: espaço e caractere especial
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List addPerson(@RequestBody String nome, String senha) {
        //Requisitar nome e senha e inserir num array para devolver o usuario
        return usuario;
    }
}
