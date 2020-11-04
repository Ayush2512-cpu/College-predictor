package model;

public class Student {
    public String name;
    public String phone;
    public String email;
    public int rank;
    public String exam;
    public String category;
    public String field;
    public String state;
    public String fees;

    public Student(String name, String phone, String email, int rank,String exam,String category,String field,String state,String fees){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.rank = rank;
        this.exam = exam;
        this.category = category;
        this.field = field;
        this.state = state;
        this.fees = fees;
    }

    @Override
    public String toString(){
        return "Student : Name = " + name + ", Phone = " + phone + " , email = " + email + " , rank = " + rank + " , exam name = " + exam +" , category = " + category;
    }
}
