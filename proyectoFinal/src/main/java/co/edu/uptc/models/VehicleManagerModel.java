package co.edu.uptc.models;

import java.util.ArrayList;
import java.util.function.Function;

import co.edu.uptc.dynamic.SimpleList;
import co.edu.uptc.interfaces.VehicleManagerInterface;
import co.edu.uptc.model.MySort;
import co.edu.uptc.pogos.Table;
import co.edu.uptc.pogos.Vehicle;
import co.edu.uptc.utilities.JsonReader;
import co.edu.uptc.utilities.sorters.*;
import lombok.Getter;

@Getter
public class VehicleManagerModel implements VehicleManagerInterface.Model {
    private VehicleManagerInterface.Presenter presenter;
    private SimpleList<Vehicle> vehicles;
    private ArrayList<Table> states;
    private ArrayList<Table> counties;
    private ArrayList<Table> cities;
    private ArrayList<Table> make;
    private ArrayList<Table> range;
    private ArrayList<Table> model;

    public VehicleManagerModel() {
        vehicles = new SimpleList<>();
        loadData();
        loadTables();
        sortData();
    }

    @Override
    public void setPresenter(VehicleManagerInterface.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadData() {
        JsonReader jr = new JsonReader("https://data.wa.gov/api/views/f6w7-q2d2/rows.json");

        vehicles = jr.read();
    }

    public ArrayList<Table> getDataToTable(Function<Vehicle, String> data) {

        ArrayList<String> states = new ArrayList<String>();
        ArrayList<Table> tables = new ArrayList<Table>();
        Table aux;
        for (Vehicle vehicle : vehicles) {
            String name;
            String atribute = data.apply(vehicle);
            if (atribute == null) {
                name = "null";

            } else {
                name = atribute;
            }
            if (!states.contains(name)) {
                aux = new Table(name, 1);
                states.add(name);
                tables.add(aux);
            } else {
                int auxi = 0;

                while (!name.equals(states.get(auxi))) {

                    auxi++;
                }
                add(tables.get(auxi));
            }

        }
        return tables;

    }

    private void loadTables() {
        states = getDataToTable(Vehicle::getState);
        counties = getDataToTable(Vehicle::getCounty);
        cities = getDataToTable(Vehicle::getCity);
        model = getDataToTable(Vehicle::getModel);
        make = getDataToTable(Vehicle::getMake);
        range = getDataToTable(Vehicle::getElectricRange);
    }

    private Table add(Table t) {
        t.setCan(t.getCan() + 1);
        return t;
    }
    @Override
    public void sortData() {
        MySort.sort(states, ComparadorTables.comparatorTables);
        MySort.sort(counties, ComparadorTables.comparatorTables);
        MySort.sort(model, ComparadorTables.comparatorTables);
        MySort.sort(make, ComparadorTables.comparatorTables);
        MySort.sort(range, ComparadorTables.comparatorTables);
        sortCities();
    }

    private void sortCities() {
        ArrayList<Table> aux = new ArrayList();
        aux.add(cities.get(0));
        int i = 1;
        while (aux.get(0) == cities.get(i)) {
            i++;
            aux.add(cities.get(i));
        }
        cities = aux;
    }

    @Override
    public ArrayList<Table> getStates() {
        return states;
    }

    @Override
    public ArrayList<Table> getCounties() {
        return counties;
    }

    @Override
    public ArrayList<Table> getCities() {
        return cities;
    }

    @Override
    public ArrayList<Table> getmodel() {
        return model;
    }

    @Override
    public ArrayList<Table> getrange() {
        return range;
    }
}
