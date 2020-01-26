package main;

import logic.DepartamentDaoMySql;

import java.util.Scanner;

import static main.Utilites.colorPrintln;
import static main.Utilites.printAllDepartaments;

public class Menu {

    public Menu(){
        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s ="";
        DepartamentDaoMySql depDaoMySql =new DepartamentDaoMySql();
        String nameDepartament="";
        while (!"5".equals(s)){
            colorPrintln("*********Menu****************",35);
            colorPrintln("1. Find out the head of department",35);
            colorPrintln("2. Show department statistics",35);
            colorPrintln("3. Sho the average salary for departament",35);
            colorPrintln("4. Show count of employee for department ",35);
            colorPrintln("5. Exit",35);
            colorPrintln("*************************",35);
            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e){
                colorPrintln("Invalid input! ",31);
            }

            switch (x){
                case 1:
                    printAllDepartaments(depDaoMySql);
                    nameDepartament = new Scanner(System.in).nextLine();
                    colorPrintln("Head of " + nameDepartament + "  is "+depDaoMySql.getHeadOfDepartament(nameDepartament),36);
                    break;
                case 2:
                    printAllDepartaments(depDaoMySql);
                    nameDepartament = new Scanner(System.in).nextLine();
                    colorPrintln(""+ nameDepartament +"‌ ‌statistic \n"+depDaoMySql.getEmployeeStatistics(nameDepartament),36);
                    break;
                case 3:
                    printAllDepartaments(depDaoMySql);
                    nameDepartament = new Scanner(System.in).nextLine();
                    colorPrintln(" ‌The‌ ‌average‌ ‌salary‌ ‌of‌ "+nameDepartament+"‌ ‌is‌ "+depDaoMySql.getAvgSalaryDepartment(nameDepartament)+"",36);
                case 4:
                    printAllDepartaments(depDaoMySql);
                    nameDepartament = new Scanner(System.in).nextLine();
                    colorPrintln(""+depDaoMySql.getNumberEmployeesInDepartment(nameDepartament),36);
            }
        }
        System.out.println("Good luck!");
    }


}
