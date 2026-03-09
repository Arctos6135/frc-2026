package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.intake.Intake;

public class FuelIntake extends Command {
    private Intake Intake;
    private Collector collector;
    private final XboxController operatorController;

    public FuelIntake(Intake Intake, Collector Collector, XboxController operatorController) {// add xbox controller
        this.Intake = Intake;
        this.collector = Collector;
        this.operatorController = operatorController;

        addRequirements(Intake);
    }

    public void execute() {
        double trigger = operatorController.getLeftTriggerAxis();
        if (trigger > 0.1) {
            Intake.setVoltage(12);
            collector.setVoltage(12);
        } else {
            Intake.setVoltage(0);
            collector.setVoltage(0);
        }
    }

    public void end(boolean interrupted) {
        Intake.setVoltage(0);
    }
}
