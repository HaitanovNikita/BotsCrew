package logic;

import org.hibernate.Session;
import tables.Burden;

import java.util.ArrayList;


public class BurdenDaoMySql {
    private CrudDaoMySql<Burden> crudDaoMySql = new CrudDaoMySql(Burden.class);

    public BurdenDaoMySql() {

    }

    public void create(Burden burden) {
        crudDaoMySql.create(burden);
    }

    public void update(Burden burden) {
        crudDaoMySql.update(burden);
    }

    public void delete(Burden burden) {
        crudDaoMySql.delete(burden);
    }

    public ArrayList<Burden> read() {
        return crudDaoMySql.read();
    }

}
