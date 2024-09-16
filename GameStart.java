package ProjectoPratico;

// ----- IMPORTAR CLASSES ----- //

// Importar a classe "File" da package "java.io" para criar/abrir ficheiros.

import java.io.File;
// Importar a classe "Scanner", da package "java.util", para ler.
import java.util.Scanner;
// Importar a classe "PrintWriter", da package "java.io", para escrever (não será necessária neste programa, mas foi deixada aqui para futura referência).
import java.io.PrintWriter;
// Importar a classe "FileNotFoundException", da package "java.io", para excepção que ocorre quando ocorre falha numa tentativa de abrir um ficheiro.
import java.io.FileNotFoundException;

public class GameStart {

// ----- FUNÇÕES E PROCEDIMENTOS ----- //

    /**
     * Método para imprimir o conteúdo de um ficheiro na consola.
     *
     * @param path Caminho do ficheiro
     * @throws FileNotFoundException
     */

    // Função de tipo void, com nome "printFile", com lançamento de excepção para ficheiro não encontrado
    public static void printFile(String path) throws FileNotFoundException {
        // Instanciar o scanner com nome "fileScanner" para ler um ficheiro com o caminho (path) especificado, recebido como argumento
        Scanner fileScanner = new Scanner(new File(path));
        // Criar uma variável de tipo String com o nome "line"
        String line;
        // Ciclo para ler o ficheiro
        while (fileScanner.hasNextLine()) { // Enquanto o scanner "fileScanner" tiver uma próxima linha
            line = fileScanner.nextLine(); // A variável "line" vai ser igual ao conteúdo que existe nessa linha, lida pelo fileScanner
            System.out.println(line); // E vai imprimir o conteúdo gravado em "line"
        }
    }

    /**
     * Método que devolve o número total de linhas de um ficheiro.
     *
     * @param path Caminho do ficheiro
     * @return Número total de linhas
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */

    // Função de tipo inteiro, com nome "lineCounter", com um caminho de tipo String como argumento, e com lançamento de excepção para ficheiro não encontrado
    public static int lineCounter(String path) throws FileNotFoundException {
        // Criar File chamado "ficheiro" com caminho (path) como argumento
        File ficheiro = new File(path);
        // Instanciar o scanner com nome "fileScanner" para ler "ficheiro", recebido como argumento
        Scanner fileScanner = new Scanner(ficheiro);
        // Declarar uma variável de tipo inteira com o nome "lineCount", inicializada a zero.
        int lineCount = 0;
        // Ciclo para ler o ficheiro
        while (fileScanner.hasNextLine()) { // Enquanto o scanner "fileScanner" tiver uma próxima linha
            fileScanner.nextLine(); // O scanner avança uma linha
            lineCount++; // E incrementa o valor na variável lineCount (que serve como contador)
        }
        // Devolver o valor na variável "lineCount", isto é, a contagem total de linhas do ficheiro
        return lineCount;
    }

    /**
     * Método que devolve o número total de colunas de um ficheiro.
     *
     * @param path      Caminho do ficheiro
     * @param separator Caractere que serve como separador
     * @return Número total de colunas
     * @throws FileNotFoundException
     */

    // Função de tipo inteiro, com nome "columnCounter", com um caminho (path) de tipo String e um delimitador (separator) de tipo String, como argumento, e com lançamento de excepção para ficheiro não encontrado
    public static int columnCounter(String path, String separator) throws FileNotFoundException {
        // Criar File chamado "ficheiro" com caminho (path) como argumento
        File ficheiro = new File(path);
        // Instanciar o scanner com nome "fileScanner" para ler "ficheiro", recebido como argumento
        Scanner fileScanner = new Scanner(ficheiro);
        // Declarar uma variável de tipo inteira com o nome "columnCount", inicializada a zero
        int columnCount = 0;
        // Declarar uma variável de tipo String com o nome "line", que vai ser igual à próxima linha lida pelo "fileScanner"
        String line = fileScanner.nextLine();
        // Declarar um array de tipo String com o nome lineItems, que vai ser igual à linha lida, mas separada em vários índices, através do "split", que usa o delimitador (separator) especificado para dividir e distribuir os dados lidos para os diferentes índices do array
        String[] lineItems = line.split(separator);
        // A variável "columnCount" passa a ser igual ao comprimento total (length) do array "lineItems"
        columnCount = lineItems.length;
        // Devolver o valor na variável "columnCount", isto é, a contagem total de colunas do ficheiro
        return columnCount;
    }

    /**
     * Método que grava o conteúdo de um ficheiro numa matriz.
     *
     * @param path Caminho do ficheiro
     * @return Matriz preenchida com dados do ficheiro
     * @throws FileNotFoundException
     */

    // Função de tipo String, matriz, com nome "copyFileToMatrix", com um caminho (path) de tipo String como argumento, e com lançamento de excepção para ficheiro não encontrado
    public static String[][] copyFileToMatrix(String path) throws FileNotFoundException {
        // Criar File chamado "ficheiro" com caminho (path) como argumento
        File ficheiro = new File(path);
        // Instanciar o scanner com nome "fileScanner" para ler "ficheiro", recebido como argumento
        Scanner fileScanner = new Scanner(ficheiro);
        // Declarar uma variável de tipo inteiro com o nome "lineNumber", cujo valor vai ser igual ao devolvido pela função "lineCounter", e recebe o parâmetro "path", refeente ao caminho do ficheiro.
        // Essa função vai contar o número de linhas do ficheiro, excluíndo a do cabecalho (-1)
        int lineNumber = (lineCounter(path)) - 1;
        // Declarar uma variável de tipo inteiro com o nome "columnNumber", cujo valor vai ser igual ao devolvido pela função "columnCounter", e recebe o parâmetro "path", refernte ao caminho do ficheiro, e o parâmetro referente ao delimitador (";")
        // Essa função vai contar o número de colunas do ficheiro
        int columnNumber = columnCounter(path, ";");
        // Declarar uma matriz de tipo String, com nome "filledMatrix" com o número de linhas e de colunas adequado, calculado pelas funções invocadas acima
        String[][] filledMatrix = new String[lineNumber][columnNumber];
        // Declarar uma variável de tipo String com nome "thisLine", que vai ser igual ao que o "fileScanner" ler na próxima linha
        String thisLine = fileScanner.nextLine();
        // Declarar uma variável de tipo inteiro com o nome "matrixLine", inicializada a zero, serve como contador, que é abaixo incrementado, dentro do ciclo while
        int matrixLine = 0;
        // Ciclo para registar os dados na matriz
        while (fileScanner.hasNextLine()) { // Enquanto o "fileScanner" tiver uma nova linha (hasNextLine)
            thisLine = fileScanner.nextLine(); // Na variável "thisLine" vai ficar registada a informação da linha, lida pelo scanner
            String[] lineItems = thisLine.split(";"); // Declarar uma variável de tipo String, com nome "lineItems", que é igual ao valor registado na String "thisLine", mas é dividida pelo "split" com o delimitador ";"
            for (int index = 0; index < lineItems.length; index++) { // Ciclo para iterar os items presentes no array "lineItems"
                filledMatrix[matrixLine][index] = lineItems[index]; // Nos índices (index) da matriz "filledMatrix", cuja posição específica é sempre diferente a cada iteração do ciclo, ficam gravados os dados lidos do array "lineItems"
            }
            matrixLine++; // A variável "matrixLine" é incrementada a cada iteração do ciclo while
        }
        // Devolver a matriz com nome "filledMatrix", agora preenchida com os dados do ficheiro
        return filledMatrix;
    }

    /**
     * Método para imprimir uma matriz na consola.
     *
     * @param matrix Matriz a imprimir
     */

    // Função de tipo void, com nome "printMatrix", com uma matriz de tipo String como argumento
    public static void printMatrix(String[][] matrix) {
        for (int line = 0; line < matrix.length; line++) { // Ciclo para iterar a matriz, primeiro as linhas
            for (int column = 0; column < matrix[0].length; column++) { // Dentro, num segundo ciclo interior, as colunas
                System.out.print(matrix[line][column] + "\t|\t"); // Imprime na consola a posição da matriz, composta por linha e coluna, e um "vertical tab" ladeado de "horizontal tabs", para melhorar a visualisação
            }
            System.out.println(); // Avançar uma linha
        }
    }

    /**
     * Método que avalia se um valor é ou não triangular.
     *
     * @param num Número a ser avaliado
     * @return True - Se o número é triangular // False - Se o número é não triangular
     */

    // Função de tipo booleano, com nome "triangular", com um número inteiro com nome "num", como argumento
    public static boolean triangular(int num) {
        // Declarar as variáveis de tipo inteiro: "sum", inicizalizada a zero; e "counter", inicializada a 1.
        int sum = 0, counter = 1;

        while (sum < num) { // Enquanto o valor em "sum" for menor do que o valor na variável "num"
            sum += counter; // O valor de sum passa a ser igual a ele mesmo, mais o valor de counter
            counter++; // E a variável counter, que serve como contador, é incrementada

            if (sum == num) { // Se o valor em "sum" e o valor em "num" forem iguais
                return true; // Devolve o valor true, e significa que o número é triangular
            }
        }
        // Se o valor não entra na condição acima, significa que o "num" apresentado não foi confirmado como triangular, sendo devolvido o valor false
        return false;
    }

    /**
     * Método que avalia se um valor é múltiplo de 5 ou não.
     *
     * @param num Número a ser avaliado
     * @return True - se é múltiplo de 5 // False - se não é múltiplo de 5
     */

    // Função de tipo booleano, com nome "multiple5", com um número inteiro com nome "num", como argumento
    public static boolean multiple5(int num) {
        if (num % 5 == 0) { // Se o resto da divisão inteira do valor na variável num e de 5 for igual a zero
            return true; // Devolve o valor true, e significa que o número avaliado é um número múltiplo de 5
        } else { // Caso contrário
            return false; // Devolve o valor false, porque o número não é múltiplo de 5
        }
    }
    // Função de tipo double, com nome "totalVendas", com matriz de tipo string com nome "matrixGameStart" como argumento

    /**
     * Método que calcula o número total de vendas a partir da coluna 8 de uma matriz
     *
     * @param matrixGameStart Matriz a ser avaliada
     * @return Número total de vendas
     */
    public static double totalVendas(String[][] matrixGameStart) {
        // Declarar variável de tipo double com nome "numeroTotalVendas", inicializada a zero
        double numeroTotalVendas = 0;
        // Ciclo para iterar a matriz
        for (int line = 1; line < matrixGameStart.length; line++) { // Percorre as linhas
            for (int column = 0; column < matrixGameStart[0].length; column++) { // Percorre as colunas
                if (column == 8) { // Se a coluna for a 8
                    // O valor encontrado nesta posição da matriz (esta linha e esta coluna) é guardado na variável "numeroTotalVendas", a cujo valor é somado o novo valor recebido em cada iteração
                    numeroTotalVendas += Double.parseDouble(matrixGameStart[line][column]);
                }
            }
        }
        // Devolver o valor final guardado na variável "numeroTotalVendas"
        return numeroTotalVendas;
    }

    // Procedimento de tipo void (não devolve dados), com nome "gameStartLogo"

    /**
     * Procedimento que imprime o logótipo da GameStart na consola.
     */
    public static void gameStartLogo() {

        System.out.println("\n\n");
        System.out.println("      ██████╗  █████╗ ███╗   ███╗███████╗███████╗████████╗ █████╗ ██████╗ ████████╗     ");
        System.out.println("     ██╔════╝ ██╔══██╗████╗ ████║██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗╚══██╔══╝     ");
        System.out.println("     ██║  ███╗███████║██╔████╔██║█████╗  ███████╗   ██║   ███████║██████╔╝   ██║        ");
        System.out.println("     ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  ╚════██║   ██║   ██╔══██║██╔══██╗   ██║      ");
        System.out.println("     ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗███████║   ██║   ██║  ██║██║  ██║   ██║       ");
        System.out.println("      ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝     ");
        System.out.println("\n");
        System.out.println("                     BEM-VINDO À LOJA DE JOGOS FICTÍCIA DOS FAMOSOS                     ");
        System.out.println("\n\n");

    }

    /**
     * Procedimento que imprime uma mensagem para o user Admin na da saída do programa.
     */
    // Procedimento de tipo void (não devolve dados), com nome "sairAdmin"
    public static void sairAdmin() {

        System.out.println("\n\n");
        System.out.println("`7MMF'   `7MF' .g8\"\"8q. `7MMF'   MMP\"\"MM\"\"YMM `7MM\"\"\"YMM       .M\"\"\"bgd `7MM\"\"\"YMM  `7MMM.     ,MMF'`7MM\"\"\"Mq.`7MM\"\"\"Mq.  `7MM\"\"\"YMM  ");
        System.out.println("  `MA     ,V .dP'    `YM. MM     P'   MM   `7   MM    `7      ,MI    \"Y   MM    `7    MMMb    dPMM    MM   `MM. MM   `MM.   MM    `7  ");
        System.out.println("   VM:   ,V  dM'      `MM MM          MM        MM   d        `MMb.       MM   d      M YM   ,M MM    MM   ,M9  MM   ,M9    MM   d    ");
        System.out.println("    MM.  M'  MM        MM MM          MM        MMmmMM          `YMMNq.   MMmmMM      M  Mb  M' MM    MMmmdM9   MMmmdM9     MMmmMM    ");
        System.out.println("    `MM A'   MM.      ,MP MM      ,   MM        MM   Y  ,     .     `MM   MM   Y  ,   M  YM.P'  MM    MM        MM  YM.     MM   Y  , ");
        System.out.println("     :MM;    `Mb.    ,dP' MM     ,M   MM        MM     ,M     Mb     dM   MM     ,M   M  `YM'   MM    MM        MM   `Mb.   MM     ,M ");
        System.out.println("      VF       `\"bmmd\"' .JMMmmmmMMM .JMML.    .JMMmmmmMMM     P\"Ybmmd\"  .JMMmmmmMMM .JML. `'  .JMML..JMML.    .JMML. .JMM..JMMmmmmMMM ");
        System.out.println("\n                                     SE QUISER RECEBER O SEU SALÁRIO E NÃO QUISER SER DESPEDIDO                                     ");

    }

    /**
     * Procedimento que imprime uma mensagem para o user Cliente na saída do programa.
     */
    // Procedimento de tipo void (não devolve dados), com nome "sairCliente"
    public static void sairCliente() {

        System.out.println("\n\n");
        System.out.println("                                     .^^:.            .:^^:                                         ");
        System.out.println("                                   7P5YJ5PP^        ~5PYYYYG?                                       ");
        System.out.println("                                 .GB^     ?&~      YB7.    ^@?                                      ");
        System.out.println("                                 Y&.       P&JJY55P&7.     ~@!                                      ");
        System.out.println("                                 ?&^     .JB5!^::::^7PG7 :5#?                                       ");
        System.out.println("                                  7G5!: ~BY.          ^PG7~.                                        ");
        System.out.println("                                    !J5YB5          :?. ~#?                                         ");
        System.out.println("                                        ?G.    YJ   :7:  :#J                                        ");
        System.out.println("                                       .&5     ..         7@:                                       ");
        System.out.println("                                        GB     .^~!!~^.   :@?              .::^^^^^^:..             ");
        System.out.println("                                        ^&5  .JPY????J55?..@?        ^7JYY55YYJJJJYY#@&#GJY~        ");
        System.out.println("                                         :B57#Y ^7     ^JBG&:    ^?5PY?~:::^!?JY5YYJYY7!!~^.        ");
        System.out.println("                        .....              J@@~ !BYY5J  .G@! .~JP57:  :!J55YJ7^:..                  ");
        System.out.println("             .^!7?JY5555555555YJ?!~:       5G7Y5J77777?Y5BB^?P57. .!JPY?~.                          ");
        System.out.println("        :!?JYYJ?7~~^::..     .:^!7J55Y7:  GP   .^7???7!^ .7B#^ .!YPY!.                              ");
        System.out.println("        ~?5#Y7~^.                   .^7Y5P@:                7#GP?^                                  ");
        System.out.println("           !5GGGP555Y55Y555555555YJ?7!^^^GP                  5@Y                                    ");
        System.out.println("                 ...............::^!77JJY@7                   :#Y                                   ");
        System.out.println("                                        ^@7                    ~@7                                  ");
        System.out.println("                                        ^@7                     Y&:                                 ");
        System.out.println("                                        :@J                     .@J                                 ");
        System.out.println("                                         GB                      GG                                 ");
        System.out.println("                                         7@^                     5B                                 ");
        System.out.println("                                         .&Y                     5#                                 ");
        System.out.println("                                          !@~             ..::~~~B5                                 ");
        System.out.println("                                       .:..5#7!7???JYYYYPB555YJ7Y@!                                 ");
        System.out.println("                                       !55JY@G?7!~^7@!..~@^      5#.                                ");
        System.out.println("                                           ^@^     5B    7B7     ~@~                                ");
        System.out.println("                                            GG:   7@!     ~PGJ!~7GP.                                ");
        System.out.println("                                             ?P5Y5G!        :!???~                                  ");
        System.out.println("                                               :^:                                                  ");
        System.out.println("");
        System.out.println("\n                      O MACACO TOBIAS (A NOSSA MASCOTE) AGRADECE A SUA VISITA                      ");

    }

    /**
     * Procedimento que imprime uma mensagem para o formador Vítor
     */
    // Procedimento de tipo void (não devolve dados), com nome "vitor"
    public static void vitor() {

        System.out.println("\n               Desenvolvido por: Ricardo Almeida | Curso Software Developer | CESAE Digital, Porto | 2023               ");
        System.out.println("\n*********************************************************************************************************************************************");
        System.out.println("\nO formando, numa tentativa de agradar o formador Vítor com \"graxa\", agradece os seus sábios ensinamentos e técnicas de motivação.\nEspera ainda ter correspondido às espectativas e de ter proporcionado uma experiência divertida na análise e avaliação deste projecto prático.");

    }

    // ----- MAIN ----- //

    // Função de tipo de dados void (não devovle dados), com nome "main", e com lançamento de excepção para ficheiro não encontrado
    public static void main(String[] args) throws FileNotFoundException {
        // Invocar a função que apresenta uma mensagem inicial no arranque do programa
        gameStartLogo();
        // Abrir o ficheiro existente no caminho indicado
        File fileGameStart = new File("filesGameStart/GameStart_V2.csv");
        // Instanciar um scanner com nome "scannerFile" para ler o ficheiro, passado como argumento
        Scanner scannerFile = new Scanner(fileGameStart);
        // Criar uma matriz com nome "matrixGameStart" e invoca a função "copyFileToMatrix" para copiar os dados do ficheiro, cujo caminho é passado como argumento
        String[][] matrixGameStart = copyFileToMatrix("filesGameStart/GameStart_V2.csv");
        // Declarar variáveis
        int user = 0; // Variável de tipo inteiro com o nome "user" que vai identificar o utilizador do programa como Admin ou Cliente
        double totalVendas = 0; // Variável de tipo double com o nome "totalVendas", inicializada a zero
        int opcaoAdmin, opcaoCliente; // Variáveis de tipo inteiro com os nomes "opcaoAdmin" e "opcaoCliente", para identificar as opções feitas dentro dos menus de Admin e de Cliente
        String continuarAdmin = "";
        String continuarCliente = "";
        // Ciclo do while para identificação do user como Admin ou como Cliente
        do {
            // Instanciar scanner com nome "input" para input do utilizador
            Scanner input = new Scanner(System.in);
            // Apresentar ao utilizador as opções disponíveis
            System.out.print("\nInsira [1] para Administrador ou [2] para Cliente: ");
            // Gravar o input do utilizador na variável "user"
            user = input.nextInt();
            // Apresentar o menu de confirmação de identificação do utilizador
            switch (user) { // Para a variável user
                case 1: // Caso esteja gravada a opção 1
                    // Apresentar mensagem de confirmação de identificação como Administrador.
                    System.out.println("\nEstá identificado como ADMIN\n\nAgora trabalhe, que é para isso que lhe pagamos!");
                    break;
                case 2: // Caso esteja gravada a opção 2
                    // Apresentar mensagem de confirmação de identificação como Cliente.
                    System.out.println("\nEstá identificado como CLIENTE\n\nCompre-nos todos os jogos que a sua conta bancária permitir!");
                    break;
                default: // Caso a opção inserida não seja 1 ou 2 e, portanto, inválida
                    // Apresentar mensagem informativa de opção inválida
                    System.out.println("\nOPÇÃO INVÁLIDA\nTente novamente. Desta vez, veja com muita atenção em que tecla pressiona.");
                    break;
            }
        } while (user != 1 && user != 2);  // Enquanto for inserido (na variável user) um valor diferente de 1 e diferente de 2
        // Pedido de palavra-passe, no caso de o user se identificar como Admin
        // Variável final (o valor não pode ser alterado) de tipo inteiro, com o nome "password" onde está guardada a palavra-passe de acesso ao menu de Admin
        final int password = 123456789;
        // Se o tipo de user escolhido for 1 (Admin)
        if (user == 1) {
            // Instanciar o scanner para input do utilizador
            Scanner input = new Scanner(System.in);
            // Declarar variável de tipo inteiro com nome "passwordInput", inicializada a zero
            int passwordInput = 0;
            int wrongPassword = 0;
            // Ciclo while para verificação de palavra-passe
            // Enquanto o valor em "password" (válida) for diferente do valor em "passwordInput" (introduzida)
            while (password != passwordInput) {
                // Solicitar palavra-passe ao utilizador, pedindo input
                System.out.print("\nIntroduza a sua palavra-passe: ");
                // Registar o input do utilizador na variável "passwordInput"
                passwordInput = input.nextInt();
                // Se a palavra-passe introduzida (passwordInput) for diferente daquela que está registada (password) e que é a única válida
                if (password != passwordInput) {
                    // Apresentar mensagem ao utilizador, para que tente novamente
                    System.out.println("\nPALAVRA-PASSE INCORRECTA!");
                    wrongPassword++;
                    System.out.println("\nErrou " + wrongPassword + " vezes a palavra-passe.");
                    if (wrongPassword > 2) {
                        System.out.println("Achava que ia bloquear o sistema por excesso de tentativas erradas?\nAchou mal! O patrão não permite que use essa desculpa para não trabalhar. Fica aqui de castigo até acertar!\nDICA: Sabe perfeitamente que deve introduzir a que se encontra na página 3 do enunciado do projecto prático.");
                    }
                }
            }
            // Uma vez fora do ciclo, significa que a palavra-passe introduzida (passwordInput) corresponde à válida (password)
            // É apresentada uma mensagem de sucesso e um raspanete do patrão.
            System.out.println("\nA sua palavra-passe está correcta.\nParabéns! Já sabe como inserir algarismos numa sequência de 1 a 9 no teclado alfanumérico!\n\n*** IMPORTANTE ***\nO patrão pediu ao programador para lhe dar o seguinte recado:\nAltere a palavra-passe assim que puder. Isto assim não é nada seguro, e esta não é palavra-passe que se use seja onde for!\nSerá despedido se não a alterar imediatamente, pois a sua irresponsabilidade coloca em causa a segurança da nossa empresa.\nComo sabe, a nossa base de dados contém informação sensível sobre pessoas muito poderosas que nos podem processar.");
            // Menu a apresentar ao user Admin, depois da validação de credenciais.
            do {
                // Imprimir as opções do menu na consola
                System.out.println("\n\n\n***** MENU DE ADMINISTRADOR *****");
                System.out.println("[1] Ver ficheiro");
                System.out.println("[2] Vendas");
                System.out.println("[3] Lucros");
                System.out.println("[4] Clientes");
                System.out.println("[5] Premium");
                System.out.println("[0] Sair");
                System.out.print("\nESCOLHA UMA DAS OPÇÕES: ");
                // Instanciar scanner com nome "inputAdmin", que vai receber o input do utilizador quanto às opções do menu a que pretende aceder
                Scanner inputAdmin = new Scanner(System.in);
                // Declarar variável de tipo inteiro com nome "opcaoAdmin" e regista a opção introduzida pelo utilizador
                opcaoAdmin = inputAdmin.nextInt();
                // Switch case para as diferentes opções que o Admin tem à disposição
                switch (opcaoAdmin) { // Para a variável opcaoAdmin
                    case 1: // Caso esteja gravada a opção 1
                        // Apresentar mensagem
                        System.out.println("\n\n*** ABRIR FICHEIRO **");
                        // Apresentar ficheiro conforme está
                        System.out.println("\n* VERSÃO EM BRUTO *\n");
                        // Invoca a função "printFile" para imprimir o ficheiro cujo caminho está passado como argumento
                        printFile("filesGameStart/GameStart_V2.csv");
                        // Versão com visualização melhorada
                        System.out.println("\n* VERSÃO MELHORADA *\n");
                        // Invoca a função "printMatrix" para imprimir na consola a matriz "matrixGameStart", passada como argumento
                        printMatrix(matrixGameStart);
                        break;
                    case 2: // Caso esteja gravada a opção 2
                        // Apresentar mensagem
                        System.out.println("\n\n*** VENDAS ***");
                        // Declarada variável de tipo inteiro com nome "numeroVendas", cujo valor é igual ao devolvido pela função "lineCounter", cujo caminho é passado como argumento, ao qual é subtraído 1, referente ao cabeçalho, que não é uma venda
                        int numeroVendas = lineCounter("filesGameStart/GameStart_V2.csv") - 1;
                        // Apresentar resultados calculados quanto ao número de vendas
                        System.out.println("\nForam feitas " + numeroVendas + " vendas.");
                        System.out.println("\nO valor total de vendas foi €" + (totalVendas(matrixGameStart)));
                        break;
                    case 3: // Caso esteja gravada a opção 3
                        // Apresentar mensagem
                        System.out.println("\n\n*** LUCROS ***");
                        // Apresentar cálculo para chegar ao valor dos lucros
                        System.out.print("\nA GameStart auferiu lucros de €");
                        // Cálculo sugerido pela Sra. Contabilista Sofia Carvalho (se estiver errado, apenas a ela que poderão ser imputadas responsabilidades)
                        System.out.print((totalVendas(matrixGameStart)) - (totalVendas(matrixGameStart)) / 1.2);
                        System.out.println("\n\nComo pode verificar, não temos dinheiro para lhe pagar um salário.\nVai ter de continuar a trabalhar aqui sem receber.\nÉ uma óptima oportunidade que lhe damos para que possa \"ganhar experiência\".");
                        break;
                    case 4: // Caso esteja gravada a opção 4
                        // Apresentar mensagem
                        System.out.println("\n\n*** CLIENTES ***");
                        // Apresentar mensagem para que o suer possa inserir a ID
                        System.out.print("\nInsira a ID do cliente a pesquisar: ");
                        // Instanciar scanner com nome "inputCliente", que vai receber o input do utilizador
                        Scanner inputCliente = new Scanner(System.in);
                        // Declarar variável de tipo String onde vai ficar registado o ID inserido pelo utilizador
                        String idCliente = inputCliente.next();
                        // Limitar entrada de número introduzido (não existem ID inferiores a 1 ou superiores a 60)
                        // Se o valor em idCliente (convertido de string para inteiro) for menor do que 1 ou maior do que 60
                        if (Integer.parseInt(idCliente) < 1 || Integer.parseInt(idCliente) > 60) {
                            // Apresentar mensagem ao utilizador
                            System.out.println("\nA ID cliente inserida não existe.");
                        }
                        // Declarar variável de tipo booleano com nome "pesquisado", inicializada a false
                        boolean pesquisado = false;
                        // Ciclo para iterar a matriz e encontrar o cliente pesquisado
                        for (int line = 1; line < matrixGameStart.length; line++) { // Percorre as linhas da matriz "matrixGameStart"
                            // Se na coluna 1 o valor encontrado for igual ao inserido em "idCliente" e diferente do valor em "pesquisado"
                            if (matrixGameStart[line][1].equals(idCliente) && !pesquisado) {
                                // A variável "pesquisado" passa a assumir o valor true, impedindo que sejam apresentados duplicados
                                pesquisado = true;
                                // Imprimir na consola os dados do cliente, constantes das colunas 2, 3 e 4 da matriz
                                System.out.println("\nCliente:\n- Nome: " + matrixGameStart[line][2] + "\n- Contacto: " + matrixGameStart[line][3] + "\n- Email: " + matrixGameStart[line][4]);
                            }
                        }
                        break;
                    case 5: // Caso esteja gravada a opção 5
                        // Apresentar mensagem
                        System.out.println("\n\n*** PREMIUM ***\n\nSecção de clientes multimilionários, detentores de fortunas inimagináveis.");
                        // Declarar variável de tipo double com nome "precoJogoMaisCaro", inicializada a zero
                        double precoJogoMaisCaro = 0;
                        // Declarar variável de tipo String com nome "nomeJogoMaisCaro", inicializada a vazio (mas não null)
                        String nomeJogoMaisCaro = "";
                        // Ciclo para iterar a matriz e identificar nela o nome do jogo mais caro e o preço do mesmo
                        for (int line = 1; line < matrixGameStart.length; line++) { // Percorre as linhas da matriz
                            for (int column = 0; column < matrixGameStart[0].length; column++) { // Num ciclo aninhado, percorre as colunas
                                // Se o valor na coluna 8 da linha que está a ser analisada da matiz (convertida para tipo double) for maior do que o valor guardado na variável "precoJogoMaisCaro"
                                if (Double.parseDouble(matrixGameStart[line][8]) > precoJogoMaisCaro) {
                                    // A variável "nomeJogoMaisCaro" assume o valor constante da coluna 7 (nome do jogo) desta linha
                                    nomeJogoMaisCaro = matrixGameStart[line][7];
                                    // A variável "precoJogoMaisCaro" assume o valor constante da coluna 8 (preço do jogo) desta linha
                                    precoJogoMaisCaro = Double.parseDouble(matrixGameStart[line][8]);
                                }
                            }
                        }
                        // Apresentar resultados encontrados na matriz, quanto ao nome e respectivo preço do jogo mais caro
                        System.out.print("\nLista de clientes que estouraram €" + precoJogoMaisCaro + " no jogo " + nomeJogoMaisCaro + ":\n");
                        // Ciclo que vai iterar novamente a matriz para encontrar o nome dos clientes que compraram o jogo mais caro
                        for (int line = 1; line < matrixGameStart.length; line++) { // Percorre as linhas da matriz, começando na linha 1
                            // Se o valor na coluna 7 corresponde ao valor guardado na variável "jogoMaisCaro"
                            if (matrixGameStart[line][7].equals(nomeJogoMaisCaro)) {
                                // Apresenta o nome do cliente (informação na coluna 2) que comprou o jogo (cujo nome aparece na coluna 7)
                                System.out.print("- " + matrixGameStart[line][2] + "\n");
                            }
                        }
                        break;
                    case 0: // Caso esteja gravada a opção 0, é apresentada a opção ao utilizador se quer voltar a ver o menu, ou se pretende encerrar o programa
                        break;
                    default: // Caso a opção inserida seja inválida, apresentar mensagem ao utilizador
                        System.out.println("\nOPÇÃO INVÁLIDA!");
                }
                // Apresentar mensagem para o utilizador
                System.out.println("\n\n************************\nPretende voltar ao MENU?");
                // Pedir input ao utilizador
                System.out.println("\n- [S] para SIM\n- [Outra tecla] para SAIR e encerrar o programa\n\nINSERIR: ");
                // Instanciar scanner com nome "inputClintinuarAdmin" para ler a opção
                Scanner inputContinuarAdmin = new Scanner(System.in);
                // Variável "continuarAdmin" assume valor inserido
                continuarAdmin = inputContinuarAdmin.next();
            }
            // Enquanto "opcaoAdmin" for diferente de zero (sair), e o utlizador inseir "s" ou "S" (ignore case), volta a correr o ciclo que mostra o menu
            while (opcaoAdmin != 0 && continuarAdmin.equalsIgnoreCase("S"));
            // Invocar função que imprime na consola uma mensagem
            sairAdmin();
        }
        // Se o tipo de user escolhido for 2 (Cliente)
        if (user == 2) {
            // Menu a apresentar ao user Cliente
            do {
                // Imprimir as opções do menu na consola
                System.out.println("\n\n\n***** MENU DE CLIENTE *****");
                System.out.println("[1] Registo");
                System.out.println("[2] Estacionamento");
                System.out.println("[3] Lista de Jogos");
                System.out.println("[4] Pesquisa por Editora");
                System.out.println("[0] Sair");
                System.out.print("\nESCOLHA UMA DAS OPÇÕES: ");
                // Instanciar scanner com nome "inputCliente", que vai receber o input do utilizador quanto às opções do menu a que pretende aceder
                Scanner inputCliente = new Scanner(System.in);
                // Declara variável de tipo inteiro com nome "opcaoCliente" e regista a opção introduzida pelo utilizador
                opcaoCliente = inputCliente.nextInt();
                // Switch case para as diferentes opções que o Admin tem à disposição
                switch (opcaoCliente) { // Para a variável opcaoCliente
                    case 1: // Caso esteja gravada a opção 1
                        // Apresentar mensagem
                        System.out.println("\n\n*** REGISTO ***");
                        // Instanciar scanner com nome "registoCliente"
                        Scanner registoCliente = new Scanner(System.in);
                        // Pedir input ao utilizador
                        System.out.print("\nInsira o seu nome: ");
                        // Guardar o que foi inserido numa variável de tipo string com nome "nomeCliente"
                        String nomeCliente = registoCliente.nextLine();
                        // Pedir input ao utilizador
                        System.out.print("\nInsira o seu contacto telefónico: ");
                        // Guardar o que foi inserido numa variável de tipo inteiro com nome "contactoTel"
                        int contactoTel = registoCliente.nextInt();
                        // Pedir input ao utilizador
                        System.out.print("\nInsira o seu e-mail: ");
                        // Guardar o que foi inserido numa variável de tipo string com nome "email"
                        String email = registoCliente.next();
                        // Apresentar mensagem de sucesso
                        System.out.println("\n\nCaro/a " + nomeCliente + ", a sua conta foi registada com sucesso!\nAgora já podemos encher a conta de e-mail (" + email + ") com spam!");
                        // Apresentar os dados inseridos pelo utilizador
                        System.out.println("\nOs dados que inseriu foram os seguintes:");
                        System.out.println("\n- Nome: " + nomeCliente + "\n- Contacto: " + contactoTel + "\n- E-mail: " + email);
                        break;
                    case 2: // Caso esteja gravada a opção 2
                        // Apresentar mensagem
                        System.out.println("\n\n*** ESTACIONAMENTO ***");
                        // Apresentar uma justificação para a disponibilidade dos lugares de estacionamento
                        System.out.println("\nTemos 121 lugares de estacionamento à disposição dos nossos clientes.\n\nInfelizmente, o funcionário do parque de estacionamento tem uma doença muito rara relacionada com números triangulares, acreditando que as maiores desgraças lhe vão\nacontecer se permitir que os clientes e os funcionários estacionem os seus automóveis nesses lugares, pelo que estão sempre vazios, não podendo contudo ser utilizados.\nJá o patrão tem uma fixação obsessiva por estacionar em lugares múltiplos de 5, pelo que encontrará esses reservados para ele.\nAssim, os lugares que sobram para que o estimado cliente possa estacionar a sua viatura, estão muito longe e debaixo de umas árvores que libertam\nmuita resina e são frequentadas por aves cuja actividade favorita é defecar, o que em ambos os casos pode danificar a pintura do seu automóvel.\nNão nos responsabilizamos pelos danos mas, se quiser, ao fundo da rua pode encontrar o serviço de lavagem automóvel do irmão do patrão.\nSe ainda assim tiver interesse, os lugares vagos estão assinalados com estes números:\n\nLUGARES DISPONÍVEIS:");
                        // Declarar 8kuma variável de tipo inteiro com nome "num", inicializada a 1
                        int num = 1;
                        // Ciclo para encontrar números triangulares e múltiplos de 5
                        while (num <= 121) { // Limitar o intervalo de 1 até 121 (máximo)
                            if (triangular(num)) { // Invoca função para avaliar se os números são triangulares
                                if (multiple5(num)) { // Invoca função para avaliar se os números são múltiplos de 5
                                    System.out.print(num); // Se o número entrou em ambos os "if", é apresentado na consola
                                    System.out.print("\t"); // Horizontal tab que funciona como separador entre números apresentados
                                }
                            }
                            num++; // Dentro do ciclo while, incrementa o valor de "num", que serve como contador
                        }
                        break;
                    case 3: // Caso esteja gravada a opção 3
                        // Apresentar mensagem
                        System.out.println("\n\n*** LISTA DE JOGOS ***");
                        // Criar um array com nome "listaJogos" com a mesma extensão da matriz "matrixGameStart"
                        String[] listaJogos = new String[matrixGameStart.length];
                        // Ciclo para copiar os dados da matriz para o novo array "listaJogos"
                        for (int line = 0; line < matrixGameStart.length; line++) { // Percorre as linhas da matriz "matrixGameStart"
                            listaJogos[line] = matrixGameStart[line][7]; // Grava no presente índice (line) do array "listaJogos" o valor que consta na presente linha e coluna 7 da matriz "matrixGameStart"
                        }
                        // Apresentar mensagem
                        System.out.println("\nAbaixo pode consultar a lista completa de jogos disponíveis na nossa loja.\nAinda bem que não foi pedido ao programador para organizar esta lista por ordem alfabética.\nJá foi o cabo dos trabalhos não ter o nome dos jogos a figurar mais do que uma vez...\n");
                        // Declarar variável de tipo booleano com nome "jogoPesquisado" inicializada com o valor false
                        boolean jogoPesquisado = false;
                        // Ciclo para controlar a apresentação de nomes de jogos duplicados
                        for (int lineA = 0; lineA < listaJogos.length; lineA++) { // Percorre o array "listaJogos"
                            for (int lineB = 0; lineB < listaJogos.length; lineB++) { // Novo ciclo dentro do já existente
                                // Se "lineA" for diferente de "lineB" e o índice "lineA" do array "listaJogos" for igual ao índice "lineB" do array "listaJogos"
                                if (lineA != lineB && listaJogos[lineA].equals(listaJogos[lineB])) {
                                    // A variável "jogoPesquisado" passa a assumir o valor true, porque este jogo já foi encontrado
                                    jogoPesquisado = true;
                                }
                            }
                            // Se o valor de "jogoPesquisado" for false, significa que ainda não foi encontrado antes
                            if (jogoPesquisado == false) {
                                // Se não foi encontrado antes, o nome desse jogo é apresentado na consola.
                                System.out.println("- " + listaJogos[lineA] + "\t");
                            } else {
                                // Caso contrário, o valor de "jogoPesquisado" passa a ser false
                                jogoPesquisado = false;
                            }
                        }
                        break;
                    case 4: // Caso esteja gravada a opção 4
                        // Apresentar mensagem
                        System.out.println("\n\n*** PESQUISA POR EDITORA ***");
                        // Pedir input ao utilizador
                        System.out.print("\nInsira o nome da editora a pesquisar: ");
                        // Instanciar scanner com nome "inputEditora"
                        Scanner inputEditora = new Scanner(System.in);
                        // Guardar o que foi inserido numa variável de tipo string com o nome "editora"
                        String editora = inputEditora.nextLine();
                        // Apresentar mensagem
                        System.out.println("\nLista completa de jogos disponíveis da editora " + editora + ":");
                        // Apresentar nome da editora com formatação visual
                        System.out.println("\n** " + editora + " **");
                        // Criar array de tipo string com nome "listaCategorias" onde ficam gravadas todas as categorias constantes da matriz.
                        String[] listaCategorias = new String[matrixGameStart.length]; // Array assume comprimento da matriz
                        // Ciclo que itera a matriz "matrixGameStart" e copia os dados da coluna 6 desta para os índices do array "listaCategorias"
                        for (int index = 0; index < listaCategorias.length; index++) {
                            // O valor no índice do array "listaCategorias" assume o mesmo valor que existe na coluna 6 da matriz "matrixGameStart"
                            listaCategorias[index] = matrixGameStart[index][6];
                        }
                        // Variável de tipo booleano com nome "categoriaEncontrada", para controlar os dados duplicados, inicializada com o valor false.
                        boolean categoriaEncontrada = false;
                        // Variável de tipo booleano com nome "jogoEncotrado", para controlar os dados duplicados, inicializada com o valor false.
                        boolean jogoEncontrado = false;
                        for (int index = 0; index < listaCategorias.length; index++) {
                            if (matrixGameStart[index][5].equalsIgnoreCase(editora) && matrixGameStart[index][6].equalsIgnoreCase(listaCategorias[index])) {
                                if (categoriaEncontrada == false) {
                                    System.out.println("\n__" + listaCategorias[index] + "__");
                                    System.out.println(matrixGameStart[index][7]);
                                }
                            }
                        }
                        System.out.println("\n\nESTIMADO CLIENTE\nO programador que desenvolveu esta funcionalidade é inexperiente. Na verdade, nem um estagiário é.\nComeçou a aprender estas coisas num curso dos computadores há coisa de um mês e foi o que arranjamos de borla.\nO rapaz é extremamente persistente e trabalhou com afinco até se aproximar o derradeiro prazo final para entregar o trabalho.\nFrustrado e exausto, acabou por concluir que esta é uma tarefa demasiado exigente para as suas\ncapacidades, não tendo conseguido desenvolver esta funcionalidade da forma que lhe foi pedido.\nPara não ser despedido da GameStart, chorando baba e ranho, ajoelhou-se perante o patrão, beijou-lhe os pés, e prometeu continuar a aprender.\nGarante que vai saber resolver isto de forma mais fácil e prática, com o que vai aprender nas próximas aulas de um tal Vítor, lá no curso dos computadores.\nSe este moço não resolver isto a curto prazo, será despedido, e arranjamos outro que saiba fazer isto.\nDe qualquer forma, o patrão e o homem do parque de estacionamento já se mostraram furiosos perante a insolência deste funcionário, que insiste em\nestacionar o seu automóvel todos os dias no primeiro lugar vago que encontra no parque de estacionamento, não verificando se estão\nassinalados com números múltiplos de 5, ou com números triangulares, revelando não só um atrevimento que desafia a autoridade do patrão,\ncomo também uma profunda falta sensibilidade relativamente ao sofrimento atroz que impõe ao funcionário do parque, que não suporta\nsequer a existência de números triangulares, tendo já metido baixa devido às consequências nefastas dos comportamentos do programador.\nO Estimado Cliente pode usar a funcionalidade de pesquisa pela editora, mas deve estar consciente de que terá\nde lidar com a inolvidável experiência que será a apresentação de categorias e nomes de jogos em duplicado.\nPedimos desde já desculpa pelo incómodo. Estamos a trabalhar para melhorar o nosso serviço.\nPor favor não nos deixe uma má review e venha comprar nos nossos jogos.\nMuito Obrigadas.\nA Gerência da GameStart");
                        break;
                    case 0: // Caso esteja gravada a opção 0, é apresentada a opção ao utilizador se quer voltar a ver o menu, ou se pretende encerrar o programa
                        break;
                    default: // Caso a opção inserida seja inválida
                        // Apresentar mensagem para o utilizador
                        System.out.println("\nOPÇÃO INVÁLIDA!");
                        break;
                }
                // Apresentar mensagem para o utilizador
                System.out.println("\n\n************************\nPretende voltar a ver as opções do MENU?");
                // Pedir input ao utilizador
                System.out.println("\n- [S] para SIM\n- [Outra tecla] para SAIR e encerrar o programa\n\nINSERIR: ");
                // Instanciar scanner com nome "inputClintinuarCliente" para ler a opção
                Scanner inputContinuarCliente = new Scanner(System.in);
                // Variável "continuarCliente" assume valor inserido
                continuarCliente = inputContinuarCliente.next();
            }
            // Enquanto "opcaoCliente" for diferente de zero (sair), e o utlizador inseir "s" ou "S" (ignore case), volta a correr o ciclo que mostra o menu
            while (opcaoCliente != 0 && continuarCliente.equalsIgnoreCase("S"));
            // Invocar função que imprime na consola uma mensagem
            sairCliente();
        }
        vitor();
    }
}