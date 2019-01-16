package com.wizard;

public class CharacterCreation {

    public boolean validateName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            System.out.println("First name is not suitable. You did not enter any name.");
            return false;
        }
        if (firstName.contains(" ")) {
            System.out.println("First name should not contain any space");
            return false;
        }
        String filteredName = eraseNonLetters(firstName);
        if (!firstName.equalsIgnoreCase(filteredName)) {
            System.out.println("First name is not suitable. No numbers/Punctuations");
            return false;
        }
        return true;
    }

    public boolean validateSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            System.out.println("First name is not suitable. You did not enter any name.");
            return false;
        }
        String filteredName = eraseNonLetters(surname);
        if (!surname.equalsIgnoreCase(filteredName)) {
            System.out.println("First name is not suitable. No numbers/Punctuations");
            return false;
        }
        return true;
    }

    private String eraseNonLetters(String word) {
        String result = word.replaceAll("\\d", "");
        result = result.replaceAll("\\p{Punct}", "");
        return result;
    }
}
