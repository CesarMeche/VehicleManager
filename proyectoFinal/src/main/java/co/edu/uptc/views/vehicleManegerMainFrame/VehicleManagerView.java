package co.edu.uptc.views.vehicleManegerMainFrame;

import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JFrame;

import co.edu.uptc.interfaces.VehicleManagerInterface;
import co.edu.uptc.interfaces.VehicleManagerInterface.Presenter;
import co.edu.uptc.pogos.Table;
import lombok.Getter;
import java.awt.BorderLayout;
import java.awt.CardLayout;

@Getter
public class VehicleManagerView extends JFrame implements VehicleManagerInterface.View{
    private VehicleManagerInterface.Presenter presenter;
    private VehicleManagerHeader vehicleManagerHeader;
    private VehicleManagerBody vehicleManagerBody;
    private VehicleManagerAside vehicleManagerAside;
    private CardLayout bodyCardLayout;
    private CardLayout asideCardLayout;

    public VehicleManagerView(){
        this.initFrame();
        this.createVehicleManagerHeader();
        this.createVehicleManagerBody();
        this.createVehicleManagerAside();
    }

    @Override
    public void begin() {
        loadTables();
       this.setVisible(true);
    }
    private void loadTables(){
        loadCityData();
        loadStateData();
        loadCountyData();
        loadMakeData();
        loadModelData();
        loadRangeData();
    }
    private void loadStateData(){
        ArrayList<Table> states = presenter.getStates();
        for (Table t : states) {
            vehicleManagerBody.createTableVec(t,vehicleManagerBody.getVehicleStateTable());
        }
    }
    private void loadCountyData(){
        ArrayList<Table> counties = presenter.getCounties();
        for (Table t : counties) {
            vehicleManagerBody.createTableVec(t,vehicleManagerBody.getVehiclesCountyTable());
        }
    }
    private void loadCityData(){
        ArrayList<Table> Cities = presenter.getCities();
        for (Table t : Cities) {
            vehicleManagerBody.createTableVec(t,vehicleManagerBody.getVehiclesCityTable());
        }
    }
    private void loadModelData(){
        ArrayList<Table> models = presenter.getmodel();
        for (Table t : models) {
            vehicleManagerBody.createTableVec(t,vehicleManagerBody.getVehicleModelTable());
        }
    }
    private void loadMakeData(){
        ArrayList<Table> Make = presenter.getMake();
        for (Table t : Make) {
            vehicleManagerBody.createTableVec(t,vehicleManagerBody.getVehicleMakeTable());
        }
    }
    private void loadRangeData(){
        ArrayList<Table> ranges = presenter.getrange();
        for (Table t : ranges) {
            vehicleManagerBody.createTableVec(t,vehicleManagerBody.getVehicleRangeTable());
        }
    }

    private void initFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Administrador de vehiculos electronicos");
        this.setLayout((LayoutManager) new BorderLayout());
        this.setSize(900,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void createVehicleManagerHeader(){
        vehicleManagerHeader = new VehicleManagerHeader(this);
        this.add(vehicleManagerHeader,BorderLayout.NORTH);
    }

    private void createVehicleManagerBody(){
        bodyCardLayout = new CardLayout();
        vehicleManagerBody = new VehicleManagerBody(this,bodyCardLayout);
        this.add(vehicleManagerBody);
    }

    private void createVehicleManagerAside(){
        asideCardLayout = new CardLayout();
        vehicleManagerAside = new VehicleManagerAside(this,asideCardLayout);
        this.add(vehicleManagerAside,BorderLayout.WEST);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}
