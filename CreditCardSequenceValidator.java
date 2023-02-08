import java.util.HashMap;
import java.util.Map;

public class CreditCardSequenceValidator {
    private String sequence;
    private Map<Integer, Character> digits;
    private Integer sumOfAllInOddIndexes = 0;
    private Integer sumOfAllInEvenIndexes = 0;

    public void setSequence(String sequence){
        this.sequence = cleanString(sequence);
        setDigits();
    }
    public String getSequence(){
        return this.sequence;
    }
    private void setDigits(){
        this.digits = separateDigits(this.sequence);
    }
    public Map<Integer, Character> getDigits(){
        return this.digits;
    }
    private String cleanString(String sequence){
        return sequence.replace("-", "").replace(" ", "");
    }
    private Map<Integer, Character> separateDigits(String sequence){
        Map<Integer, Character> separatedDigits = new HashMap<>();

        for(int i = 0; i < sequence.length(); i++){
            separatedDigits.put(i, sequence.charAt(i));
        }

        return separatedDigits;
    }
}