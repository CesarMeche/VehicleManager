package co.edu.uptc.pogos;



import co.edu.uptc.dynamic.SimpleList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private String VIN;
    private String County;
    private String City;
    private String State;
    private String PostalCode;
    private String ModelYear;
    private String Make;
    private String Model;
    private String ElectricVehicleType;
    private String AlternativeFuelEligibility;
    private String ElectricRange;
    private String BaseMSRP;
    private String LegislativeDistrict;
    private String DOLVehicleID;
    private String VehicleLocation;
    private String ElectricUtility;

    public Vehicle(SimpleList<String> att) {

        this.VIN = att.get(0);
        this.County = att.get(1);
        this.City = att.get(2);
        this.State = att.get(3);
        this.PostalCode = att.get(4);
        this.ModelYear = att.get(5);
        this.Make = att.get(6);
        this.Model = att.get(7);
        this.ElectricVehicleType = att.get(8);
        this.AlternativeFuelEligibility = att.get(9);
        this.ElectricRange = att.get(10);
        this.BaseMSRP = att.get(11);
        this.LegislativeDistrict = att.get(12);
        this.DOLVehicleID = att.get(13);
        this.VehicleLocation = att.get(14);
        this.ElectricUtility = att.get(15);
    }
}

