package school.cesar.nib.exemplo;

import school.cesar.nib.entities.Cliente;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {

    public static void main(String[] args) {
        try {


            Scanner leTeclado = new Scanner(System.in);
            int a = leTeclado.nextInt();
            System.out.println(10 / a);
            exemploExecaoChecada(2);
            System.out.println("finalizou o try");
        } catch (Cliente cliente) {

        } catch (InputMismatchException e) {
            System.out.println("digite novamente");
        } catch (NovaExcecaoChegada | MinhaExcecaoChegada e) {
            System.out.println("outra coisa deve ser executada");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Quase sempre isso vai ser impresso");
        }
    }

    public static void exemploExecaoNaoChecada() {
        throw new RuntimeException("nao checada");
    }

    public static void exemploExecaoChecada(int a)
            throws NovaExcecaoChegada, MinhaExcecaoChegada, FileNotFoundException {

        new FileInputStream("arquivo.text");

        switch (a) {
            case 1:
                throw new NovaExcecaoChegada();
            case 2:
                throw new MinhaExcecaoChegada();
        }
    }
}

class MinhaExcecaoChegada extends Exception {
}

class NovaExcecaoChegada extends Exception {
}
