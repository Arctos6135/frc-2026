package frc.robot.subsystems.shooter;

import org.littletonrobotics.junction.AutoLog;

public class ShooterIO {
  @AutoLog
  public static class ShooterInputs {
    public double velocity;
    public double position;
    public double temperature;
    public double current;
    public double voltage;
  }

  public void updateInputs(ShooterInputs inputs) {}

  public void setVoltage(double voltage) {}
}
