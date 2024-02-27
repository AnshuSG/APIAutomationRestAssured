package com.thetestingacademy.bpdemo;

public class BuilderDesignPattern {
public BuilderDesignPattern stag1()
{
    System.out.println("stag1");
    return this ;
}
    public BuilderDesignPattern stag2(String str)
    {
        System.out.println("stag 2 string is " + str);
        return this ;
    }
    public BuilderDesignPattern stag3()
    {
        System.out.println("stag3");
        return this ;
    }

    public static void main(String[] args) {
        BuilderDesignPattern bp= new BuilderDesignPattern();
        bp.stag1().stag2("text").stag3();
    }


}
