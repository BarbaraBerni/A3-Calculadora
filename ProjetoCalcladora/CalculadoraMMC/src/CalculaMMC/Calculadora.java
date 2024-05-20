package CalculaMMC;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
public class Calculadora {
    public static void main(String[] args) {
    	double valorUm;
    	double valorDois;
    	String operacao;
    	boolean continuar;
    	    Scanner sc = new Scanner(System.in);
    	    
    	    try {
    			do {
    	            System.out.println("Digite um valor: ");
    	            valorUm = sc.nextDouble();
    	            System.out.println("Digite o valor dois: ");
    	            valorDois = sc.nextDouble();
    	            System.out.println("Digite a operação (+, -, /, *, mmc): ");
    	            operacao = sc.next();

    			            
    	            Double resultado = realizarCalculo(valorUm, valorDois, operacao);
    	            if (resultado != null) {
    	                System.out.println("Resultado: " + resultado);
    	            } /*PRINT DO RESULTADO*/
    	            
    	        
    	    continuar = verificarNovaOperacao();
			} while (continuar);
    	    } catch (InputMismatchException ex) {
	System.out.println("Digite valores numéricos válidos");
	sc.close();
    	}	/*TRATATIVA PARA QUANDO O USUARIO DIGITA UM CARACTER INVALIDO PQ SÓ ACEITA NUMEROS*/
    	    
    }

    public static boolean verificarNovaOperacao() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Continuar calculando outros itens ? (S ou N): ");
        boolean continuar = !sc.nextLine().toUpperCase(Locale.ROOT).equals("N");
        return continuar;
    } /*AQUI É UM LOOP PARA QUANDO O USUARIO OPTAR POR TRUE = CONTINUAR CALCULANDO FALSE = NÃO*/

    /*AQUI SÃO OS CALCULOS SIMPLES COMUNS*/
    public static Double realizarCalculo(Double valorUm, Double valorDois, String operacao) {
        Double respostaCalculo = null; 

        switch (operacao) {
            case "+":
                respostaCalculo = valorUm + valorDois;
                break;
            case "-":
                respostaCalculo = valorUm - valorDois;
                break;
            case "*":
                respostaCalculo = valorUm * valorDois;
                break;
            case "/":
                if (valorDois == 0) {
                    System.out.println("Divisão por zero não é permitida.");
                    return null;
                } else {
                    return valorUm / valorDois;
                }
            case "mmc":
                respostaCalculo = (double) calcularMMC(valorUm.intValue(), valorDois.intValue());
                break;
            default:
                System.out.println("Operação inválida!");
        }
        return respostaCalculo;
    }

 // Método para calcular o MDC usando o algoritmo de Euclides
    public static int calcularMDC(int a, int b) {
        while (b != 0) {
            int resto = a % b;
            a = b;
            b = resto;
        }
        return a;
    }

    // Método para calcular o MMC
    public static int calcularMMC(int a, int b) {
        int mdc = calcularMDC(a, b);
        return (a * b) / mdc;
    }

    public static Double solicitarValor(Scanner sc, String mensagem) {
        System.out.println(mensagem);
        return sc.nextDouble();
    }

    public static String solicitarOperacao(Scanner sc, String mensagem) {
        System.out.println(mensagem);
        return sc.next();
    }

    public static boolean verificarNovaOperacao(Scanner sc) {
        System.out.println("Continuar calculando outros itens? (S ou N): ");
        return !sc.next().toUpperCase(Locale.ROOT).equals("N");
    }

		
	}


