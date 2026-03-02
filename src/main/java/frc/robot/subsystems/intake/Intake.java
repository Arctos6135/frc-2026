package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private final IntakeIO io;

  private double rps;

  public Intake(IntakeIO io) {
    this.io = io;
  }

  public double getVelocity() {
  }

  public double getFilteredCurrent() {
    
  }

  public void setRPS(double rps) {
  }

  public void setRPM(double rpm) {
  }

  public void setVoltage(double voltage) {
  }
}
