package DataBaseTests;

import utilities.DatabaseUtility;

import java.util.List;

public class DB_Test01 {
    public static void main(String[] args) {
        String query="select * from jhr_user";
        DatabaseUtility.createConnection();


        List<String> columnNames=DatabaseUtility.getColumnNames(query);// jhr_user tablosundaki tum sutun isimleri
        System.out.println("columnNames = " + columnNames);

        for (int i = 0; i < columnNames.size(); i++) {  // jhr_user tablosundaki tum datalar
            List<Object> alljhr_userDatas= DatabaseUtility.getColumnData(query, columnNames.get(i));
            System.out.println("alljhr_userDatas = " +alljhr_userDatas );
        }

       List<Object> allSSNDatas= DatabaseUtility.getColumnData(query,"ssn");// jhr_user tablosundaki ssn sutunundaki datalar
        System.out.println("allSSNDatas = " + allSSNDatas);


    }
}
