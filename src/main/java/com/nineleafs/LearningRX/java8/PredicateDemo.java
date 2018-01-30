package com.nineleafs.LearningRX.java8;

import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        System.out.println("Predicate Demo");

        Predicate<Employee> employeePredicate=(employee)->
                employee.getName().equals("Rajesh");

        Predicate<Employee> employeePredicate1 = employeePredicate.and((employee) ->
                employee.getName().equals("Rajesh V"));

        employeePredicate.test(new Employee(1,"Rajesh"));
        System.out.println();
        System.out.println(employeePredicate1.test(new Employee(1,"Rajesh V")));


    }
}
