package org.example;

import java.util.HashMap;
import java.util.Map;


class RomanNumerals {

    public static String toRoman(int n) {
        if (n < 1 || n > 3999) {
            throw new IllegalArgumentException("Input number must be in the range 1 to 3999.");
        }

        Map<Integer, String> importedCatalogue = valueSymbolMapper(); //"import" the catalogue of roman numbers

        StringBuilder roman = new StringBuilder();

        //descending definition of keys
        int[] keys = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        //looking for a key and get value (symbol)
        for (int key : keys) {
            while (n >= key) {
                roman.append(importedCatalogue.get(key));
                n -= key;
            }
        }
        return roman.toString();
    }

    public static int fromRoman(String romanNumeral) {

        Map<String, Integer> importedCatalogue = symbolValueMapper(); //"import" the catalogue of roman numbers

        int result = 0;
        int i = 0;

        while (i < romanNumeral.length()) {
            // Check for two-character substrings first (e.g., "IV", "IX")
            if (i + 1 < romanNumeral.length() && importedCatalogue.containsKey(romanNumeral.substring(i, i + 2))) {
                result += importedCatalogue.get(romanNumeral.substring(i, i + 2));
                i += 2;
            } else {
                result += importedCatalogue.get(Character.toString(romanNumeral.charAt(i)));
                i += 1;
            }
        }

        return result;
    }

    //catalogues
    public static Map<String, Integer> symbolValueMapper() { //set the values for transfer Roman Numerals
        Map catalogue = new HashMap<>();
        catalogue.put("M", 1000);
        catalogue.put("CM", 900);
        catalogue.put("D", 500);
        catalogue.put("CD", 400);
        catalogue.put("C", 100);
        catalogue.put("XC", 90);
        catalogue.put("L", 50);
        catalogue.put("XL", 40);
        catalogue.put("X", 10);
        catalogue.put("IX", 9);
        catalogue.put("V", 5);
        catalogue.put("IV", 4);
        catalogue.put("I", 1);

        return catalogue;
    }

    public static Map<Integer, String> valueSymbolMapper() { //set the values for transfer Roman Numerals
        Map catalogue = new HashMap<>();
        catalogue.put(1000, "M");
        catalogue.put(900, "CM");
        catalogue.put(500, "D");
        catalogue.put(400, "CD");
        catalogue.put(100, "C");
        catalogue.put(90, "XC");
        catalogue.put(50, "L");
        catalogue.put(40, "XL");
        catalogue.put(10, "X");
        catalogue.put(9, "IX");
        catalogue.put(5, "V");
        catalogue.put(4, "IV");
        catalogue.put(1, "I");

        return catalogue;
    }

}


/*
TESTING

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RomanNumeralsTest {

    @Test
    public void testToRoman() throws Exception {
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(1), is("I"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(2), is("II"));
    }

    @Test
    public void testFromRoman() throws Exception {
        assertThat("'I' converts to 1", RomanNumerals.fromRoman("I"), is(1));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("II"), is(2));
    }
}
 */