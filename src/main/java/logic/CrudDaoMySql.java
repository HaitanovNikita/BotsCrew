package logic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class CrudDaoMySql<T> implements CrudDaoMySqlInterface<T> {

    public Class clazz;
    private Session session = HibernateUtils.getSessionFactory().getCurrentSession();

    public CrudDaoMySql(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public void create(T object) {
        try{
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.getTransaction().begin();
            session.persist(object);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(T object) {
        try{
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.getTransaction().begin();
            session.update(object);
            session.getTransaction().commit();}
        catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @Override
    public void delete(T object) {
        try{
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.getTransaction().begin();
            session.delete(object);
            session.getTransaction().commit();}
        catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public ArrayList<T> read() {
        ArrayList<T> tArrayList = null;
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.getTransaction().begin();
            String[] arrTable = clazz.toString().split("tables.");
            tArrayList = (ArrayList<T>) session.createQuery("Select c from "+arrTable[1].trim()+" as c").getResultList();
            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return tArrayList;
    }
}
