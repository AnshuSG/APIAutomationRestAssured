package com.thetestingacademy.bpdemo;

public class NodesignPattern {
    public void step1()
    {
        System.out.println("step1");
    }
    public void step2()
    {
        System.out.println("step2");
    }
    public void step3()
    {
        System.out.println("step3");
    }

    public static void main(String[] args) {
        NodesignPattern np = new NodesignPattern();
        np.step1();
        np.step2();
        np.step3();
    }
}
