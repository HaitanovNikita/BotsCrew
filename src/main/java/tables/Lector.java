package tables;

import javax.persistence.*;

@Entity
@Table(name = "Lector")
public class Lector {

    private int ID;
    private String fname;
    private String lname;
    private int age;
    private int stage_id;
    private int salary_usa;

    private String stage_string;

    public Lector() {
    }

    public Lector(int id, String fname, String lname, int age, int stage_id, int salary) {
        this.ID = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.stage_id = stage_id;
        this.salary_usa = salary;
    }

    public Lector(int id, String fname, String lname, int age, String stage_string, int salary) {
        this.ID = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.salary_usa = salary;
        this.stage_string = stage_string;
    }

    @Id
    @JoinColumn(name = "ID")
    public int getID() {
        return ID;
    }

    @Column(name = "fname")
    public String getFname() {
        return fname;
    }

    @Column(name = "lname")
    public String getLname() {
        return lname;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    @Column(name = "stage_id")
    public int getStage_id() {
        return stage_id;
    }

    @Column(name = "salary_usa")
    public int getSalary_usa() {
        return salary_usa;
    }

    public String getStage_string() {
        return stage_string;
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

    public void setSalary_usa(int salary_usa) {
        this.salary_usa = salary_usa;
    }

    public void setStage_id(int stage_id) {
        this.stage_id = stage_id;
    }

    public void setStage_string(String stage_string) {
        this.stage_string = stage_string;
    }

    @Override
    public String toString() {


        String res = "Lector #" +
                ID + "|\n" +
                "id: " + ID +
                ", fname: " + fname +
                ", lname: " + lname +
                ", age: " + age;
        if (stage_id == 0) res += " stage: " + stage_string;
        else res += " stage: " + stage_id;
        res += ", salary: " + salary_usa +
                "\n|";
        return res;
    }
}
