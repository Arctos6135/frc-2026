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

    /**
   * Set the target rotational speed of the intake.
   *
   * @param rps rotations per second.
   */
  public void setRPS(double rps) {
    this.rps = rps;
  }

  /**
   * Set the target rotational speed of the intake.
   *
   * @param rpm rotations per minute.
   */
  public void setRPM(double rpm) {
    setRPS(rpm / 60);
  }

  /**
   * Set the voltage of the intake motor.
   *
   * @param voltage voltage
   */
  public void setVoltage(double voltage) {
    io.setVoltage(voltage);
  }
}
