/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.dragon.bermaker.bean;

/**
 * The type Person.
 *
 * @ClassName: Person
 * @Project: dragon -wing
 * @Description: TODO
 * @Author: yuzhongchun
 * @Date: 2019 /3/25 5:12 PM
 * @Version: 1.0
 */
public class Person {

    private String firstName;

    private String lastName;

    private String job;

    private String gender;

    private int age;

    private int salary;

    public Person(String firstName, String lastName, String job, String gender, int age, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

    /**
     * Instantiates a new Person.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param job       the job
     * @param gender    the gender
     * @param salary    the salary
     * @param age       the age
     */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", job='").append(job).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Gets the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the firstName
     * <p>You can use getFirstName() to get the value of firstName</p>
     *
     * @param firstName firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the lastName
     * <p>You can use getLastName() to get the value of lastName</p>
     *
     * @param lastName lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the value of job
     *
     * @return the value of job
     */
    public String getJob() {
        return job;
    }

    /**
     * Sets the job
     * <p>You can use getJob() to get the value of job</p>
     *
     * @param job job
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * Gets the value of gender
     *
     * @return the value of gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender
     * <p>You can use getGender() to get the value of gender</p>
     *
     * @param gender gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the value of salary
     *
     * @return the value of salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Sets the salary
     * <p>You can use getSalary() to get the value of salary</p>
     *
     * @param salary salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Gets the value of age
     *
     * @return the value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age
     * <p>You can use getAge() to get the value of age</p>
     *
     * @param age age
     */
    public void setAge(int age) {
        this.age = age;
    }
}
