package com.thetestingacademy.testng;

import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG007 {


    @Test(groups = {"sanity","qa"})
    public void sanityRun(){
        System.out.println("sanity");
        System.out.println("QA");
    }

    @Test(groups = {"sanity","reg","prepod","e2e"})
    public void RegRun(){
        System.out.println("Reg");
    }


    @Test(groups = {"sanity","smoke","dev"})
    public void SmokeRun(){
        System.out.println("smoke");
        Assert.assertTrue(false);
    }

}
