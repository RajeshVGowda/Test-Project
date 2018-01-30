package com.nineleafs.LearningRX.java8;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class StringDemo {

    public static void main(String[] args) {
        System.out.println("Stream Demo using Stream interface...");

        Stream<Employee> employeeStream=Stream.of(new Employee(1,"Rajesh"),new Employee(2,"Bashistha")
        ,new Employee(3,"Rama"));

        Predicate<Employee> p1=(employee)->employee.getId()>1;

        Predicate<Employee> p2=(employee)->{return employee.getName().equals("Rama");};

        employeeStream.filter(p1.and(p2))
                .forEach(
                (s)-> System.out.println(s.getName())
        );

    }
}
