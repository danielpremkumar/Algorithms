package com.company.gs;

public class StringRotation {
    public static void main(String[] args) {
        String test = "dani";
        int q = 4;
        int[] directions = new int[]{1, 0, 1, 1};
        int[] amount = new int[]{5, 2, 3, 0};
        int netamount = 0;
        for(int i=0; i<q; i++) {
            if (directions[i]==0) {
                netamount-=amount[i];
            } else {
                netamount+=amount[i];
            }
        }
        if (netamount > 0) {
            shiftRight(netamount, test);
        } else if (netamount< 0){
            shiftLeft(netamount, test);
        } else {
            System.out.println(test);
        }
    }

    private static void shiftLeft(int netamount, String test) {
        netamount *= -1;
        netamount %= test.length();
        System.out.println(test.substring(netamount,test.length() - netamount)+test.substring(0,netamount));

        //dani-> anid -> nida
    }

    private static void shiftRight(int netamount, String test) {
        netamount %= test.length();
        System.out.println(test.substring(test.length() - netamount,test.length())+test.substring(0,netamount));
        //dani-> idan -> nida -> anid
    }
}
