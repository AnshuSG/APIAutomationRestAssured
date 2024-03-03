package com.thetestingacademy.testng.listenerDemo;

import org.testng.IExecutionListener;



public class CustomListener implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        //reports , read excel
        long startTime = System.currentTimeMillis();
        System.out.println("starttime" + startTime);
    }

    @Override
    public void onExecutionFinish() {
        //email to qa lead
        long endTime = System.currentTimeMillis();
        System.out.println("endtime" + endTime);
    }
}
