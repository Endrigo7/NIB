package school.cesar.nib.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends RuntimeException {

    private String cpf;
    private String nome;
}
