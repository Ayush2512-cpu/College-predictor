package model;

import java.util.List;

public class College {
    public String name;
    public String state;
    public int nrif_rank;
    public int fees;
    public String type;
    public String field;
    public String category;
    public int rank;

    public College(String name, String state, int nrif_rank, int fees,String type,String field, String category,int rank){
        this.name = name;
        this.state = state;
        this.nrif_rank = nrif_rank;
        this.fees = fees;
        this.type = type;
        this.field = field;
        this.category = category;
        this.rank = rank;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("College : [ ");

        sb.append("Name : " + this.name + ", ");
        sb.append("State : " + this.state + ", ");
        sb.append("Nrif_Rank: " + this.nrif_rank + ", ");
        sb.append("Fees : " + this.fees + ", ");
        sb.append("Field : " + this.field + ", ");
        sb.append("Type : " + this.type + ", ");
        sb.append("Category : " + this.category + ", ");
        sb.append("Rank : " + this.rank + ", ");

        sb.append(" ]");
        return sb.toString();
    }
}
