package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main2 {

    public static void main(String[] args) {

        Supplier<Integer> supplier=()->{int i=10;
                                        i= (int) (i+Math.random());
                                        return i;};


        Consumer<String> consumer=(s)->{String[] a=s.split(" ");
        for(String x:a){
            System.out.println(x);
        }} ;

        Consumer<String> consumer2=(s)->{
            Arrays.asList(s.split(" ")).forEach(x-> System.out.println(x+" apo deuter"));
           } ;

        Predicate<Integer> predicate=(pos)->pos%2==1;

        Function<String,String> function=(x)->{
            StringBuilder res=new StringBuilder();
            for(int i=0;i<x.length();i++){
                if(i%2==1){
                    res.append(x.charAt(i));
                }
            }
            return res.toString();
        };

        System.out.println(everySecond("1234567890",function));



        List<String> list=new ArrayList<>(Arrays.asList("Bob","DoDos","JaVS","pYThon"));

        UnaryOperator<String> operator=(s)->s.toUpperCase();
        UnaryOperator<String> operator1=(s)->{StringBuilder stringBuilder=new StringBuilder();
                                              for(int i=s.length()-1;i>=0;i--){
                                                  stringBuilder.append(s.charAt(i));
                                              }
                                              stringBuilder.append(" ");
                                              stringBuilder.append(s);
                                              return  stringBuilder.toString();
        };


        list.forEach(System.out::println);
        list.replaceAll(operator1);
        list.forEach(s-> System.out.println(s));
        list.replaceAll(operator);
        list.forEach(s-> System.out.println(s));




    }


    public  static String everySecond(String str,Function<String,String> function){

        return  function.apply(str);

    };
}
