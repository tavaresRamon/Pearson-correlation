package GitHub;

import java.util.ArrayList;
import java.util.List;

public class ProjetoDePeason {
    public static void main(String[] args) {
        System.out.println("----------------------Regressão Linear---------------------------");
        System.out.println("Sistema que calcula o coeficiente de correlação através da fórmula de Pearson\nLembrando que para uma correlação mais eficiente devemos usar variáveis contínuas ou discretas");
        System.out.println("Desenvolvedor do Projeto: [Ramon L. O. Tavares]");
        System.out.println("-------------------------------------------------------------------");
//Inserir variáveis contínuas ou discretas para uma análise mais precisa com a correlação de Pearson
        List<Double> varX = new ArrayList<>(List.of(1378.0, 1292.0, 1146.0, 854.0, 973.0, 996.0, 1241.0, 1208.0, 1045.0));
        List<Double> varY = new ArrayList<>(List.of(154.0, 145.0, 110.0, 98.0, 105.0, 118.0, 143.0, 105.0, 112.0));
        //Tamanho da amostra = n :
        int n = varX.size();

        System.out.println("Amostra de tamanho [" + n + "]");
        System.out.println("Varíáveis do eixo X : " + varX + "");
        System.out.println("Variáveis do reixo Y: " + varY + "");
        System.out.println("-------------------------------------------------------------------------");

        //Como deve existir uma correlação entre X e Y para podermos saber a ligação entre as duas variáveis
        //apliquei um array para retornar em ordem( através do for) o produto entre as duas variáveis, pois esse produto faz parte da fórmula de Perasson.
        ArrayList<Double> doubles = new ArrayList<>();
        for (int i = 0; i < varX.size(); i++) {
            doubles.add(varX.get(i) * varY.get(i));
        }

        //Anteriormente estava retornando um Weapper (Integer) :

//        Optional<Integer> somatorioDeXY = integers.stream().reduce(Integer::sum);
//        Optional<Integer> somatorioDeX = varX.stream().reduce(Integer::sum);
//        Optional<Integer> somatoriodeY = varY.stream().reduce(Integer::sum);

        //Posteriormente apliquei o "mapToDoble" que retorna um primitivo (double), melhorando assim,  o desempenho do código:

        double somatorioDeXY = doubles.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Somatório de Xi*Yi: [" + somatorioDeXY + "]");
        double somatorioDeX = varX.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Somatório de Xi: [" + somatorioDeX + "]");
        double somatoriodeY = varY.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Somatório de Yi: [" + somatoriodeY + "]");

        //Retornando todos os valores da variável x elevado a dois.
        ArrayList<Double> xAoQuadrado = new ArrayList<>();
        for (Double x : varX) {
            double pow = Math.pow(x, 2);
            xAoQuadrado.add(pow);
        }
        System.out.println("-------------------------------------------------------------------------");

        System.out.println("Todos os valores  de Xi²: " + xAoQuadrado);

//Retornando todos os valores da variável y elevado a dois.
        ArrayList<Double> yAoQuadrado = new ArrayList<>();
        for (Double y : varY) {
            double pow = Math.pow(y, 2);
            yAoQuadrado.add(pow);
        }
        System.out.println("Todos os valores de Yi²: " + yAoQuadrado);

        //Optional<Double> somatorioDeXaoQuadrado = xAoQuadrado.stream().reduce(Double::sum);
        // Optional<Double> somatorioDeYAoQuadrado = yAoQuadrado.stream().reduce(Double::sum);

        //Aplicando alta performance retornando um primitivo(double)

        double somatorioDeXaoQuadrado = xAoQuadrado.stream().mapToDouble(Double::doubleValue).sum();
        double somatorioDeYAoQuadrado = yAoQuadrado.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("Resultado do somatódio de Xi²: [%.2f]%n%n", somatorioDeXaoQuadrado);
        System.out.printf("Resultado do somatório de Yi²: [%.2f]%n%n", somatorioDeYAoQuadrado);
        System.out.println("-------------------------------------------------------------------------");

        //nomeei as variáveis locais de forma bem didática

        double nMultiplicaPrimeiraExpressaoNumerador = n * somatorioDeXY;
        double multiplicacaoDaSegundaExpressaoDoNumerador = somatorioDeX * somatoriodeY;
        double numeradorCompleto = nMultiplicaPrimeiraExpressaoNumerador - multiplicacaoDaSegundaExpressaoDoNumerador;

        double nMultiplicaSomatXAoQuadrado = n * somatorioDeXaoQuadrado;
        double nMultiplicaSomatYAoQuadrado = n * somatorioDeYAoQuadrado;

        double xSomadoElevadoA2 = Math.pow(somatorioDeX, 2);
        System.out.printf("(Somatório de Xi)² é :[%.2f]%n%n ", xSomadoElevadoA2);
        double ySomadoElevadoA2 = Math.pow(somatoriodeY, 2);
        System.out.printf("(Somatório de Yi)² é: [%.2f]%n%n", ySomadoElevadoA2);


        double primeiraEquacaoDeXNoDemonimador = nMultiplicaSomatXAoQuadrado - xSomadoElevadoA2;
        double segundaEquacaoDeXNoDenominador = nMultiplicaSomatYAoQuadrado - ySomadoElevadoA2;

        double raizQuadradaDaPrimeiraFuncaoDeXDenominador = Math.sqrt(primeiraEquacaoDeXNoDemonimador);
        double raizQuadradaDaSegundaFuncaoDeYDenominador = Math.sqrt(segundaEquacaoDeXNoDenominador);

        double denominadorCompleto = raizQuadradaDaPrimeiraFuncaoDeXDenominador * raizQuadradaDaSegundaFuncaoDeYDenominador;

        double resultado = numeradorCompleto / denominadorCompleto;

        System.out.println("-------------------------------------------------------------------");
        System.out.println("O coeficiente de correlação entre as variáveis (x) e (y) é igual a: ");
        System.out.printf("\n              Coeficiente de Correlação = [%.2f]%n", resultado);
    }
}

