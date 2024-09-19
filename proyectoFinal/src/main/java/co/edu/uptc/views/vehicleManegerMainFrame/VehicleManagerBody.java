package co.edu.uptc.views.vehicleManegerMainFrame;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.dynamic.SimpleList;
import co.edu.uptc.pogos.Table;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

@Getter
public class VehicleManagerBody extends JPanel {
    private VehicleManagerView vehicleManagerView;
    private JPanel welcoming;
    private JPanel vehicleState;
    private JPanel vehiclesCounty;
    private JPanel vehiclesCity;
    private JPanel vehicleModel;
    private JPanel vehicleMake;
    private JPanel vehicleRange;
    private DefaultTableModel vehicleStateTable;
    private DefaultTableModel vehiclesCountyTable;
    private DefaultTableModel vehiclesCityTable;
    private DefaultTableModel vehicleModelTable;
    private DefaultTableModel vehicleMakeTable;
    private DefaultTableModel vehicleRangeTable;

    public VehicleManagerBody(VehicleManagerView vehicleManagerView, CardLayout cardLayout) {
        this.vehicleManagerView = vehicleManagerView;
        this.setLayout(cardLayout);
        this.initJPanels();

    }

    private void initJPanels() {
        this.welcoming();
        this.vehicleState();
        this.vehiclesCounty();
        this.vehiclesCity();
        this.vehicleRange();
        this.vehicleModel();
        this.vehicleMake();
    }

    private void welcoming() {
        welcoming = new JPanel();
        welcoming.setBackground(GlobalView.BODY_BACKGROUND);
        welcoming.setLayout(null);
        this.add(welcoming, "prueba");
        welcoming.add(this.createHeader("Bienvenido"));
        String[] columnNames = {
                ""
        };
        this.addPruebaTable(welcoming, null);
    }

    private void vehicleState() {
        vehicleState = new JPanel();
        vehicleState.setBackground(GlobalView.BODY_BACKGROUND);
        vehicleState.setLayout(null);
        this.add(vehicleState, "vehicleState");
        vehicleState.add(this.createHeader("Registro de vehiculos por estado"));
        String[] columnNames = {
                "Estado", "Cantidad"
        };
        vehicleStateTable = new DefaultTableModel(columnNames, 0);
        this.addPruebaTable(vehicleState, vehicleStateTable);
    }

    private void vehiclesCounty() {
        vehiclesCounty = new JPanel();
        vehiclesCounty.setBackground(GlobalView.BODY_BACKGROUND);
        vehiclesCounty.setLayout(null);
        this.add(vehiclesCounty, "vehiclesCounty");
        vehiclesCounty.add(this.createHeader("Registro de vehiculos por condado"));
        String[] columnNames = {
                "Condado", "Cantidad"
        };
        vehiclesCountyTable = new DefaultTableModel(columnNames,0);
        this.addPruebaTable(vehiclesCounty, vehiclesCountyTable);
    }

    private void vehiclesCity() {
        vehiclesCity = new JPanel();
        vehiclesCity.setBackground(GlobalView.BODY_BACKGROUND);
        vehiclesCity.setLayout(null);
        this.add(vehiclesCity, "vehiclesCity");
        vehiclesCity.add(this.createHeader("Ciudad(es) con mas registros de vehiculos"));
        String[] columnNames = {
                "Ciudad(es)", "Cantidad"
        };
        vehiclesCityTable = new DefaultTableModel(columnNames,0);
        this.addPruebaTable(vehiclesCity, vehiclesCityTable);
    }

    private void vehicleModel() {
        vehicleModel = new JPanel();
        vehicleModel.setBackground(GlobalView.BODY_BACKGROUND);
        vehicleModel.setLayout(null);
        this.add(vehicleModel, "vehicleModel");
        vehicleModel.add(this.createHeader("Registro de vehiculos por modelo"));
        String[] columnNames = {
                "Modelo", "Cantidad"
        };
        vehicleModelTable = new DefaultTableModel(columnNames,0);
        this.addPruebaTable(vehicleModel, vehicleModelTable);
    }

    private void vehicleMake() {
        vehicleMake = new JPanel();
        vehicleMake.setBackground(GlobalView.BODY_BACKGROUND);
        vehicleMake.setLayout(null);
        this.add(vehicleMake, "vehicleMake");
        vehicleMake.add(this.createHeader("Registro de vehiculos por Fabricante"));
        String[] columnNames = {
                "Fabricante", "Cantidad"
        };
        vehicleMakeTable = new DefaultTableModel(columnNames,0);
        this.addPruebaTable(vehicleMake, vehicleMakeTable);
    }

    private void vehicleRange() {
        vehicleRange = new JPanel();
        vehicleRange.setBackground(GlobalView.BODY_BACKGROUND);
        vehicleRange.setLayout(null);
        this.add(vehicleRange, "vehicleRange");
        vehicleRange.add(this.createHeader("Registro de vehiculos por rango de elegibilidad"));
        String[] columnNames = {
                "Rango Electrico", "Cantidad"
        };
        vehicleRangeTable = new DefaultTableModel(columnNames,0);
        this.addPruebaTable(vehicleRange, vehicleRangeTable);
    }

    private JLabel createHeader(String tittle) {
        JLabel headerLabel = new JLabel(tittle);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        Dimension headerDimension = headerLabel.getPreferredSize();
        headerLabel.setBounds(245, 30, (int) headerDimension.getWidth(), (int) headerDimension.getHeight());
        return headerLabel;

    }

    private void addPruebaTable(JPanel prueba, DefaultTableModel vehicleTable) {
        JPanel tablePanel = new JPanel();
        tablePanel.setOpaque(false);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_COLOR));
        tablePanel.setBounds(15, 20, 630, 400);
        tablePanel.setLayout(null);

        tablePanel.add(this.createTable(vehicleTable));
        prueba.add(tablePanel);
    }

    private JScrollPane createTable(DefaultTableModel vehicleTable) {

        JTable pruebaTable = new JTable(vehicleTable);
        pruebaTable.setFillsViewportHeight(true);
        pruebaTable.getTableHeader().setReorderingAllowed(false);
        pruebaTable.getTableHeader().setResizingAllowed(false);
        pruebaTable.setDragEnabled(false);

        JScrollPane scrollPane = new JScrollPane(pruebaTable);
        scrollPane.setBounds(24, 40, 580, 350);
        return scrollPane;

    }

    public void createTableVec(Table t, DefaultTableModel vehicleTable) {
        Object[] tableData = { t.getAux(), t.getCan() };
        vehicleTable.addRow(tableData);
    }
}
