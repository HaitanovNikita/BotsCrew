package logic;

import java.util.ArrayList;

public interface CrudDaoMySqlInterface<T> {

    void create(T object);
    void update(T object);
    void delete(T object);
    ArrayList<T> read();

}
