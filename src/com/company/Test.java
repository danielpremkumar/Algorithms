package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) throws ParseException {
        String sDate1="cat123|10-19-1998";
        List.of(sDate1.split("\\|")).forEach(System.out::println);
    }

}
