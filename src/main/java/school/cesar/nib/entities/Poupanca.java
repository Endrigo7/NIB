package school.cesar.nib.entities;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Poupanca extends Conta {

    private static final double TAXA_JUROS = 0.05;

    public void atualizarSaldoComRendimentos(double taxa){
        double saldoAtual = getSaldo();
        setSaldo( saldoAtual * taxa  );
    }

    @Override
    public void renderJuros() {
        double saldoAtual = getSaldo();
        setSaldo( saldoAtual *  TAXA_JUROS );
    }
}
