package main;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RomanNumbers {

    // Regex zur validierung einer römischen Zahl
    private final String ROMAN_REGEX = "^M*(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

    public Integer convertToInt(String roman) {
        if(StringUtils.isBlank(roman) || !validateInput(roman)){
            throw new RomanNumberException("Ungültige Eingabe.");
        }
        return convertR2A(roman);
    }

    public String convertToRoman(Integer value) {
        if(value == null){
            throw new RomanNumberException("Ungültige Eingabe.");
        }
        return convertA2R(value);
    }

    private Integer convertR2A(String roman) {
        int result = 0;
        String reverse = new StringBuilder(roman).reverse().toString();

        for(char ch : reverse.toCharArray()) {
            switch (ch) {
                case 'I' -> result = combineNumbersR2A(result, 1, 5);
                case 'V' -> result = combineNumbersR2A(result, 5, 10);
                case 'X' -> result = combineNumbersR2A(result, 10, 50);
                case 'L' -> result = combineNumbersR2A(result, 50, 100);
                case 'C' -> result = combineNumbersR2A(result, 100, 500);
                case 'D' -> result = combineNumbersR2A(result, 500, 1000);
                case 'M' -> result = combineNumbersR2A(result, 1000, -1);
            }
        }
        return result;
    }

    private String convertA2R(Integer value){
        StringBuilder result = new StringBuilder();
        LinkedList<Integer> digits = new LinkedList<Integer>();
        while (value > 0) {
            digits.push( value % 10 );
            value = value / 10;
        }
        for(int i = 0; i < digits.getFirst(); i++){
            result.append("M");
        }
        digits.removeFirst();
        //combineNumbersA2R(digits);
        return result.toString();
    }

    private int combineNumbersR2A(int result, int value, int max) {
        if(result >= max && max != -1){
            result -= value;
        } else {
            result += value;
        }
        return result;
    }

    private int combineNumbersA2R(LinkedList<Integer> digits){

        return 1;
    }

    private boolean validateInput(String roman) {
        return roman.matches(ROMAN_REGEX);
    }
}
