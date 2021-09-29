package school.cesar.nib.entities;


public class Poupanca extends Conta {

    public void renderJuros(){
        double saldoAtual = getSaldo();
        setSaldo( saldoAtual * 1.005  );
    }
}
