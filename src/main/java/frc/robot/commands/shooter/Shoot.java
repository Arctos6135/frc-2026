package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.relay.Relay;
import frc.robot.subsystems.shooter.Shooter;

public class Shoot extends Command {

    private Shooter shooter;
    private Relay relay;
    private final XboxController operatorController;

    public Shoot(Shooter shooter, Relay relay, XboxController operatorController) {// add xbox controller
        this.shooter = shooter;
        this.relay = relay;
        this.operatorController = operatorController;

        addRequirements(shooter, relay);
    }

    public void execute() {
        double trigger = operatorController.getRightTriggerAxis();
        if (trigger > 0.1) {
            shooter.setVoltage(12);
            relay.setVoltage(12);
        } else {
            shooter.setVoltage(0);
            relay.setVoltage(0);
        }
    }

    public void end(boolean interrupted) {
        shooter.setVoltage(0);
        relay.setVoltage(0);
    }
}
