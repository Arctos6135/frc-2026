package frc.robot.commands.shooter;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.relay.Relay;
import frc.robot.subsystems.shooter.Shooter;

public class Shoot extends Command {
  
    private Shooter shooter;
    private final XboxController operatorController;

    public Shoot(Shooter shooter, XboxController operatorController) {//add xbox controller
        this.shooter = shooter;
        this.operatorController = operatorController;

        addRequirements(shooter);
    }

    public void execute() {
        double trigger = operatorController.getLeftTriggerAxis();
        if (trigger > 0.1) {
            shooter.setVoltage(12);
        } else {
            shooter.setVoltage(0);
        }
    }

    public void end(boolean interrupted) {
        shooter.setVoltage(0);
    }
}
