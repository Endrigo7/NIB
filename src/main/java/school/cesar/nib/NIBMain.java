package school.cesar.nib;

import school.cesar.nib.guis.ClienteGui;
import school.cesar.nib.guis.ContaGui;

import java.util.Scanner;

public class NIBMain {

    public static void main(String[] args) {
        Scanner leTeclado = new Scanner(System.in);

        ClienteGui clienteGui = new ClienteGui();
        clienteGui.exibeMenu(leTeclado);

        ContaGui contaGui = new ContaGui();
        contaGui.exibeMenu(leTeclado);

        System.out.println("Obrigado por usar o NIB");
        leTeclado.close();
    }
}
