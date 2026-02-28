package frc.robot.subsystems.Hopper;

public class IntakeIO {
    
  public static class IntakeInputs {
    public double current; // amps
    public double temperature; // celsius
    public double voltage; // % max voltage
    public double speed; // in rps
  }

  public void updateInputs(IntakeInputs inputs) {}

  public void setVoltage(double voltage) {}
}