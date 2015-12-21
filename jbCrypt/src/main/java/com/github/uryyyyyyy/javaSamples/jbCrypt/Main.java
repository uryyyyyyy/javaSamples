package com.github.uryyyyyyy.javaSamples.jbCrypt;

import org.mindrot.jbcrypt.BCrypt;

public class Main {

    public static void main(String args[]){
        String password = "my_password";
        String candidate = "my_password";

        String hashed1 = BCrypt.hashpw(password, BCrypt.gensalt());

        String hashed2 = BCrypt.hashpw(password, BCrypt.gensalt(12));

        if (BCrypt.checkpw(candidate, hashed1))
            System.out.println("It matches");
        else
            System.out.println("It does not match");

        if (BCrypt.checkpw(candidate, hashed2))
            System.out.println("It matches");
        else
            System.out.println("It does not match");
    }
}
