package com.company;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

class Pold{
    private  static  int last_id=1;

    private  int id;

    public Pold() {
        this.id = last_id++;
        System.out.println("object creted with id "+id);
    }
}

public class Main3 {

    public static void main(String[] args) {

        System.out.println(calculate(Integer::sum,2,4));
        Supplier<Pold> supplier= Pold::new;

        System.out.println(seedArray(supplier,10));
        System.out.println("gamithike i fasi");

        System.out.println(calculate((s1,s2)->s1.concat(s2),"harro","pri"));
        System.out.println(calculate(String::concat,"harro","pri"));


    }


    public static <T>T calculate(BinaryOperator<T> binaryOperator,T val1,T val2){
        T result=binaryOperator.apply(val1,val2);
        return  result;
    }

    public  static Pold[] seedArray(Supplier<Pold> supplier,int i){
        Pold[] array=new Pold[i];
        Arrays.setAll(array,p->supplier.get());
        return  array;
    }
}
