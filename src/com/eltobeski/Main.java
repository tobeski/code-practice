package com.eltobeski;

import com.eltobeski.LeetCode.MyCircularQueue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
	// write your code here
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
Date date = simpleDateFormat.parse("5/15/2020 12:00:00 AM");
date.toString();


    }
}
