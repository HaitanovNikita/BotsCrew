package logic;

import org.hibernate.Session;
import tables.Burden;
import tables.Stage;

import java.util.ArrayList;

public class StageDaoMySQl {

    private CrudDaoMySql<Stage> crudDaoMySql = new CrudDaoMySql(Stage.class);

    public StageDaoMySQl() {

    }

    public void create(Stage stage){
        crudDaoMySql.create(stage);
    }

    public void update(Stage stage){
        crudDaoMySql.update(stage);
    }

    public void delete(Stage stage){
        crudDaoMySql.delete(stage);
    }

    public ArrayList<Stage> read(){
        return crudDaoMySql.read();
    }
}
