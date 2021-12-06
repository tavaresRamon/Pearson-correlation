package academy.ramon.JavaCore.Commit;

import java.util.ArrayList;
import java.util.List;

public class SomatorioPearsonPerformance {
    public static void main(String[] args) {
        System.out.println("----------------------Regressão Linear---------------------------");
        System.out.println("Sistema que calcula o coeficiente de correlação de Pearsson");
        System.out.println("Desenvolvedor do Projeto: [Ramon L. O. Tavares]");
        System.out.println("-------------------------------------------------------------------");
//Aqui podemos inserir QuaisQuer valores de X e Y, após adicionarmos esses valores o sistema irá nos informar qual o coeficiente de correlaçã entre as duas variáveis.
        List<Integer> varX = new ArrayList<>(List.of(1378, 1292, 1146, 854, 973, 996, 1241, 1208, 1045));
        List<Integer> varY = new ArrayList<>(List.of(154, 145, 110, 98, 105, 118, 143, 105, 112));
        //Tamanho da amostra = n :
        int n = varX.size();

        System.out.println("Amostra de tamanho [" + n + "]");
        System.out.println("Varíáveis do eixo X : " + varX + "");
        System.out.println("Variáveis do reixo Y: " + varY + "");
        System.out.println("-------------------------------------------------------------------------");

        //Como deve existir uma correlação entre X e Y para podermos saber a ligação entre as duas variáveis
        //apliquei um array para retornar em ordem( através do for) o produto entre as duas variáveis, pois esse produto faz parte da fórmula de Perasson.
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < varX.size(); i++) {
            integers.add(varX.get(i) * varY.get(i));
        }

        //Anteriormente estava retornando um Weapper (Integer) :

//        Optional<Integer> somatorioDeXY = integers.stream().reduce(Integer::sum);
//        Optional<Integer> somatorioDeX = varX.stream().reduce(Integer::sum);
//        Optional<Integer> somatoriodeY = varY.stream().reduce(Integer::sum);

        //Posteriormente apliquei uma alta performance que retorna um primitivo (double), melhorando assim,  o desempenho do código:

        double somatorioDeXY = integers.stream().mapToDouble(Integer::doubleValue).sum();
        System.out.println("Somatório de Xi*Yi: [" + somatorioDeXY + "]");
        double somatorioDeX = varX.stream().mapToDouble(Integer::doubleValue).sum();
        System.out.println("Somatório de Xi: [" + somatorioDeX + "]");
        double somatoriodeY = varY.stream().mapToDouble(Integer::doubleValue).sum();
        System.out.println("Somatório de Yi: [" + somatoriodeY + "]");

        //Retornando todos os valores da variável x elevado a dois.
        ArrayList<Double> xAoQuadrado = new ArrayList<>();
        for (Integer x : varX) {
            double pow = Math.pow(x, 2);
            xAoQuadrado.add(pow);
        }
        System.out.println("-------------------------------------------------------------------------");

        System.out.println("Todos os valores  de Xi²: " + xAoQuadrado);

//Retornando todos os valores da variável y elevado a dois.
        ArrayList<Double> yAoQuadrado = new ArrayList<>();
        for (Integer y : varY) {
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
