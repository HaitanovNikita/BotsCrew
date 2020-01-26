package tables;


import javax.persistence.*;

@Entity
@Table(name="Stage")
public class Stage {

    private int ID;
    private String stage_name;

    public Stage() {
    }

    public Stage(int id, String stage_name) {
        this.ID = id;
        this.stage_name = stage_name;
    }

    @Id
    @JoinColumn(name="ID")
    public int getID() {
        return ID;
    }

    @Column(name="stage_name")
    public String getStage_name() {
        return stage_name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setStage_name(String stage_name) {
        this.stage_name = stage_name;
    }
}
