package org.example.gq.test;

import javax.security.auth.login.CredentialNotFoundException;

public class Test {
    static int i = 0;
    public static void main(String[] args) {
        /*System.out.println(trySomething());*/
        testStakDepth();
    }
    public static int trySomething(){
        int i = 1;
        try {
            i++;
            return i;
        }finally {
            i++;
            return i;
        }
    }
    public static void testStakDepth()
    {
        i++;
        System.out.println(i);
        testStakDepth();
    }
}
