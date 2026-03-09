package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.ShooterConstants;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.drivetrain.Drivetrain;
import frc.robot.subsystems.relay.Relay;
import frc.robot.subsystems.shooter.Shooter;

public class ShootToHub extends Shoot {

    private Shooter shooter;
    private Relay relay;
    private final XboxController operatorController;

    public ShootToHub(Shooter shooter, Relay relay, XboxController operatorController) {// add xbox controller
        super(shooter, relay, operatorController);
        this.shooter = shooter;
        this.relay = relay;
        this.operatorController = operatorController;

        addRequirements(shooter, relay);
    }

    public void execute() {
        double trigger = operatorController.getRightTriggerAxis();
        double distance = -1;
        if (trigger > 0.1) {
            distance = Math.root(Math.pow(RobotXFromHub,2)+Math.pow(RobotYFromHub,2)) - ShooterConstants.SHOOTER_DISTANCE_GYRO;//fake variables ROBOTXFROMHUB and ROBOTYFROMHUB, sub in later
            shooter.setVoltage(distance*ShooterConstants.DISTANCE_SHOOTER_POWER_CONVERSION);
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
