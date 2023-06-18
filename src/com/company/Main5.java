package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Emplo{

    private  String name;
    private  int age;

    public Emplo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name+" "+this.age;
    }
}


class  Depart{
    private  String name;
    private  List<Emplo> emplos;

    public Depart(String name) {
        this.name = name;
        this.emplos=new ArrayList<>();
    }

    public  void addEmlp(Emplo e){
        emplos.add(e);
    }

    public List<Emplo> getEmp(){
        return Collections.unmodifiableList(emplos);
    }

}

public class Main5 {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>(Arrays.asList("N44","N35","B12","B4","G53","G44","g50","G11","I11","I22","I1","O77"));
//        list.forEach(s->{
//            if(s.startsWith("G")){
//                System.out.println(s);
//            }
//        });

//        list.stream().filter(s->s.toUpperCase().startsWith("G")).sorted((s1,s2)->s1.compareTo(s2)).forEach(System.out::println);
 //       Stream<String> streama=list.stream().map((s)->s.toUpperCase()).filter(s->s.startsWith("G")).sorted((s1,s2)->s1.compareTo(s2));
 //       List<String> res=streama.toList();
//        res.forEach(System.out::println);


        Stream<String> stream=Stream.of("N44","N35","B12","B4","G53","G44","g50","G11","I11","I22","I1","O77");
        Stream<String> stream2=Stream.of("N44","N35","I11","I22","I1");
        Stream<String> stream3=Stream.concat(stream2,stream);
        System.out.println(stream3.distinct().peek(System.out::println).count());

        Emplo e1=new Emplo("dodos1",32);
        Emplo e2=new Emplo("Aodos1",12);
        Emplo e3=new Emplo("WWdos1",52);
        Emplo e4=new Emplo("Ldsados1",72);
        Emplo e5=new Emplo("KPOus1",22);
        Emplo e19=new Emplo("dodos1",32);
        Emplo e20=new Emplo("dodos1",32);

        Emplo e6=new Emplo("ffaos1",152);
        Emplo e7=new Emplo("goriydos1",36);
        Emplo e8=new Emplo("soula1",55);

        Depart depart=new Depart("depar1");
        Depart depart2=new Depart("depar2");

        depart.addEmlp(e1);
        depart.addEmlp(e2);
        depart.addEmlp(e3);
        depart.addEmlp(e4);
        depart.addEmlp(e5);

        depart2.addEmlp(e6);
        depart2.addEmlp(e7);
        depart2.addEmlp(e8);

        List<Depart> departs=new ArrayList<>();
        departs.add(depart2);
        departs.add(depart);


        departs.stream().flatMap(s->s.getEmp().stream()).forEach(s->System.out.println(s));
        System.out.println("------------------------------------------------------------------------------------------");
        List<String> sortednum=list.stream().map(s->s.toUpperCase()).filter(s->s.startsWith("G")).sorted((s1,s2)->s1.compareTo(s2))
                .collect(()->new ArrayList<>(),(s,x)->s.add(x),(s,x)->s.addAll(x));


        sortednum.forEach(System.out::println);

       Emplo em= departs.stream().flatMap(s->s.getEmp().stream()).reduce((z1,z2)->{
            if(z1.getAge()<z2.getAge()){
                return z1;
            }else {
                return z2;
            }
        }).get();
        System.out.println("younger "+em.getName()+" "+em.getAge());





    }
}
