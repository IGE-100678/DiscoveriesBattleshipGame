# ⚓ Discoveries Battleship Game

Projeto desenvolvido no âmbito da unidade curricular **Engenharia de Software** (IGE/IGE‑PL), inspirado no jogo clássico Batalha Naval, adaptado à época dos Descobrimentos Portugueses.

---

## 👥 Equipa

| Curso        | Nº Aluno | Nome                 | GitHub          |
|--------------|---------:|----------------------|-----------------|
| IGE / IGE‑PL |   111245 | Martim Saldanha Reis | @IGE-111245     |
| IGE / IGE‑PL |   111245 | Martim Saldanha Reis | @martimsdreis   |
| IGE / IGE‑PL |   100678 | Gonçalo Nunes        | @IGE-100678     |
| LEI          |    99371 | Pedro Angelino       | @PedroAngelino  |

> Substituir números, nomes e handles GitHub pelos reais do grupo.

---

## 🚢 Tipos de Navios (Época dos Descobrimentos)

A frota segue a nomenclatura histórica, mas é equivalente à Batalha Naval clássica em tamanho e quantidade de navios.

| Jogo Clássico       | Nome Descobrimentos | Nome em Inglês | Dimensão (nº de casas) | Nº de Navios |
|---------------------|---------------------|----------------|------------------------:|-------------:|
| Porta‑aviões        | Galeão              | Galleon        | 5                       | 1            |
| Navio de 4 canhões  | Fragata             | Frigate        | 4                       | 1            |
| Navio de 3 canhões  | Nau                 | Carrack        | 3                       | 2            |
| Navio de 2 canhões  | Caravela            | Caravel        | 2                       | 3            |
| Submarino           | Barca               | Barge          | 1                       | 4            |

Cada navio ocupa casas contíguas numa grelha 10x10, na horizontal ou vertical, sem se encostar a outros navios (não podem tocar, nem na diagonal).

---

## 🎮 Regras Básicas da Batalha Naval

- O jogo é jogado em **duas grelhas 10x10** para cada jogador:
  - Uma grelha representa **“o seu mar”** (onde coloca a sua frota).
  - A outra representa **“o mar do adversário”** (onde regista os tiros que dispara).

- Cada jogador posiciona **toda a sua frota** na sua própria grelha:
  - Navios podem estar encostados à borda da grelha.
  - Navios **não podem tocar noutros navios**, nem mesmo em diagonal.
  - A posição dos navios é **secreta** para o adversário.

- O jogo decorre por **turnos alternados**:
  - Em cada turno, o jogador anuncia as **coordenadas** dos tiros (linha, coluna) sobre a grelha do adversário.
  - O adversário responde indicando se cada tiro foi:
    - **Água** (não acertou em nenhum navio).
    - **Atingiu** um navio (indicando opcionalmente o tipo).
    - **Afundou** um navio (quando todas as casas desse navio foram atingidas).

- Cada jogador vai **marcando na grelha do adversário**:
  - As casas em que já disparou.
  - Os tiros na água, acertos e navios afundados.

- **Condição de vitória**:
  - Ganha o jogo o primeiro jogador a **afundar todos os navios** da frota adversária.

---

## 📌 Objetivo do Projeto

Este repositório serve como base para:
- Praticar **controlo de versões com Git** e colaboração no **GitHub**.
- Criar um **product backlog** com user stories em estilo Scrum.
- Documentar o código com **Javadoc** e automatizar tarefas com **GitHub Actions**.
- Implementar gradualmente funcionalidades avançadas (IA, visualização gráfica, persistência de jogadas, etc.).

