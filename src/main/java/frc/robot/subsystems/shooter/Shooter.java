package frc.robot.subsystems.shooter;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.ShooterConstants;
import org.littletonrobotics.junction.Logger;

public class Shooter extends SubsystemBase {
  private final ShooterIO io;
  private final ShooterInputsAutoLogged inputs = new ShooterInputsAutoLogged();

  private final SimpleMotorFeedforward feedforward;

  private double targetVelocity;
  private double lastTargetVelocity;

  private final MedianFilter filter = new MedianFilter(ShooterConstants.MEDIAN_FILTER_SIZE);
  private double medianCurrent;

  public Shooter(ShooterIO io) {
    this.io = io;
    this.feedforward = new SimpleMotorFeedforward(ShooterConstants.kS, 0.15398061338, 0.03178134435);
  }

  @Override
  public void periodic() {
    io.updateInputs(inputs);
    // medianCurrent = filter.calculate(inputs.current);

    io.setVoltage(
        feedforward.calculate(targetVelocity, (targetVelocity - lastTargetVelocity) / 0.02));

    Logger.processInputs("Shooter", inputs);
    lastTargetVelocity = targetVelocity;
  }

  /**
   * Get the maximum velocity between the two Shooter motors.
   *
   * @return in meters of tread per second
   */
  public double getVelocity() {
    return inputs.velocity;
  }

  /**
   * Set the target rotational speed of the Shooter motors.
   *
   * @param rps rotations per second.
   */
  public void setRPS(double rps) {
    lastTargetVelocity = targetVelocity;
    targetVelocity = rps;
  }

  /**
   * Set the target rotational speed of the Shooter motors.
   *
   * @param rpm rotations per minute.
   */
  public void setRPM(double rpm) {
    setRPS(rpm / 60);
  }

  /**
   * Set the voltage of both Shooter motors.
   *
   * @param voltage voltage
   */
  public void setVoltage(double voltage) {
    io.setVoltage(voltage);
  }

  /** Get the filtered current. */
  public double getFilteredCurrent() {
    return medianCurrent;
  }
}