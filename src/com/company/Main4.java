package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Main4 {


    public static void main(String[] args) {
        record  Person(String name,String name2){};

        String name="dodos";
        Function<String,String> function1=String::toUpperCase;
        Function<String,String> function2=(s)->s.concat(" minas");
        Function<String,String> function3=function2.andThen(function1);
        Function<String,String> function4=function2.compose(function1);

        List<Person> list=new ArrayList<>(Arrays.asList(new Person("dodos11","minas11"),new Person("dodos1","minas1"),
                new Person("dodos222","minas2222"),new Person("dodos3","minas4"),new Person("dodos53","minas53")));

        list.forEach(System.out::println);
        list.sort((o1,o2)->o1.name.compareTo(o2.name));
        System.out.println();
        list.forEach(System.out::println);
        list.sort(Comparator.comparing(Person::name2).thenComparing(Person::name).reversed());
        System.out.println();
        list.forEach(System.out::println);


        System.out.println(function4.apply(name));
    }
}
