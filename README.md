<h1 align="center">
    <img alt="BattleMovies Quizz" title="#Battle Movies Quizz" src="../Battle_Movies-main/banner.png" />
</h1>

# BattleMovies Quizz

## 💻 Sobre o projeto

Battle Movies - É um game que coloca os conhecimentos cinematográficos dos participantes a prova,
medindo quem é a pessoa que acerta mais questões sobre o assunto no quizz.

Seguindo o estilo de jogos Quizz ou Trivia, onde ganha quem "sabe mais", vamos construir uma app para medir o conhecimento dos participantes sobre filmes e séries. Para isso, vamos usar como referência o conteúdo disponível no site IMDB e consumir esses dados para nosso banco de dados via API Rest.

A aplicação, ao iniciar, verifica se existem filmes carregados no arquivo "filmes.csv". Caso esteja vazio, preenche os dados dos filmes que estarão disponíveis para jogar. Para jogar, é necessário estar cadastrado no arquivo "jogadores.csv". É necessário apenas um nome de usuário (5 a 10) e senha (4 a 8), ambos letras e números, sem caracteres especiais nem espaços. Por segurança, a senha deve ser criptografada com SHA-1.

Em cada requisição de jogada, serão informados usuário e senha, e na resposta estarão contidos dois filmes/séries. O jogador deverá responder o id daquele que ele acredita ter maior nota no IMDB. Se ele acertar, deve passar para a próxima rodada. Caso erre, ele perde "uma vida" - das três inicialmente disponíveis. Quando zerar as "vidas", será exibida sua pontuação final listada entre o ranking dos competidores.

O progresso de cada jogador será armazenado no arquivo "jogos.csv", contendo login e o progresso atual no formato "x/y" onde x=acertos e y=total. O histórico ficará em "ranking.csv" ordenado da maior pontuação para a menor.

## 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- Java 11
- Maven
- Lombok
- Spring Web MVC e Boot

## 🚀 Fluxo

* Iniciar arquivo "filmes.csv" com os filmes disponíveis para jogar. Você escolhe como fazer.


* Iniciar arquivo "jogadores.csv" com os jogadores aptos a jogar. Você escolhe como fazer.


* Em cada jogada, será feita uma requisição GET para "/quizz". A resposta contém dois filmes.


* A resposta do jogador será enviada como requisição POST para "/quizz" informando usuário, senha e id do filme/série vencedor. Tudo deve estar encapsulado no "request body". O endpoint responde verdadeiro/falso para o resultado e atualiza o progresso em "jogos.csv".


* Quando o jogador perde, o progresso final é escrito em "ranking.csv", tendo o cuidado de manter ordenado. O ranking pode ser acessado em "/ranking"

## 📝 Avaliação do Projeto

✅ Uso do modelo MVC;

✅ Divisão de responsabilidades: classes, métodos, etc;

✅ Cobertura de testes;

✅ Facilidade de uso;

✅ Realizar as funcionalidades pedidas.

## 🚧 Status 🚧

Em construção...

## 💡 Autores

* **Bruno Costa**

* **José Luiz**

* **Savio Januário**

* **Fernando Teixeira**

