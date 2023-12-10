package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DbConnect2 {
    public static void main(String[] args) {
//          getData();
//          insertData();
//          deleteData();
//          updateData();
//          deleteDataUsingId();
//          updateDataById();
          getDataById();
        try {
            getConnection().close();
            System.out.println("Connection Closed");
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myserver", "root", "sHar@112");
            return conn;
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return null;
    }

    public static void getData() {
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (Exception e) {
            System.out.println("Something went wrong " + e);
        }
    }

    public static void insertData() {
        try {
            Statement statement = getConnection().createStatement();
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String course = sc.nextLine();
            int completion = sc.nextInt();
            int age = sc.nextInt();
            int result = statement.executeUpdate("insert into student values (" + id + ",'" + name + "','" + course + "'," + completion + "," + age + ")");
            if (result == 1) {
                System.out.println("updated");
            } else {
                System.out.println("error");
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public static void deleteData() {
        try {
            Statement statement = getConnection().createStatement();
            int result = statement.executeUpdate("delete from student where id = 7");
            if (result == 1) {
                System.out.println("deleted");
            } else {
                System.out.println("error");
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public static void updateData() {
        try {
            Statement statement = getConnection().createStatement();
            int res = statement.executeUpdate("update student set name = 'Ramsevak' where id = 6");
            if (res == 1) {
                System.out.println("Updated Successfully");
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public static void deleteDataUsingId() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Id: ");
            int id = sc.nextInt();
            Statement statement = getConnection().createStatement();
            int res = statement.executeUpdate("delete from student where id = " + id);
            if (res == 1) {
                System.out.println("Success");
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public static void updateDataById() {
        try {
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            int id = sc.nextInt();

            Statement statement = getConnection().createStatement();
            int res = statement.executeUpdate("update student set name = '" + name + "' where id = " + id);
            if (res == 1) {
                System.out.println("Updated");
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public static void getDataById() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Id: ");
            int id = sc.nextInt();
            Statement statement = getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from student where id = " + id);
            while (res.next()) {
                System.out.print(res.getString("id")+" ");
                System.out.print(res.getString("name")+" ");
                System.out.print(res.getString("course")+" ");
                System.out.print(res.getString("completion")+" ");
                System.out.println(res.getString("age"));
//                getConnection().close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
