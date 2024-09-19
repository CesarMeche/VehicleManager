package co.edu.uptc.views.vehicleManegerMainFrame;

import java.awt.Dimension;

import javax.swing.JPanel;

import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;
import javax.swing.BorderFactory;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class VehicleManagerAside extends JPanel {
    private VehicleManagerView vehicleManagerView;
    private JPanel geographicalAnalysisBtnsPanel;
    private JPanel vehicleAnalysisBtnsPanel;

    public VehicleManagerAside(VehicleManagerView vehicleManagerView, CardLayout cardLayout) {
        this.vehicleManagerView = vehicleManagerView;
        this.setLayout(cardLayout);
        this.initGeographicalAnalysisBtnsPanel();
        this.initVehicleAnalysisPanel();
    }

    private void initGeographicalAnalysisBtnsPanel() {
        geographicalAnalysisBtnsPanel = new JPanel();
        geographicalAnalysisBtnsPanel.setBackground(GlobalView.ASIDE_BACKGROUND);
        geographicalAnalysisBtnsPanel.setPreferredSize(new Dimension(225, 0));
        geographicalAnalysisBtnsPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, GlobalView.BORDER_COLOR));
        geographicalAnalysisBtnsPanel.setLayout(null);
        this.add(geographicalAnalysisBtnsPanel, "GeographicalAnalysisBtns");
        this.createRecordsByStateBtn();
        this.createRecordsByCountyBtn();
        this.createRecordsByCityBtn();
    }

    private void initVehicleAnalysisPanel() {
        vehicleAnalysisBtnsPanel = new JPanel();
        vehicleAnalysisBtnsPanel.setBackground(GlobalView.ASIDE_BACKGROUND);
        vehicleAnalysisBtnsPanel.setPreferredSize(new Dimension(225, 0));
        vehicleAnalysisBtnsPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, GlobalView.BORDER_COLOR));
        vehicleAnalysisBtnsPanel.setLayout(null);
        this.add(vehicleAnalysisBtnsPanel, "VehicleAnalysisBtns");
        this.createVehiclesByModelBtn();
        this.createVehiclesByManufacturerBtn();
        this.createVehiclesByElecticRangeBtn();
    }

    private void createRecordsByStateBtn() {
        RoundedButton recordsByStateBtn = new RoundedButton(
                "<html><div style='text-align: center;'>Registros<br>Por Estado</div></html>", 20);
        recordsByStateBtn.setBounds(37, 50, 150, 80);
        recordsByStateBtn.setBackground(GlobalView.ASIDE_BTN_BACKGROUD);
        recordsByStateBtn.setForeground(GlobalView.ASIDE_BTN_TEXT_BACKGROUD);
        recordsByStateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                vehicleManagerView.getBodyCardLayout().show(vehicleManagerView.getVehicleManagerBody(), "vehicleState");
            }
        });
        geographicalAnalysisBtnsPanel.add(recordsByStateBtn);
    }

    private void createRecordsByCountyBtn() {
        RoundedButton recordsByCountyBtn = new RoundedButton(
                "<html><div style='text-align: center;'>Registros<br>Por Condado</html>", 20);
        recordsByCountyBtn.setBounds(37, 178, 150, 80);
        recordsByCountyBtn.setBackground(GlobalView.ASIDE_BTN_BACKGROUD);
        recordsByCountyBtn.setForeground(GlobalView.ASIDE_BTN_TEXT_BACKGROUD);
        recordsByCountyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vehicleManagerView.getBodyCardLayout().show(vehicleManagerView.getVehicleManagerBody(), "vehiclesCounty");
            }
        });
        geographicalAnalysisBtnsPanel.add(recordsByCountyBtn);
    }

    private void createRecordsByCityBtn() {
        RoundedButton recordsByCityBtn = new RoundedButton(
                "<html><div style='text-align: center;'>Ciudad con<br>mas registros</html>", 20);
        recordsByCityBtn.setBounds(37, 310, 150, 80);
        recordsByCityBtn.setBackground(GlobalView.ASIDE_BTN_BACKGROUD);
        recordsByCityBtn.setForeground(GlobalView.ASIDE_BTN_TEXT_BACKGROUD);
        recordsByCityBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               vehicleManagerView.getBodyCardLayout().show(vehicleManagerView.getVehicleManagerBody(), "vehiclesCity");
            }
        });
        geographicalAnalysisBtnsPanel.add(recordsByCityBtn);
    }

    private void createVehiclesByModelBtn() {
        RoundedButton vehiclesByModelBtn = new RoundedButton(
                "<html><div style='text-align: center;'>Vehiculos Por<br>Por Modelo</html>", 20);
        vehiclesByModelBtn.setBounds(37, 50, 150, 80);
        vehiclesByModelBtn.setBackground(GlobalView.ASIDE_BTN_BACKGROUD);
        vehiclesByModelBtn.setForeground(GlobalView.ASIDE_BTN_TEXT_BACKGROUD);
        vehiclesByModelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vehicleManagerView.getBodyCardLayout().show(vehicleManagerView.getVehicleManagerBody(), "vehicleModel");
            }
        });
        vehicleAnalysisBtnsPanel.add(vehiclesByModelBtn);
    }

    private void createVehiclesByManufacturerBtn() {
        RoundedButton vehiclesByManufacturerBtn = new RoundedButton(
                "<html><div style='text-align: center;'>Vehiculos Por<br>Fabricante</html>", 20);
        vehiclesByManufacturerBtn.setBounds(37, 178, 150, 80);
        vehiclesByManufacturerBtn.setBackground(GlobalView.ASIDE_BTN_BACKGROUD);
        vehiclesByManufacturerBtn.setForeground(GlobalView.ASIDE_BTN_TEXT_BACKGROUD);
        vehiclesByManufacturerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vehicleManagerView.getBodyCardLayout().show(vehicleManagerView.getVehicleManagerBody(), "vehicleMake");
            }
        });
        vehicleAnalysisBtnsPanel.add(vehiclesByManufacturerBtn);
    }

    private void createVehiclesByElecticRangeBtn() {
        RoundedButton vehiclesByElecticRangeBtn = new RoundedButton(
                "<html><div style='text-align: center;'>Vehiculos Por<br>Rango<br>Energetico</html>", 20);
        vehiclesByElecticRangeBtn.setBounds(37, 310, 150, 80);
        vehiclesByElecticRangeBtn.setBackground(GlobalView.ASIDE_BTN_BACKGROUD);
        vehiclesByElecticRangeBtn.setForeground(GlobalView.ASIDE_BTN_TEXT_BACKGROUD);
        vehiclesByElecticRangeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vehicleManagerView.getBodyCardLayout().show(vehicleManagerView.getVehicleManagerBody(), "vehicleRange");
            }
        });
        vehicleAnalysisBtnsPanel.add(vehiclesByElecticRangeBtn);
    }

}
