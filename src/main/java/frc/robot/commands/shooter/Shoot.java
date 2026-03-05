package frc.robot.commands.shooter;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.shooter.Shooter;

public class Shoot extends Command {
    private Shooter shooter;
    private Relay relay;
    private Collector collector;
    private final XboxController operatorController;

    public Shoot(Shooter shooter, XboxController operatorController) {//add xbox controller
        this.shooter = shooter;
        this.operatorController = operatorController;

        addRequirements(shooter);
    }

    public void execute() {
        Shooter.setVoltage(/*voltage constant for shooter*/ * (operatorController.getRightTriggerAxis()));
        Relay.setVoltage(/*voltage constant for relay*/ * (operatorController.getRightTriggerAxis()));
        Collector.setVoltage(/*voltage constant for collector*/ * (operatorController.getRightTriggerAxis()));
    }

    public void end(boolean interrupted) {
        Shooter.setVoltage(0);
    }
    
}
