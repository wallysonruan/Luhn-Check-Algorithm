import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class CreditCardSequenceValidatorTest {

    CreditCardSequenceValidator validator;

    private final String VALID_SEQUENCE_ONLY_NUMBERS = "4929580328355442";

    @BeforeEach
    void setUp() {
        validator = new CreditCardSequenceValidator();
    }
    @Test
    void construtorComParametro_quandoReceberOParametro__deveriaIniciarOsProcessosDeValidacao(){
        Map<Integer, Character> allDigitsMock = new HashMap<>();
        allDigitsMock.put(0, '4');
        allDigitsMock.put(1, '9');
        allDigitsMock.put(2, '2');
        allDigitsMock.put(3, '9');
        allDigitsMock.put(4, '5');
        allDigitsMock.put(5, '8');
        allDigitsMock.put(6, '0');
        allDigitsMock.put(7, '3');
        allDigitsMock.put(8, '2');
        allDigitsMock.put(9, '8');
        allDigitsMock.put(10, '3');
        allDigitsMock.put(11, '5');
        allDigitsMock.put(12, '5');
        allDigitsMock.put(13, '4');
        allDigitsMock.put(14, '4');
        allDigitsMock.put(15, '2');

        Map<Integer, Character> oddIndexesMock = new HashMap<>();
        oddIndexesMock.put(1, '9');
        oddIndexesMock.put(3, '9');
        oddIndexesMock.put(5, '8');
        oddIndexesMock.put(7, '3');
        oddIndexesMock.put(9, '8');
        oddIndexesMock.put(11, '5');
        oddIndexesMock.put(13, '4');
        oddIndexesMock.put(15, '2');

        Map<Integer, Character> evenDigitsMock = new HashMap<>();
        evenDigitsMock.put(0, '4');
        evenDigitsMock.put(2, '2');
        evenDigitsMock.put(4, '5');
        evenDigitsMock.put(6, '0');
        evenDigitsMock.put(8, '2');
        evenDigitsMock.put(10, '3');
        evenDigitsMock.put(12, '5');
        evenDigitsMock.put(14, '4');


        CreditCardSequenceValidator validatorComParametro = new CreditCardSequenceValidator(VALID_SEQUENCE_ONLY_NUMBERS);

        Assertions.assertEquals(VALID_SEQUENCE_ONLY_NUMBERS, validatorComParametro.getSequence());
        Assertions.assertEquals(allDigitsMock, validatorComParametro.getDigits());
        Assertions.assertTrue(validatorComParametro.isSequenceValid());
        Assertions.assertEquals(oddIndexesMock, validatorComParametro.getListOfAllInOddIndexes());
        Assertions.assertEquals(evenDigitsMock, validatorComParametro.getListOfAllInEvenIndexes());
    }
    @Test
    void setSequence_quandoReceberSequenciaComHifenEEspaco__deveriaRetornarSequenciaComNumerosApenas() {
        validator.setSequence("49-29-58 0328355442");
        Assertions.assertEquals(VALID_SEQUENCE_ONLY_NUMBERS, validator.getSequence());
    }
    @Test
    void getSequence() {
        validator.setSequence("49-29-58 0328355442");
        Assertions.assertEquals(VALID_SEQUENCE_ONLY_NUMBERS, validator.getSequence());
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
    @Test
    void isSequenceValid_quandoReceberSequenciaValida__deveriaRetornarTrue(){
        validator.setSequence("49-29-58 0328355442");
        Assertions.assertTrue(validator.isSequenceValid());
    }
    @Test
    void isSequenceValid_quandoReceberSequenciaInvalida__deveriaRetornarFalse(){
        validator.setSequence("49-29-580328355448");
        Assertions.assertFalse(validator.isSequenceValid());
    }
    @Test
    void getListOfAllInOddIndexes(){
        Map<Integer, Character> digitsMock = new HashMap<>();
        digitsMock.put(1, '9');
        digitsMock.put(3, '9');
        digitsMock.put(5, '8');
        digitsMock.put(7, '3');
        digitsMock.put(9, '8');
        digitsMock.put(11, '5');
        digitsMock.put(13, '4');
        digitsMock.put(15, '2');

        validator.setSequence("49-29-58 0328355442");
        Assertions.assertEquals(digitsMock, validator.getListOfAllInOddIndexes());
    }
    @Test
    void getListOfAllInEvenIndexes(){
        Map<Integer, Character> digitsMock = new HashMap<>();
        digitsMock.put(0, '4');
        digitsMock.put(2, '2');
        digitsMock.put(4, '5');
        digitsMock.put(6, '0');
        digitsMock.put(8, '2');
        digitsMock.put(10, '3');
        digitsMock.put(12, '5');
        digitsMock.put(14, '4');

        validator.setSequence("49-29-58 0328355442");
        Assertions.assertEquals(digitsMock, validator.getListOfAllInEvenIndexes());
    }
}