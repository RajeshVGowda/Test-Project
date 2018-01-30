package com.nineleafs.LearningRX.java8;

import java.util.function.Function;

public class FunctionDemo {


    public static void main(String[] args) {
        System.out.println("Function Demo using Lamda Expressions");

        Function<Employee,String> function=(name)->{
            if(name.getName().equalsIgnoreCase("Rajesh V")){
                return name.getName();
            }
            return "Rajesh v is not present";
        };

        System.out.println(function.apply(new Employee(1,"Rajesh")));
    }
}

