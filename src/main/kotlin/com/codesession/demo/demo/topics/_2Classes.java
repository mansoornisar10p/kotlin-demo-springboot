package com.codesession.demo.demo.topics;
class PersonJ {
    private String name;
    private int age;

    public PersonJ(String name) {
        this.name = name;
    }

    public PersonJ() {
        this.name = "default name";
    }

    void printNameLength() {
        System.out.println(name.length());
    }

    //Breaking constructor
    public PersonJ(int age) {
        this.age = age;
    }
}