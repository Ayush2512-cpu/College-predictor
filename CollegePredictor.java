package predictor;

import app.Page1;
import database.*;

import java.sql.SQLException;

public class CollegePredictor {

    public static void main(String args[]) throws Exception {
        CollegeDAO collegeDAO = new CollegeDAO();
        collegeDAO.readDataBase();

        //populateDatabase(collegeDAO);

        StudentDAO2 studentDAO2 = new StudentDAO2();
        //studentDAO2.createTable("StudentDatabase");
        studentDAO2.readDataBase();

        Page1 page1 = new Page1(studentDAO2, collegeDAO);
        page1.runApplication();

//        TryMySQL dao = new TryMySQL();
//        try {
//            dao.readDataBase();
//        } catch (Exception e) {
//            e.printStackTrace();
//       }
    }

    private static void populateDatabase(CollegeDAO collegeDAO) throws Exception {

        collegeDAO.delete();
        try{
            CollegePopulatorAdvance.populate(collegeDAO);
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            CollegePopulatorMains.populate(collegeDAO);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}