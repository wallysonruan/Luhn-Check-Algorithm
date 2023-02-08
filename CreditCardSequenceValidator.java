import java.util.HashMap;
import java.util.Map;

public class CreditCardSequenceValidator {
    private String sequence;
    private Map<Integer, Character> digits;
    private Integer sumOfAllInOddIndexes = 0;
    private Integer sumOfAllInEvenIndexes = 0;
    private Map<Integer, Character> listOfAllInOddIndexes = new HashMap<>();
    private Map<Integer, Character> listOfAllInEvenIndexes = new HashMap<>();

    public CreditCardSequenceValidator() {
    }

    public CreditCardSequenceValidator(String sequence) {
        setSequence(sequence);
    }

    public void setSequence(String sequence){
        this.sequence = cleanString(sequence);
        setDigits(this.sequence);
    }
    public String getSequence(){
        return this.sequence;
    }
    private void setDigits(String sequence){
        this.digits = separateDigits(sequence);
    }
    public Map<Integer, Character> getDigits(){
        return this.digits;
    }
    private void addToListOfOddIndexes(Integer index, Character digit){
        this.listOfAllInOddIndexes.put(index, digit);
    }
    public Map<Integer, Character> getListOfAllInOddIndexes(){
        return this.listOfAllInOddIndexes;
    }
    private void addToListOfEvenIndexes(Integer index, Character digit){
        this.listOfAllInEvenIndexes.put(index, digit);
    }
    public Map<Integer, Character> getListOfAllInEvenIndexes(){
        return this.listOfAllInEvenIndexes;
    }
    private String cleanString(String sequence){
        return sequence.replace("-", "").replace(" ", "");
    }
    private Map<Integer, Character> separateDigits(String sequence){
        Map<Integer, Character> separatedDigits = new HashMap<>();

        for(int i = 0; i < sequence.length(); i++){
            separatedDigits.put(i, sequence.charAt(i));
            distributeDigitsBasedOnTheirParity(i, sequence.charAt(i));
        }

        return separatedDigits;
    }
    private void distributeDigitsBasedOnTheirParity(Integer index, Character digit){
        if (index % 2 == 0){
            addToListOfEvenIndexes(index, digit);
            calculationsForDigitsInEvenIndex(digit);
        }else {
            addToListOfOddIndexes(index, digit);
            calculationsForDigitsInOddIndex(digit);
        }
    }
    private void calculationsForDigitsInEvenIndex(Character digit){
        Integer digitAsInteger = charToInteger(digit);
        Integer digitTimesTwo = digitAsInteger * 2;

        if (digitTimesTwo > 9){
            var digitAsString = integerToString(digitTimesTwo);
            var firstDigit = digitAsString.charAt(0);
            var secondDigt = digitAsString.charAt(1);
            var sumOfBoth = charToInteger(firstDigit) + charToInteger(secondDigt);
            this.sumOfAllInEvenIndexes += sumOfBoth;

        }else {
            this.sumOfAllInEvenIndexes += digitTimesTwo;
        }
    }
    private void calculationsForDigitsInOddIndex(Character digit){
        this.sumOfAllInOddIndexes += charToInteger(digit);
    }
    public boolean isSequenceValid(){
        if ( (sumOfAllInEvenIndexes + sumOfAllInOddIndexes) % 10 == 0){
            return true;
        }else {
            return false;
        }
    }
    private Integer charToInteger(Character digit){
        return Integer.parseInt(String.valueOf(digit));
    }
    private String integerToString(Integer integer){
        return String.valueOf(integer);
    }
}