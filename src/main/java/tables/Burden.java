package tables;

import javax.persistence.*;

@Entity
@Table(name="Burden")
public class Burden {

    private int ID;
    private int lector_id;
    private int departament_id;

    public Burden() {
    }

    public Burden(int id, int lector_id, int departament_id) {
        this.ID = id;
        this.lector_id = lector_id;
        this.departament_id = departament_id;
    }
    @Id
    @JoinColumn(name="id")
    public int getID() {
        return ID;
    }

    @Column(name="lector_id")
    public int getLector_id() {
        return lector_id;
    }

    @Column(name="departament_id")
    public int getDepartament_id() {
        return departament_id;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLector_id(int lector_id) {
        this.lector_id = lector_id;
    }

    public void setDepartament_id(int departament_id) {
        this.departament_id = departament_id;
    }

    @Override
    public String toString() {
        return "Burden{" +
                "id=" + ID +
                ", lector_id=" + lector_id +
                ", departament_id=" + departament_id +
                '}';
    }
}
