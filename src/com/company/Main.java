package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Main {
    record Person (String name,String lastname ){



        @Override
        public String toString() {
            return name+" "+lastname;
        }
    };

    public static void main(String[] args) {

        List<Person> list=new ArrayList<>(Arrays.asList(new Person("d2","w2"),new Person("d6","w6"),
                new Person("d5","w5"),new Person("d1","w1")));
        // write your code here
        System.out.println(list);

        list.sort((o1, o2) -> o1.lastname.compareTo(o2.lastname));

        System.out.println(list);

        list.forEach((s)->{
                        String e="dd";
                        e=e+"balls";
                        System.out.println(s+e);
                                                } );

        Predicate<Person> personPredicate=(o1)->o1.name.startsWith("d");
        List<String> malakies=new ArrayList<>(Arrays.asList("skata","aposkata","autoktona"));
        UnaryOperator<String> unaryOperator=(p)->{String x=p.charAt(0)+"poutses "+p;
                                                    return  x;};
        malakies.forEach(s-> System.out.println(s));
        malakies.replaceAll(unaryOperator);
        malakies.forEach(s-> System.out.println(s));

//        list.removeIf(personPredicate);
//        System.out.println(list);
//
//        int res=yolo((a,b)->a+b,1,2);
//
//        List<double[]> list1=new ArrayList<>(Arrays.asList(
//                new double[]{13.1,22,4},
//                new double[]{13.2,22,5},
//                new double[]{13.3,22,6}
//        ));
//
//        BiConsumer<Double,Double> biConsumer=(a,b)->{
//            System.out.printf("[first : %.2f second :%.4f]\n",a,b);
//        };
//
//
////        pPoint(13.55,22.4442,biConsumer);
//
//        list1.forEach(s->pPoint(s[0],s[1],biConsumer));

    }

    public static <T>T yolo(BinaryOperator<T> fun, T val1, T val2){
        T res=fun.apply(val1,val2);
        System.out.println("res is "+res);
        return res;
    }

    public  static  <T> void pPoint(T t1, T t2 , BiConsumer<T,T> consumer){
        consumer.accept(t1,t2);
    }
}
