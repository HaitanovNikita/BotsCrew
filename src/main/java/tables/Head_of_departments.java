package tables;

import javax.persistence.*;

@Entity
@Table(name="head_of_departments")
public class Head_of_departments {

    private int ID;
    private String fname;
    private String lname;
    private int age;

    public Head_of_departments() {
    }

    public Head_of_departments(int id, String fname, String lname, int age) {
        this.ID = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    @Id
    @JoinColumn(name="id")
    public int getID() {
        return ID;
    }

    @Column(name="fname")
    public String getFname() {
        return fname;
    }

    @Column(name="lname")
    public String getLname() {
        return lname;
    }

    @Column(name="age")
    public int getAge() {
        return age;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
