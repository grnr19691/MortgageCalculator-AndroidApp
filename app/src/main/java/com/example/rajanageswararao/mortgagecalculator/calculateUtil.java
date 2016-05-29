package com.example.rajanageswararao.mortgagecalculator;

/**
 * Created by RajaNageswaraRao on 4/13/2015.
 */
//import java.lang.Math;
public class calculateUtil
{

    public static double interestCalculator(double P, double J, double N, boolean extraInterest)
    {
        double T;
        if(extraInterest)
            T=P/1000;
        else
            T=0;
        if(J==0)
            return (P/N)+T;
        else
            return (P*J/(1-Math.pow((1+J),-N)))+T;
    }
}
