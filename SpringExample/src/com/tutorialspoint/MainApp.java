package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
	   
     //	   ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");// sacamos el contexto de Beans
	   AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	   
      //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Scope singleton>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
      HelloWorld objA = (HelloWorld) context.getBean("helloWorld");// cogemos el Bean helloWorld
      
      System.out.println("Scope singleton");
      objA.setMessage("I'm object A");// anadimos un texto
      objA.getMessage();// mostramos el texto

      HelloWorld objB = (HelloWorld) context.getBean("helloWorld");// cogemos el Bean helloWorld
      objB.getMessage();// mostramos el texto
      
      //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Scope prototype>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
      System.out.println("------------");
      System.out.println("Scope prototype");
      
      HelloWorld obja = (HelloWorld) context.getBean("helloWorld2");

      obja.setMessage("soy el objeto a");
      obja.getMessage();

      HelloWorld objb = (HelloWorld) context.getBean("helloWorld2");
      objb.getMessage();
      
      
      context.registerShutdownHook();// solo funciona con AbstractApplicationContext
   }
}