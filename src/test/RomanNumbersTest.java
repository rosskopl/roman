package test;

import main.RomanNumberException;
import main.RomanNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


public class RomanNumbersTest {

    @Test
    public void test(){
        Assertions.assertEquals(7, 3+3);
    }

    // Tests von römisch in arabisch
    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "XXE", "1", "IIII", "IXX", "IM", " "})
    @NullAndEmptySource
    public void wrongInputsR2A(String value){
        RomanNumbers rn = new RomanNumbers();
        Assertions.assertThrows(RomanNumberException.class, () -> rn.convertToInt(value));
    }
    @ParameterizedTest
    @ValueSource(strings = {"I", "V", "X", "L", "C", "D", "M", "XL"})
    public void rightInputsR2A(String value){
        RomanNumbers rn = new RomanNumbers();
        Assertions.assertDoesNotThrow(() -> rn.convertToInt(value));
    }
    @ParameterizedTest
    @CsvSource({"I,1", "V,5", "X,10", "L,50", "C,100", "D,500", "M,1000", "II,2", "IV,4", "VI,6", "VII,7", "IX,9", "XIV,14", "XVI,16", "XIX,19", "MMXXI,2021"})
    public void correctOutputR2A(String value, int expected){
        RomanNumbers rn = new RomanNumbers();
        Assertions.assertEquals(rn.convertToInt(value), expected);
    }

    // Tests von arabisch in römisch
    @Test
    public void wrongInputsR2A(){
        RomanNumbers rn = new RomanNumbers();
        Assertions.assertThrows(RomanNumberException.class, () -> rn.convertToRoman(null));
    }

    @ParameterizedTest
    @CsvSource({"1,I", "5,V", "10,X", "50,L", "100,C", "500,D", "1000,M"})
    public void correctOutputA2R(int value, String expected){
        RomanNumbers rn = new RomanNumbers();
        Assertions.assertEquals(rn.convertToRoman(value), expected);
    }

}
