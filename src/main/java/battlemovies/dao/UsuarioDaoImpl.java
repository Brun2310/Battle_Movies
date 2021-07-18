package battlemovies.dao;

import battlemovies.modelo.Usuario;
import lombok.Data;
import org.springframework.stereotype.Component;

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

@Data
@Component
public class UsuarioDaoImpl {
    private String caminhoUsuarios = "src\\main\\java\\battlemovies\\files\\jogadores.csv";
    private Path pathUsuarios;

    @PostConstruct
    public void init(){
        this.pathUsuarios = Paths.get(caminhoUsuarios);
    }

    //Essa será a base para as classes DAO, todas terão, linhaEmClasse, formatar, getAll para manipulação dos arquivos
    public Usuario linhaEmUsuario(String linha){
        StringTokenizer st = new StringTokenizer(linha,";");
        Usuario usuario = new Usuario();
        usuario.setUsername(st.nextToken());
        usuario.setSenha(st.nextToken());
        usuario.setPontos(Integer.valueOf(st.nextToken()));
        return usuario;
    }

    public String formatar(Usuario usuario) {
        return String.format("%s;%s;%d\r\n",usuario.getUsername(),usuario.getSenha(),usuario.getPontos());
    }

    public List<Usuario> listAll() {
        List<Usuario> usuarios =  new ArrayList<>();
        try(BufferedReader br = Files.newBufferedReader(pathUsuarios)){
            usuarios = br.lines().map(this::linhaEmUsuario).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario adicionar(Usuario usuario){
        try (BufferedWriter bf = Files.newBufferedWriter(pathUsuarios, StandardOpenOption.APPEND)) {
            bf.write(formatar(usuario));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
