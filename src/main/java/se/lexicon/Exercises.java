package se.lexicon;

import se.lexicon.data.DataStorage;
import se.lexicon.data.DataStorageImpl;
import se.lexicon.model.Gender;
import se.lexicon.model.Person;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static se.lexicon.model.Gender.FEMALE;
import static se.lexicon.model.Gender.MALE;

public class Exercises {
    private static DataStorage storage = DataStorage.INSTANCE;

    /*
       1.	Find everyone that has firstName: “Erik” using findMany().
    */

    public static void exercise1(String message) {

        System.out.println(message);

        //DataStorageImpl storage = new DataStorageImpl();

        Predicate<Person> firstNameErik = person -> person.getFirstName().equalsIgnoreCase("Erik");
        List<Person> personList = storage.findMany(firstNameErik);
        personList.forEach(System.out::println);
        System.out.println("----------------------");
    }

    /*
        2.	Find all females in the collection using findMany().
     */
    public static void exercise2(String message) {
        System.out.println(message);
        //Write your code here

        Predicate<Person> ladiesNames = person -> person.getGender().equals(FEMALE);
        List<Person> personList = storage.findMany(ladiesNames);
        personList.forEach(System.out::println);

        System.out.println("----------------------");
    }

    /*
        3.	Find all who are born after (and including) 2000-01-01 using findMany().
     */
    public static void exercise3(String message) {

        LocalDate date = LocalDate.parse("2019-09-01");

        Predicate<Person> bornAfter = person -> person.getBirthDate().isAfter(date) || person.getBirthDate().equals(date);

        DataStorageImpl storage = new DataStorageImpl();
        storage.findMany(bornAfter).forEach(System.out::println);

        System.out.println(message);

        System.out.println("----------------------");
    }

    /*
        4.	Find the Person that has an id of 123 using findOne().
     */
    public static void exercise4(String message) {
        System.out.println(message);

//Predicate<Person> locateId = person -> person.getId()==123;
  //      DataStorageImpl storage = new DataStorageImpl();
        System.out.println(storage.findOne(person -> person.getId()==123));
        System.out.println("----------------------");

    }

    /*
        5.	Find the Person that has an id of 456 and convert to String with following content:
            “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
     */
    public static void exercise5(String message) {
        System.out.println(message);
        //Write your code here
        //Person result= storage.findOne(person -> person.getId()==456);
        Predicate<Person> newPredicate = person -> person.getId()==456;

        Function<Person, String> myFunction = person -> String.valueOf(person);   //("Nisse","Nilsson","1999-09-09", FEMALE);
        String result1= storage.findOneAndMapToString(newPredicate,myFunction);
        System.out.println(result1);
        System.out.println("----------------------");
    }
    /*
        6.	Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
     */
    public static void exercise6(String message) {
        System.out.println(message);

Predicate<Person> personPredicate= person -> person.getFirstName().startsWith("E")  && person.getGender().equals(MALE);

        DataStorageImpl storage = new DataStorageImpl();
        //storage.findMany(personPredicate).forEach(System.out::println);
        Function<Person, String> myFunction = person -> String.valueOf(person);
        System.out.println(storage.findMany(personPredicate));


        //System.out.println(storage.findManyAndMapEachToString(personPredicate,myFunction));
        System.out.println(message);



        System.out.println("----------------------");
    }

    /*
        7.	Find all people who are below age of 10 and convert them to a String like this:
            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
     */
    public static void exercise7(String message) {
        System.out.println(message);

        LocalDate date1= LocalDate.parse("2011-05-28"); // age below 9 years

        Predicate<Person> personPredicate= person -> person.getBirthDate().isAfter(date1);
        System.out.println(storage.findMany(personPredicate));

        System.out.println("----------------------");
    }

    /*
        8.	Using findAndDo() print out all people with firstName “Ulf”.
     */
    public static void exercise8(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        9.	Using findAndDo() print out everyone who have their lastName contain their firstName.
     */
    public static void exercise9(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        10.	Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */
    public static void exercise10(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        11.	Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static void exercise11(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        12.	Using findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.
     */
    public static void exercise12(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        13.	Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static void exercise13(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }
}
