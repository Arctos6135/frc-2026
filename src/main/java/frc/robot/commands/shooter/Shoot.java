package frc.robot.commands.shooter;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.shooter.Shooter;

public class Shoot extends Command {
    private Shooter shooter;
    private Relay relay;
    private Collector collector;
    private final XboxController operatorController;
    public static final double[] SHOOTER_VOLTAGES = {-1, -1, -1};//insert constants here, move to constants folder
    //for example, position 0: shooter motor, position 1: relay, position 2: collector, change however you like

    public Shoot(Shooter shooter, XboxController operatorController) {//add xbox controller
        this.shooter = shooter;
        this.operatorController = operatorController;

        addRequirements(shooter);
    }

    public void execute() {
        double trigger = operatorController.getLeftTriggerAxis();
        if (trigger > 0.1) {

            shooter.setVoltages(SHOOTER_VOLTAGES);
            //NOT setVoltage!!!! Once Shooter class is done, make it get each value and assign it to the according motor
            /*public void setVoltages(double[] volts) {
            motor1.setVoltage(volts[0]);
            motor2.setVoltage(volts[1]);
            motor3.setVoltage(volts[2]);
            } 
             */
        } else {
            shooter.end(true);
        }
        
    }

    public void end(boolean interrupted) {
        Shooter.setVoltage(0);
    }
    
}
