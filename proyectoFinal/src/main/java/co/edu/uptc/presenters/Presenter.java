package co.edu.uptc.presenters;

import java.util.ArrayList;

import co.edu.uptc.interfaces.VehicleManagerInterface;
import co.edu.uptc.pogos.Table;
import lombok.Getter;
@Getter
public class Presenter implements VehicleManagerInterface.Presenter{
    private VehicleManagerInterface.View view;
    private VehicleManagerInterface.Model model;


    @Override
    public void setView(VehicleManagerInterface.View view) {
       this.view = view;
    }

    @Override
    public void setModel(VehicleManagerInterface.Model model) {
        this.model = model;
    }

    @Override
    public void loadData() {
        model.loadData();
    }
    @Override
    public ArrayList<Table> getStates(){
        return model.getStates();
    }

    @Override
    public ArrayList<Table> getCounties() {
        return model.getCounties();
    }

    @Override
    public ArrayList<Table> getCities() {
        return model.getCities();
    }

    @Override
    public ArrayList<Table> getMake() {
        return model.getMake();
    }

    @Override
    public ArrayList<Table> getmodel() {
        return model.getmodel();
    }

    @Override
    public ArrayList<Table> getrange() {
        return model.getrange();
    }
    
    
}
