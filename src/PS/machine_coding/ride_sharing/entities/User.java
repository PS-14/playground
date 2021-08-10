package PS.machine_coding.ride_sharing.entities;
  /*   
   Bluemoon
   09/08/21 4:09 PM  
   */

import PS.machine_coding.ride_sharing.enums.Gender;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 7469042345176778819L;
    private long id;
    private String name;
    private int age;
    private Gender gender;

    public User() {
    }

    public long getId() {
        return id;
    }

    public User _setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User _setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User _setAge(int age) {
        this.age = age;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public User _setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
}
