package org.example;

public class Person {

    String name;
    String surname;
    String age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public Person(String name, String surname, String age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person() {
        name = "пусто";
        surname = "пусто";
        age = "пусто";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAge() {
        return age;
    }
}
