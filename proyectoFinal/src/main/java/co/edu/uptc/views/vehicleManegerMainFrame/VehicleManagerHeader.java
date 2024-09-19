package co.edu.uptc.views.vehicleManegerMainFrame;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleManagerHeader extends JPanel{
    VehicleManagerView vehicleManagerView;

    public VehicleManagerHeader(VehicleManagerView vehicleManagerView){
        this.vehicleManagerView=vehicleManagerView;
        this.initPanel();
        this.addTitleLabel();
        this.createGeographicalAnalysisBtn();
        this.createVehicleAnalysisBtn();
    }

     private void initPanel(){
        this.setBackground(GlobalView.HEADER_BACKGROUND);
        this.setForeground(GlobalView.HEADER_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(0,125));
        this.setBorder(BorderFactory.createMatteBorder(0,0,1,0, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

     private void addTitleLabel(){
        JLabel titleLabel = new JLabel("<html><div style='text-align: center;'>Administrador de <br>Vehiculos Electricos</html>");
        titleLabel.setFont( new Font("Arial", 1, 24));;
        titleLabel.setForeground(GlobalView.HEADER_TEXT_BACKGROUND);
        Dimension titleDimension = titleLabel.getPreferredSize();
        titleLabel.setBounds(40,32, (int)titleDimension.getWidth(), (int)titleDimension.getHeight());
        this.add(titleLabel);
    }
    private void createGeographicalAnalysisBtn(){
        RoundedButton geograficalAnalysisBtn = new RoundedButton("<html><div style='text-align: center;'>Analisis<br>Geograficos</html>", 20);
        geograficalAnalysisBtn.setBounds(375, 25, 150, 80);
        geograficalAnalysisBtn.setBackground(GlobalView.BTN_BACKGROUND);
        geograficalAnalysisBtn.setForeground(GlobalView.BTN_TEXT_BACKGROUND);
        geograficalAnalysisBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //vehicleManagerView.getBodyCardLayout().show(vehicleManagerView.getVehicleManagerBody(), "GeographicalAnalysis");
                vehicleManagerView.getAsideCardLayout().show(vehicleManagerView.getVehicleManagerAside(), "GeographicalAnalysisBtns");
            }
        });
        this.add(geograficalAnalysisBtn);
    }
    private void createVehicleAnalysisBtn(){
        RoundedButton vehicleAnalysisBtn = new RoundedButton("<html><div style='text-align: center;'>Analisis por<br>Vehiculo</html>", 20);
        vehicleAnalysisBtn.setBounds(630, 25, 150, 80);
        vehicleAnalysisBtn.setBackground(GlobalView.BTN_BACKGROUND);
        vehicleAnalysisBtn.setForeground(GlobalView.BTN_TEXT_BACKGROUND);
        vehicleAnalysisBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //vehicleManagerView.getBodyCardLayout().show(vehicleManagerView.getVehicleManagerBody(), "VehicleAnalysis");
                vehicleManagerView.getAsideCardLayout().show(vehicleManagerView.getVehicleManagerAside(), "VehicleAnalysisBtns");
            }
        });
        this.add(vehicleAnalysisBtn);
    }
}
