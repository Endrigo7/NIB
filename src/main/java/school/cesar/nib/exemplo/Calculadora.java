package school.cesar.nib.exemplo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {

    private static final int FATOR_NULO_MUTIPLICACAO = 1;

    public static int mutiplicar(int a, int b, int c){
        return a * b * c;
    }

    @Deprecated
    public static int mutiplicar(int a, int b){
        return mutiplicar(a, b, FATOR_NULO_MUTIPLICACAO);
    }
}

class Teste2{

    public static void main(String[] args) {
        System.out.println("Digite 1 numeros inteiros");
        int a = leNumero();

        System.out.println("Digite outro numeros inteiros");
        int b = leNumero();

        System.out.println(Calculadora.mutiplicar(a, b));
    }

    public static int leNumero(){
        Scanner leTeclado = new Scanner(System.in);
        boolean numeroNaoLido = true;
        int numero = 0;

        while (numeroNaoLido){

            try{
                numero = leTeclado.nextInt();
                numeroNaoLido = false;
            }catch (NumberFormatException e){
                System.out.println("erro durante leitura do numero. Por favor, tente de novo");
                leTeclado.next();
            }
        }
        return numero;
    }
}
