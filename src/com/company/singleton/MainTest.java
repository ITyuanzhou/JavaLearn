package com.company.singleton;

public class MainTest {

    public static void main(String[] args) {
	     DoubleCheckLock instance = DoubleCheckLock.GetInstance();
	     System.out.print("123");
    }
}

