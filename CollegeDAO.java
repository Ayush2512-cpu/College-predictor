package database;

import model.College;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollegeDAO {
    private Connection connect = null;

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/student?"
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
        stmt.executeUpdate("delete from student.college");
    }

    public List<String> getFields (){
        StringBuilder queryBuilder = new StringBuilder("select distinct field from student.college");
        String query = queryBuilder.toString();
        System.out.println("Search Query is : " + query);

        try{
            ResultSet resultSet = executeQuery(query);

            List<String> fields = new ArrayList<>();
            while(resultSet.next()){
                String field = resultSet.getString("field");
                fields.add(field);
            }

            return fields;
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<String> getStates (){
        StringBuilder queryBuilder = new StringBuilder("select distinct state from student.college");
        String query = queryBuilder.toString();
        System.out.println("Search Query is : " + query);

        try{
            ResultSet resultSet = executeQuery(query);

            List<String> states = new ArrayList<>();
            states.add("ANY STATE");
            while(resultSet.next()){
                String state = resultSet.getString("state");
                states.add(state);
            }

            return states;
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<College> searchColleges(College college) throws SQLException {
        StringBuilder queryBuilder = new StringBuilder("select * from student.college where");

        boolean fieldSet = false;
        if(college.name != null){
            queryBuilder.append(" name='"+college.name+"'");
            fieldSet = true;
        }
        if(college.state != null){
            if(fieldSet){
                queryBuilder.append(" and ");
            }
            queryBuilder.append(" state='"+college.state+"'");
            fieldSet = true;
        }
        if(college.fees > 0){
            if(fieldSet){
                queryBuilder.append(" and ");
            }
            queryBuilder.append(" fees<="+college.fees+"");
            fieldSet = true;
        }
        if(college.field != null){
            if(fieldSet){
                queryBuilder.append(" and ");
            }
            queryBuilder.append(" field='"+college.field+"'");
            fieldSet = true;
        }
        if(college.nrif_rank > 0){
            if(fieldSet){
                queryBuilder.append(" and ");
            }
            queryBuilder.append(" rank<="+college.nrif_rank+"");
            fieldSet = true;
        }
        if(college.type != null){
            if(fieldSet){
                queryBuilder.append(" and ");
            }
            queryBuilder.append(" type='"+college.type+"'");
            fieldSet = true;
        }
        if(college.category != null){
            if(fieldSet){
                queryBuilder.append(" and ");
            }
            queryBuilder.append(" type='"+college.category+"'");
            fieldSet = true;
        }
        if(college.rank != 0){
            if(fieldSet){
                queryBuilder.append(" and ");
            }
            queryBuilder.append(" rank='"+college.rank+"'");
            fieldSet = true;
        }

        String query = queryBuilder.toString();
        System.out.println("Search Query is : " + query);
        ResultSet resultSet = executeQuery(query);
        List<College> colleges = getCollegeFromResultSet(resultSet);
        resultSet.close();
        return colleges;
    }

    public List<College> getCollegeFromResultSet(ResultSet resultSet) throws SQLException {
        List<College> colleges = new ArrayList<>();
        while(resultSet.next()){
            String name = resultSet.getString("name");
            String state = resultSet.getString("state");
            int nrif_rank = resultSet.getInt("nrif_rank");
            int fees = resultSet.getInt("fees");
            String type = resultSet.getString("type");
            String field = resultSet.getString("field");
            String category = resultSet.getString("category");
            int rank = resultSet.getInt("rank");

            College college = new College(name,state,nrif_rank,fees,type,field, category,rank);
            colleges.add(college);
        }

        return colleges;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
      //  statement.close();
        return resultSet;
    }

    public void insert(College college) throws SQLException {
        PreparedStatement preparedStatement = connect
                    .prepareStatement("insert into  student.college " +
                            "values " +
                            "(?, ? ,?, ?, ?, ?, ?, ?)");

            // Parameters start with 1
            preparedStatement.setString(1, college.name);
            preparedStatement.setString(2, college.field);
            preparedStatement.setString(3, college.state);
            preparedStatement.setInt(4, college.nrif_rank);
            preparedStatement.setInt(5, college.fees);
            preparedStatement.setString(6, college.type);
            preparedStatement.setString(7, college.category);
        preparedStatement.setInt(8, college.rank);

            preparedStatement.executeUpdate();
    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
