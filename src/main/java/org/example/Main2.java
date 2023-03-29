package org.example;

import jdk.jshell.PersistentSnippet;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person person;
        Optional<Person> optionalPerson = getPersonFromServer2();
        person = optionalPerson.orElse(new Person());
        System.out.println(person);


    }

    public static Person getPersonFromServer(){
        Person person = null;
        // тут мы типа подключаемся к серверу и получаем человека
        return person;
    }

    public static Optional<Person> getPersonFromServer2(){
        Person person = null;
        // тут мы типа подключаемся к серверу и получаем человека
        return Optional.ofNullable(person);
    }


}

