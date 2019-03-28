/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

import com.dragon.bermaker.bean.Person;

/**
 * The type Lamdba expression test.
 *
 * @ClassName: LambdaExpressionTest
 * @Project: dragon -wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019 /3/25 4:28 PM
 * @Version: 1.0
 */
public class LambdaExpressionTest {

    private List<Person> javaProgrammers = new ArrayList<Person>() {
        {
            add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
            add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
            add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
            add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
            add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
            add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
            add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
            add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
            add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
            add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
        }
    };

    private List<Person> phpProgrammers = new ArrayList<Person>() {
        {
            add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
            add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
            add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
            add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
            add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
            add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
            add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
            add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
            add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
            add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
        }
    };

    /**
     * Test lambda basic.
     */
    @Test
    public void testLambdaBasic() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);
        for (String player : players) {
            System.out.print(player + ", ");
        }
        System.out.println();
        players.forEach((player) -> System.out.print(player + ", "));
        System.out.println();
    }

    /**
     * Test thread anonymous inner class.
     */
    @Test
    public void testThreadByAnonymousInnerClass() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi, everyone!");
            }
        }).start();
    }

    /**
     * Test thread lambda expression.
     */
    @Test
    public void testThreadByLambdaExpression() {
        new Thread(() -> System.out.println("Hi, everyone!")).start();
    }

    /**
     * Test thread runnable.
     */
    @Test
    public void testThreadRunnable() {
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world!");
            }
        };
        Runnable race2 = () -> System.out.println("Hello world!");
        new Thread(race1).start();
        new Thread(race2).start();
    }

    /**
     * Test sort by anonymous inner class.
     */
    @Test
    public void testSortByAnonymousInnerClass() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};
        Arrays.sort(atp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        List<String> players = Arrays.asList(atp);
        for (String player : players) {
            System.out.print(player + ", ");
        }
        System.out.println();
    }

    /**
     * Test sort by lambda expression.
     */
    @Test
    public void testSortByLambdaExpression() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};
        Comparator<String> sortByName = Comparator.comparing(s -> s);
        // (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(atp, sortByName);
        List<String> players = Arrays.asList(atp);
        for (String player : players) {
            System.out.print(player + ", ");
        }
        System.out.println();
    }

    @Test
    public void testStreams() {
        // list all the programmers
        System.out.println("All programmers: ");
        javaProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        System.out.println();
        phpProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        System.out.println();
        // modify salary
        System.out.println("Add %5 salary: ");
        Consumer<Person> giveRaise = (e) -> e.setSalary(e.getSalary() * 5 / 100 + e.getSalary());
        javaProgrammers.forEach(giveRaise);
        phpProgrammers.forEach(giveRaise);
        System.out.println();
        javaProgrammers.forEach((p) -> System.out.println(p.toString()));
        System.out.println();
        phpProgrammers.forEach((p) -> System.out.println(p.toString()));
        System.out.println();
        // filter
        System.out.println("Salary > 1400: ");
        phpProgrammers.stream().filter((p) -> (p.getSalary() > 1400)).forEach((p) -> System.out.println(p));
        System.out.println();

        // Define filters
        Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
        Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
        Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));
        System.out.println("Age > 24 && Salary > 1400 and Gender=female");
        phpProgrammers.stream().filter(ageFilter).filter(salaryFilter).filter(genderFilter).forEach((p) -> System.out
                .println(p));
        System.out.println();
        System.out.println("Age > 24 && Gender=female");
        javaProgrammers.stream().filter(ageFilter).filter(genderFilter).forEach((p) -> System.out.println(p));
        System.out.println();

        // Limit
        System.out.println("The first 3 Java programmers: ");
        javaProgrammers.stream().limit(3).forEach((p) -> System.out.println(p));
        System.out.println();
        System.out.println("The first 3 female Java programmers: ");
        javaProgrammers.stream().filter(genderFilter).limit(3).forEach((p) -> System.out.println(p));

        // Sort by first name
        System.out.println("Sorted by name: ");
        List<Person> sortedJavaProgrammers =
                javaProgrammers.stream().sorted(Comparator.comparing(Person::getFirstName))
                        .limit(5).collect(Collectors.toList());
        sortedJavaProgrammers.forEach((p) -> System.out.println(p));

        // Sort by salary
        System.out.println("Sorted by salary:");
        //        sortedJavaProgrammers = javaProgrammers.stream().sorted((p1, p2) -> (p1.getSalary() - p2.getSalary
        //        ())).collect(
        //                Collectors.toList());
        sortedJavaProgrammers = javaProgrammers.stream().sorted(Comparator.comparing(Person::getSalary)).collect(
                Collectors.toList());
        sortedJavaProgrammers.forEach((p) -> System.out.println(p));

        // Min salary java programmer
        System.out.println("The lowest salary java programmer: ");
        Person person = javaProgrammers.stream().min(Comparator.comparing(Person::getSalary)).get();
        System.out.println(person);

        // Map
        System.out.println("Concat PHP programmers' first name: ");
        String phpDevelopers = phpProgrammers.stream().map(Person::getFirstName).collect(Collectors.joining("; "));
        System.out.println(phpDevelopers);
        System.out.println("Put Java programmers' first name into a Set: ");
        Set<String> javaDevFirstname = javaProgrammers.stream().map(Person::getFirstName).collect(Collectors.toSet());
        System.out.println(javaDevFirstname);
        System.out.println("Put Java programmers' last name into a TreeSet:");
        TreeSet<String> javaDevLastName =
                javaProgrammers.stream().map(Person::getLastName).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(javaDevLastName);

        // Parallel
        System.out.print("Calculte all the money to Java programmers: ");
        int totalSalary = javaProgrammers.parallelStream().mapToInt((p) -> p.getSalary()).sum();
        System.out.println(totalSalary);

        // summaryStatistics
        System.out.println("SummaryStatistics: ");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(stats);
    }

}
