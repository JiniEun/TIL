'use strict';
//class : template
//object : instance of a class

//class declarations
class Person {
    //constructor
    constructor(name, age) {
        //fields
        this.name = name;
        this.age = age;
    }

    //methods
    speak() {
        console.log(`${this.name}: hello! `);
    }
}

const hong = new Person('hong', 20);
console.log(hong.name)
console.log(hong.age);
hong.speak();