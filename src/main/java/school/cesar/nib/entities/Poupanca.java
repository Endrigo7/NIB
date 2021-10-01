package school.cesar.nib.entities;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Poupanca extends Conta {

    public void atualizarSaldoComRendimentos(double taxa){
        double saldoAtual = getSaldo();
        setSaldo( saldoAtual * taxa  );
    }
}
