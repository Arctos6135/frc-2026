package frc.robot.commands;

import java.lang.ModuleLayer.Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj2.command.Command;
public class FuelIntake extends Command {

    public static void Intake(XboxController C, double Voltage){
        boolean T = C.getRightTrigger();
        if(T = true)
        {
            Voltage = 1;
        }
        else
        {
            Voltage = 0;
        } 
    }
}
