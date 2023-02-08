import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class CreditCardSequenceValidatorTest {

    CreditCardSequenceValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CreditCardSequenceValidator();
    }

    @Test
    void setSequence_quandoReceberSequenciaComHifenEEspaco__deveriaRetornarSequenciaComNumerosApenas() {
        validator.setSequence("49-29-58 0328355442");
        Assertions.assertEquals("4929580328355442", validator.getSequence());
    }

    @Test
    void getSequence() {
        validator.setSequence("49-29-58 0328355442");
        Assertions.assertEquals("4929580328355442", validator.getSequence());
    }

    @Test
    void getDigits() {
        Map<Integer, Character> digitsMock = new HashMap<>();
        digitsMock.put(0, '4');
        digitsMock.put(1, '9');
        digitsMock.put(2, '2');
        digitsMock.put(3, '9');
        digitsMock.put(4, '5');
        digitsMock.put(5, '8');
        digitsMock.put(6, '0');
        digitsMock.put(7, '3');
        digitsMock.put(8, '2');
        digitsMock.put(9, '8');
        digitsMock.put(10, '3');
        digitsMock.put(11, '5');
        digitsMock.put(12, '5');
        digitsMock.put(13, '4');
        digitsMock.put(14, '4');
        digitsMock.put(15, '2');

        validator.setSequence("49-29-58 0328355442");
        Assertions.assertEquals(digitsMock, validator.getDigits());
    }
}