package com.example.WebProject1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public  class DAO {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected With Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsystem", "Omar", "1234");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    public static int ChangeGrade(String Grade ,String CID ,int SID ){
        int status=0;
        try{
            Connection con=DAO.getConnection();
            String SqlStatement="Update enrollments set SCORE=?where CID=? AND SID=?;";
            PreparedStatement pstmt = con.prepareStatement(SqlStatement);
            pstmt.setDouble(1, Double.parseDouble(Grade));
            pstmt.setInt(2, Integer.parseInt(CID));
            pstmt.setInt(3, SID);
            status= pstmt.executeUpdate();
            con.close();
        }catch(Exception e){e.printStackTrace();}
        return  status;
    }
    public static List getStudentsId(String CID){
        List<Integer> list=new ArrayList<>();
        try{
            Connection con=DAO.getConnection();
            String SqlStatement="select SID from enrollments where CID=?;";
            PreparedStatement pstmt = con.prepareStatement(SqlStatement);
            pstmt.setInt(1, Integer.parseInt(CID));
            ResultSet resultSet= pstmt.executeQuery();
            while(resultSet.next()){
                list.add(Integer.valueOf(resultSet.getString(1)));
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}
        return  list;

    }
    public static Map<Integer, StudentGrade> getStudentsAndGrade(String CID) {
        Map<Integer, StudentGrade> map=new TreeMap<>();
        int SID;
        try{
            Connection con=DAO.getConnection();
            Statement statement=con.createStatement();
            String SqlStatement="select enrollments.SID,FName,SCORE from enrollments ,courses,student where enrollments.CID = "+"'"+CID+"'"+"  and enrollments.SID=student.SID;";
            ResultSet resultSet=statement.executeQuery(SqlStatement);
            while(resultSet.next()){
                StudentGrade studentGrade=new StudentGrade();
                SID= Integer.parseInt(resultSet.getString(1));
                studentGrade.setFName(resultSet.getString(2));
                studentGrade.setGrade(resultSet.getDouble(3));
                map.put(SID,studentGrade);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}
        return map;
    }

    public static Map<String,String> getAllCoursesForStudent(String Id) {
        Map<String,String> map=new TreeMap<>();
        String Cname,Score;
        try{
            Connection con=DAO.getConnection();
            Statement statement=con.createStatement();
            String SqlStatement="select CName,SCORE from enrollments ,courses where SID = "+"'"+Id+"'"+"  and enrollments.CID=courses.CID;";
            ResultSet resultSet=statement.executeQuery(SqlStatement);
            while(resultSet.next()){
                Cname=resultSet.getString(1);
                Score=resultSet.getString(2);
                map.put(Cname,Score);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}
        return map;
    }
    public static Map<String,String> getAllCoursesForInstructor(String Id) {
        Map map=new TreeMap();
        String Cname,CID;
        try{
            Connection con=DAO.getConnection();
            Statement statement=con.createStatement();
            String SqlStatement="select CID,CName from instructor ,courses where IID = "+"'"+Id+"'"+"  and instructor.IID=courses.CIID;";
            ResultSet resultSet=statement.executeQuery(SqlStatement);
            while(resultSet.next()){
                CID=String.valueOf(resultSet.getString(1));
                Cname=resultSet.getString(2);
                map.put(CID,Cname);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}
        return map;
    }

    public static User Login(String Email, String Password,String Type) {
       User user=new User();
        try {
            Connection con = DAO.getConnection();
            Statement statement = con.createStatement();
            System.out.println("Email = "+Email);
            String SqlStatement="";
            if(Type.equals("Student")){
                SqlStatement= "select * from student where Email = "+"'"+Email+"'"+"  AND  Pass = "+"'"+Password+"'";
            }else if(Type.equals("Admin")){
                 SqlStatement = "select * from admin where Email = "+"'"+Email+"'"+"  AND  Pass = "+"'"+Password+"'";
            }else if(Type.equals("Instructor")){
                 SqlStatement = "select * from instructor where Email = "+"'"+Email+"'"+"  AND  Pass = "+"'"+Password+"'";
            }
            if(!SqlStatement.equals("")){
                ResultSet resultSet=statement.executeQuery(SqlStatement);
                while (resultSet.next()){
                    user.setID(Integer.parseInt(resultSet.getString(1)));
                    user.setFName(resultSet.getString(2));
                }
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
}


