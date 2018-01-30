package com.nineleafs.LearningRX.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ForEachDemo {

    public static void main(String[] args) {

        List<Employee> employees= Arrays.asList(new Employee(1,"Rajesh"),
                new Employee(2,"Harish")
        ,new Employee(3,"Bashistha"));

        List<Employee> employees1=new ArrayList<>();
        Consumer<Employee> employeeConsumer=(employee)->{
            System.out.println(employee.getName());
        };

        Consumer<Employee> employeeConsumer1=employees1::add;
        Consumer<Employee> employeeConsumer2=(employee)->{
            System.out.println(employee.getId());
        };
        /*employees.forEach((employee -> {
            if(employee.getId()<3){
                System.out.println("Id : "+employee.getId()+" Name: "+employee.getName());
            }
        }));*/
        employees.forEach(employeeConsumer.andThen(employeeConsumer1).andThen(employeeConsumer2));
        employees1.forEach(employeeConsumer);
    }

}
