package frc.robot.subsystems.shooter;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Shooter extends SubsystemBase{
    private final ShooterIO io;
    private final ShooterInputsAutoLogged inputs = new ShooterInputsAutoLogged();
    
    private final SimpleMotorFeedforward feedforward;

    public Shoot(ShooterIO io){
        this.io = io;
        this.feedforward new SimpleMotorFeedforward(); //need controls constants
    }
}