package ru.avalon.javapp.devj120;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PhoneNumber pn = new PhoneNumber("981", "0234567"),
                pn1 = new PhoneNumber("981", "0234567"),
                pn2 = new PhoneNumber("7890", "567889");
        /*System.out.println(pn);
        System.out.println(pn2);
         */
        Set<PhoneNumber> phNums = new HashSet<>();
        phNums.add(pn);
        phNums.add(pn2);
        for (PhoneNumber phoneNumber : phNums) {
            System.out.println(phoneNumber);
        }
    }
}
