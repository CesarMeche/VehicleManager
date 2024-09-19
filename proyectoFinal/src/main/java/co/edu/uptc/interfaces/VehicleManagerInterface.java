package co.edu.uptc.interfaces;

import java.util.ArrayList;

import co.edu.uptc.pogos.Table;

public interface VehicleManagerInterface {

    public interface Model {
        public void setPresenter(Presenter presenter);
        public void loadData();
        public void sortData();
        public ArrayList<Table> getStates();
        public ArrayList<Table> getCounties();
        public ArrayList<Table> getCities();
        public ArrayList<Table> getMake();
        public ArrayList<Table> getmodel();
        public ArrayList<Table> getrange();
        
    }
    
    public interface View{
        public void setPresenter(Presenter presenter);
        public void begin();
    }

    public interface Presenter{
        public void setView(View view);
        public void setModel(Model model);
        public void loadData();
        public ArrayList<Table> getStates();
        public ArrayList<Table> getCounties();
        public ArrayList<Table> getCities();
        public ArrayList<Table> getMake();
        public ArrayList<Table> getmodel();
        public ArrayList<Table> getrange();
    }
} 
