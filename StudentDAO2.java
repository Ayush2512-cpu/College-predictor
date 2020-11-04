package database;


import model.College;
import model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDAO2 {
    private Connection connect = null;

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1/studentdetails?"
                            + "user=root&password=25122001Ayush");


        } catch (Exception e) {
            throw e;
        } finally {
            //close();
        }

    }

    public void delete() throws Exception {
        readDataBase();
        Statement stmt = connect.createStatement();
        stmt.executeUpdate("delete from studentdetails.studentdetails");
    }

//    public List<String> getFields (){
//        StringBuilder queryBuilder = new StringBuilder("select distinct field from studentdetails.studentdetails");
//        String query = queryBuilder.toString();
//        System.out.println("Search Query is : " + query);
//
//        try{
//            ResultSet resultSet = executeQuery(query);
//
//            List<String> fields = new ArrayList<>();
//            while(resultSet.next()){
//                String field = resultSet.getString("field");
//                fields.add(field);
//            }
//
//            return fields;
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return new ArrayList<>();
//    }

//    public List<String> getStates (){
//        StringBuilder queryBuilder = new StringBuilder("select distinct state from studentdetails.studentdetails");
//        String query = queryBuilder.toString();
//        System.out.println("Search Query is : " + query);
//
//        try{
//            ResultSet resultSet = executeQuery(query);
//
//            List<String> states = new ArrayList<>();
//            states.add("ANY STATE");
//            while(resultSet.next()){
//                String state = resultSet.getString("state");
//                states.add(state);
//            }
//
//            return states;
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return new ArrayList<>();
//    }


    public List<Student> getCollegeFromResultSet(ResultSet resultSet) throws SQLException {
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");
            String email = resultSet.getString("email");
            int rank = resultSet.getInt("rank");
            String exam = resultSet.getString("exam");
            String category = resultSet.getString("category");
            String field = resultSet.getString("field");
            String state = resultSet.getString("state");
            String fees = resultSet.getString("fees");

            Student student = new Student(name, phone, email, rank, exam, category, field, state, fees);
            students.add(student);
        }

        return students;
    }

    public ResultSet executeQuery (String query) throws SQLException {
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        //  statement.close();
        return resultSet;

    }

    public void insert (Student student) throws SQLException {
        PreparedStatement preparedStatement = connect
                .prepareStatement("insert into  studentdetails.studentdetails " +
                        "values " +
                        "(?, ? ,?, ?, ?, ?, ?, ?, ?)");

        // Parameters start with 1
        preparedStatement.setString(1, student.name);
        preparedStatement.setString(2, student.phone);
        preparedStatement.setString(3, student.email);
        preparedStatement.setInt(4, student.rank);
        preparedStatement.setString(5, student.exam);
        preparedStatement.setString(6, student.category);
        preparedStatement.setString(7, student.field);
        preparedStatement.setString(8, student.state);
        preparedStatement.setString(9, student.fees);


        preparedStatement.executeUpdate();
    }

    private void writeMetaData (ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
        }
    }

    // You need to close the resultSet
    private void close () {
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
