/**
 * Representa o estado e lógica central de uma partida de Batalha Naval.
 *
 * Gerencia a frota do jogador, processa tiros disparados, mantém estatísticas
 * de jogo (tiros válidos/inválidos, repetidos, acertos, navios afundados) e
 * fornece métodos para visualização dos tabuleiros.
 *
 * Implementa a interface {@link IGame} e usa uma {@link IFleet} para gerir
 * os navios posicionados na grelha 10x10.
 *
 * @author fba
 * @author Martim Reis (IGE-111245) - Javadoc Ficha 1
 * @version 2.0
 * @see IGame
 * @see IFleet
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fba
 *
 */
public class Game implements IGame {
    private IFleet fleet;
    private List<IPosition> shots;

    private Integer countInvalidShots;
    private Integer countRepeatedShots;
    private Integer countHits;
    private Integer countSinks;

    /**
     * Construtor da classe Game.
     *
     * Inicializa uma nova partida com a frota especificada, lista de tiros
     * vazia e contadores de estatísticas zerados.
     *
     * @param fleet a frota do jogador que será usada nesta partida
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        this.fleet = fleet;
    }

    /**
     * Dispara um tiro numa posição específica da grelha adversária.
     *
     * Valida se a posição é válida (0-9), se já foi disparada anteriormente,
     * processa o acerto no navio se houver um e atualiza estatísticas. Retorna
     * o navio afundado se o tiro o tiver afundado, ou null caso contrário.
     *
     * @param pos posição onde disparar o tiro (linha, coluna)
     * @return o navio afundado por este tiro, ou null se não afundou nenhum
     */
    @Override
    public IShip fire(IPosition pos) {
        if (!validShot(pos))
            countInvalidShots++;
        else { // valid shot!
            if (repeatedShot(pos))
                countRepeatedShots++;
            else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);
                if (s != null) {
                    s.shoot(pos);
                    countHits++;
                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Retorna todas as posições onde foram disparados tiros válidos.
     *
     * @return lista imutável de posições de tiros válidos disparados
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * Conta o número de tiros repetidos (mesma posição disparada várias vezes).
     *
     * @return número de tiros repetidos na partida atual
     */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /**
     * Conta o número de tiros inválidos (coordenadas fora da grelha 0-9).
     *
     * @return número de tiros inválidos disparados
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**
     * Conta o número total de acertos em navios.
     *
     * @return número de tiros que acertaram em navios
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /**
     * Conta o número de navios afundados nesta partida.
     *
     * @return número de navios completamente afundados
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**
     * Conta quantos navios ainda estão a flutuar (não afundados).
     *
     * @return número de navios ainda ativos na frota
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    /**
     * Verifica se uma posição está dentro dos limites da grelha.
     *
     * @param pos posição a validar
     * @return true se linha e coluna estão entre 0 e 9, inclusive
     */
    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 && pos.getRow() <= Fleet.BOARD_SIZE &&
                pos.getColumn() >= 0 && pos.getColumn() <= Fleet.BOARD_SIZE);
    }

    /**
     * Verifica se já foi disparado um tiro nessa posição anteriormente.
     *
     * @param pos posição a verificar
     * @return true se já existe tiro nessa posição na lista
     */
    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Imprime um tabuleiro mostrando posições específicas com um marcador.
     *
     * @param positions lista de posições a marcar no tabuleiro
     * @param marker caractere a usar para marcar as posições
     */
    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);
            System.out.println();
        }
    }

    /**
     * Imprime o tabuleiro mostrando apenas os tiros válidos disparados.
     * Usa 'X' para marcar posições onde foram dados tiros válidos.
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }

    /**
     * Imprime o tabuleiro mostrando a posição de todos os navios da frota.
     * Usa '#' para marcar as posições ocupadas por navios.
     */
    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }
}
