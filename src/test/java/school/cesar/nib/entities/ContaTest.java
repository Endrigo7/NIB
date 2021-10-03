package school.cesar.nib.entities;

import org.junit.Assert;
import org.junit.Test;

public class ContaTest {

    @Test
    public void deveIncrementarOSaldoEm20QuandoValorFor20(){
        Poupanca poupanca = new Poupanca();
        poupanca.creditar(20);
        Assert.assertEquals(120.0, poupanca.getSaldo(), 0);
    }

}
