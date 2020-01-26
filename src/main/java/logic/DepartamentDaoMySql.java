package logic;

import org.hibernate.Session;
import org.hibernate.query.Query;
import tables.Departament;
import tables.Lector;
import tables.Stage;
import java.util.ArrayList;
import java.util.List;


public class DepartamentDaoMySql {
    private Session session = HibernateUtils.getSessionFactory().getCurrentSession();
    private CrudDaoMySql<Departament> crudDaoMySql = new CrudDaoMySql(Departament.class);

    public DepartamentDaoMySql() {

    }

    public void createDepartament(Departament departament) {
        crudDaoMySql.create(departament);
    }

    public void updateDepartament(Departament departament) {
        crudDaoMySql.update(departament);
    }

    public void deleteDepartament(Departament departament) {
        crudDaoMySql.delete(departament);
    }

    public ArrayList<Departament> readAllDepartaments() {

            String sqlQuery = "Select d.id, d.departament_name, h.fname, h.lname" +
                    " from Departament as d " +
                    " inner join Head_of_departments as h on d.head_of_dept_id = h.id";

        return createQueryToDb(sqlQuery);
    }


    public String getHeadOfDepartament(String nameDepartament) {
        String headOfDep = "";
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            session.getTransaction().begin();
            String query = "Select h.fname, h.lname " +
                    " from Departament as d" +
                    " inner join Head_of_departments as h on d.head_of_dept_id = h.ID " +
                    " where d.departament_name = '" + nameDepartament + "'";
            List<Object[]> list = session.createQuery(query).getResultList();
            Object[] arrDataHeadOfDept = list.get(0);
            headOfDep = arrDataHeadOfDept[0].toString() + " " + arrDataHeadOfDept[1].toString();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        return headOfDep;
    }

    public String getEmployeeStatistics(String nameDepartment) {
        String employeeStatistics = "";
        if (nameDepartment  != null && nameDepartment.isEmpty() == false) {
            /*Преобразовал к HashSet, дабы избежать повторяющихся элементов, что бы много раз не вызывать метод getNumberOfEmployeesPartStage
             *  с одними и теми же параметрами */
            for (Stage stage : new StageDaoMySQl().read()) {
                employeeStatistics += getNumberOfEmployeesPartStage(stage.getStage_name(), nameDepartment) + "\n";
            }
        }
        return employeeStatistics;
    }

    public String getAvgSalaryDepartment(String departamentName) {
        if (departamentName != null && departamentName.isEmpty() == false) {
            return "The average salary of " + departamentName + " is " + getDepAvgSalary(departamentName);
        }
        return  "Sorry, but there is no such department!";
    }

    public int getNumberEmployeesInDepartment(String departamentName) {
        if (departamentName != null && departamentName.isEmpty() == false) {
            int numberEmpInDept = 0;
            try {
                session = HibernateUtils.getSessionFactory().getCurrentSession();
                session.getTransaction().begin();
                String query = "Select count(b.lector_id) " +
                        "from Burden as b" +
                        " inner join Lector as l on b.lector_id = l.ID " +
                        " inner join Departament as d on b.departament_id = d.ID" +
                        " where d.departament_name = '"+departamentName.trim()+"'";
                List<Long> list = session.createQuery(query).getResultList();
                System.out.println("Console:"+list.get(0));
                numberEmpInDept = list.get(0).intValue();
            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
            return numberEmpInDept;
        }
        throw new NullPointerException("There is no such department!");
    }

    private int getDepAvgSalary(String departamentName) {
        if (departamentName != null && departamentName.isEmpty() == false) {
            int res = 0;
            try {
                session = HibernateUtils.getSessionFactory().getCurrentSession();
                session.getTransaction().begin();
                String query = "Select round(avg(l.salary_usa),0) " +
                        "from Burden as b" +
                        " inner join Lector as l on b.lector_id = l.ID" +
                        " inner join Departament as d on b.departament_id = d.ID" +
                        " where d.departament_name = '" + departamentName.trim() + "'";
                List<Double> list = session.createQuery(query).getResultList();
                res = (int) Math.round(list.get(0));
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
            return res;
        } else {
            throw new IllegalArgumentException();
        }
    }



    private String getNumberOfEmployeesPartStage(String stageName,String nameDepartment) {
        String result = "";
        if ((stageName != null && stageName.isEmpty() == false)&&(nameDepartment!=null&& nameDepartment.isEmpty()==false)) {
            try {
                session = HibernateUtils.getSessionFactory().getCurrentSession();
                session.getTransaction().begin();
                String query = "Select count(l.stage_id)" +
                        " from Burden as b " +
                        " inner join Lector as l ON b.lector_id = l.ID " +
                        " inner join Departament as d ON b.departament_id = d.ID" +
                        " inner join Stage as s ON l.stage_id = s.ID" +
                        " where s.stage_name = '"+stageName.trim()+"' and d.departament_name ='"+nameDepartment.trim()+"'";
                List<Long> list = session.createQuery(query).getResultList();
                result += stageName + " - " + list.get(0);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                result= "Sorry, but there is no such department!";
                e.printStackTrace();
            }
        }
        return result;
    }


    public ArrayList<Departament> createQueryToDb(String querySqlString) {
        ArrayList<Departament> arrayListLector = null;
        try {
            session.getTransaction().begin();
            ArrayList<Object[]> datasList = (ArrayList<Object[]>) session.createQuery(querySqlString).getResultList();
            arrayListLector = convertToDept(datasList);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return arrayListLector;

    }

    private ArrayList<Departament> convertToDept(ArrayList<Object[]> datasList) {
        if (datasList.isEmpty() == true)
            throw new IllegalArgumentException("Collection is empty! ");

        ArrayList<Departament> arrayListDepartament = new ArrayList<Departament>();
        try {
            for (Object[] arr : datasList) {
                arrayListDepartament.add(
                        new Departament(
                                Integer.valueOf(arr[0].toString()),
                                arr[1].toString(),
                                arr[2].toString()+" "+arr[3].toString()
                        )
                );
            }
        } catch (RuntimeException exception) {
            exception.printStackTrace();
        }
        return arrayListDepartament;
    }

}
