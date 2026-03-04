package frc.robot.commands.shooter;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.shooter.Shooter;

public class Shoot extends Command {
    private Shooter shooter;
    private final XboxController operatorController

    public Shoot(Shooter shooter) {//add xbox controller
    this.shooter = shooter;

    addRequirements(shooter);
    }

    public void execute () {

    }

    public void end () {
        
    }
    
}
