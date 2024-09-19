package co.edu.uptc.utilities.sorters;

import java.util.Comparator;

import co.edu.uptc.pogos.Table;

public class ComparadorTables {
public static Comparator<Table> comparatorTables = new Comparator<Table>() {
    
    @Override
    public int compare(Table o1, Table o2) {
        if(o1.getCan()==o2.getCan()){
            return o1.getAux().compareTo(o2.getAux());

        }
        return (o2.getCan()-o1.getCan());
    }
};
    
}
