package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.intake.Intake;

public class FuelIntake extends Command {
    private Intake intake;
    private Collector collector;
    private final XboxController operatorController;

    public FuelIntake(Intake Intake, Collector collector, XboxController operatorController) {// add xbox controller
        this.intake = Intake;
        this.collector = collector;
        this.operatorController = operatorController;

        addRequirements(Intake, collector);
    }

    public void execute() {
        double trigger = operatorController.getLeftTriggerAxis();

        if (trigger > 0.1) {
            intake.setVoltage(12);
            collector.setVoltage(12);
        } else {
            intake.setVoltage(0);
            collector.setVoltage(0);
        }
    }

    public void end(boolean interrupted) {
        intake.setVoltage(0);
        collector.setVoltage(0);
    }
}
