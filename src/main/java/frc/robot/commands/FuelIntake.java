package frc.robot.commands;

import java.lang.ModuleLayer.Controller;

import edu.wpi.first.units.measure.Voltage;

public class FuelIntake {

    public double Voltage;

    FuelIntake(double Voltage){
        this.Voltage = 1;
        }
        
        public void setVoltage(double Voltage) {
            this.Voltage = 0;
        }
        
    }
