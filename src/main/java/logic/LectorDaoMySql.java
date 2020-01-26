package logic;

import org.hibernate.Session;
import org.hibernate.query.Query;
import tables.Lector;

import java.util.ArrayList;
import java.util.Arrays;

public class LectorDaoMySql {

    private Session session = HibernateUtils.getSessionFactory().getCurrentSession();
    private CrudDaoMySql<Lector> crudDaoMySql = new CrudDaoMySql(Lector.class);

    public LectorDaoMySql() {

    }

    public void createLector(Lector lector) {
        crudDaoMySql.create(lector);
    }

    public void updateLector(Lector lector) {
        crudDaoMySql.update(lector);
    }

    public void deleteLector(Lector lector) {
        crudDaoMySql.delete(lector);
    }

    public ArrayList<Lector> readAllLectors() {
        ArrayList<Lector> arrayListLectors = null;
        try {
            session.getTransaction().begin();
            String sqlQuery = "Select l.ID, l.fname,l.lname, l.age, s.stage_name, l.salary_usa from Burden as b " +
                    " inner join Lector as l on b.lector_id=l.ID inner join Stage as s on l.stage_id = s.ID" +
                    " inner join Departament as d on b.departament_id = d.ID " +
                    " inner join Head_of_departments as h on d.head_of_dept_id=h.ID";

            Query<Object[]> query = session.createQuery(sqlQuery);
            ArrayList<Object[]> datasList = (ArrayList<Object[]>) query.getResultList();
            arrayListLectors = convertToLectors(datasList);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return arrayListLectors;
    }

    public ArrayList<Lector> createQuery(String querySqlString) {
        ArrayList<Lector> arrayListLector = null;
        try {
            session.getTransaction().begin();
            ArrayList<Object[]> datasList = (ArrayList<Object[]>) session.createQuery(querySqlString).getResultList();
            arrayListLector = convertToLectors(datasList);
            session.getTransaction().commit();
            arrayListLector.stream().forEach((l) -> System.out.println(l.toString()));
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return arrayListLector;

    }

    private ArrayList<Lector> convertToLectors(ArrayList<Object[]> datasList) {
        if (datasList.isEmpty() == true)
            throw new IllegalArgumentException("Collection is empty! ");
        ArrayList<Lector> arrayListLectors = new ArrayList<Lector>();
        try {
            for (Object[] arr : datasList) {
                arrayListLectors.add(
                        new Lector(
                                Integer.valueOf(arr[0].toString()),
                                arr[1].toString(),
                                arr[2].toString(),
                                Integer.valueOf(arr[3].toString()),
                                arr[4].toString(),
                                Integer.valueOf(arr[5].toString())
                        )
                );
            }
        } catch (RuntimeException exception) {
            exception.printStackTrace();
        }
        return arrayListLectors;
    }


}
