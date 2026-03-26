/**
 * Classe de entrada principal (Main) da aplicação Discoveries Battleship Game.
 *
 * Gerencia a execução das tarefas de demonstração do jogo e inicializa
 * a lógica central da partida. Utiliza o sistema de tasks para testar
 * diferentes funcionalidades do jogo de forma modular.
 *
 * @author britoeabreu
 * @author adrianolopes
 * @author miguelgoulao
 * @author Martim Reis (IGE-111245) - Javadoc Ficha 1
 * @version 2.0
 */
package iscteiul.ista;

import iscteiul.ista.battleship.Fleet;
import iscteiul.ista.battleship.Tasks;

/**
 * @author britoeabreu
 * @author adrianolopes
 * @author miguelgoulao
 */
public class App
{
    /**
     * Método principal da aplicação.
     *
     * Inicializa o jogo e executa tarefas de demonstração específicas.
     * Cada task testa um aspeto diferente da lógica do jogo:
     * - taskA(): funcionalidades básicas
     * - taskB(): colocação de frota e tiros básicos
     * - taskC(): funcionalidades avançadas
     * - taskD(): cenários complexos
     *
     * @param args argumentos de linha de comandos (não utilizados)
     */
    public static void main( String[] args )
    {
        System.out.printf("\n***  Discoveries Battleship Game ***\n");

        // Tasks.taskA();
        Tasks.taskB();
        // Tasks.taskC();
        // Tasks.taskD();
    }
}
