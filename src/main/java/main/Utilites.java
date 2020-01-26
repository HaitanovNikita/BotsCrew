package main;

import logic.DepartamentDaoMySql;

public class Utilites {

    public static void colorPrintln(String dataForPrint, int color30To37){
        System.out.println((char)27 + "["+color30To37+"m" + dataForPrint);
    }

    public static void printAllDepartaments(DepartamentDaoMySql depDaoMySql){
        colorPrintln("The university has such faculties:",36);
        depDaoMySql.readAllDepartaments().stream().forEach((d)-> colorPrintln(d.getDepartament_name(),32));
        colorPrintln("Enter the name of one of the faculties ",36);
    }
}
