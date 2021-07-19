package battlemovies.dao;

import battlemovies.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@Component
public class UsuarioDaoImpl {
    private String caminho = "src\\main\\java\\battlemovies\\files\\jogadores.csv";
    private Path path;

    @PostConstruct
    public void init(){
        path = Paths.get(caminho);
    }

    public Usuario adicionar(Usuario usuario){
        try (BufferedWriter bf = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            bf.write(formatar(usuario));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public Usuario linhaEmUsuario(String linha){
        StringTokenizer st = new StringTokenizer(linha,",");
        Usuario usuario = new Usuario();
        usuario.setNome(st.nextToken());
        usuario.setSenha(st.nextToken());
        return usuario;
    }

    public String formatar(Usuario usuario) {
        return String.format("%s,%s\r\n",usuario.getNome(),usuario.getSenha());
    }

    public List<Usuario> getAll() {
        List<Usuario> usuarios =  new ArrayList<>();
        try(BufferedReader br = Files.newBufferedReader(path)){
            usuarios = br.lines().map(this::linhaEmUsuario).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }


}
