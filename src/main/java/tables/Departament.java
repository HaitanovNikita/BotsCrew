package tables;

import javax.persistence.*;


@Entity
@Table(name="departament")
public class Departament {

    private int ID;
    private String departament_name;
    private int head_of_dept_id;

    private String head_of_dept;

    public Departament() {
    }

    public Departament(int id, String departament_name, int head_of_dept_id) {
        this.ID = id;
        this.departament_name = departament_name;
        this.head_of_dept_id = head_of_dept_id;
    }

    public Departament(int id, String departament_name, String head_of_dept) {
        this.ID = id;
        this.departament_name = departament_name;
        this.head_of_dept = head_of_dept;
    }

    @Id
    @JoinColumn(name="id")
    public int getID() {
        return ID;
    }

    @Column(name="departament_name")
    public String getDepartament_name() {
        return departament_name;
    }

    @Column(name="head_of_dept_id")
    public int getHead_of_dept_id() {
        return head_of_dept_id;
    }

    public String getHead_of_dept() {
        return head_of_dept;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDepartament_name(String departament_name) {
        this.departament_name = departament_name;
    }

    public void setHead_of_dept_id(int head_of_dept_id) {
        this.head_of_dept_id = head_of_dept_id;
    }

    public void setHead_of_dept(String head_of_dept) {
        this.head_of_dept = head_of_dept;
    }

    @Override
    public String toString() {
        String res="Departament №"+ ID +"|\n" +
                    "id: " + ID +
                ", departament_name: " + departament_name ;
        if(head_of_dept_id==0)
            res+=", head_of_dept: " + head_of_dept;
        else
            res+=", head_of_dept_id: " + head_of_dept_id;
        return res+ "\n|";




    }
}
