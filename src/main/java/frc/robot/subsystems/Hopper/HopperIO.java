package frc.robot.subsystems.Hopper;

public class HopperIO {
    public static class HopperInputs {
        public double current; // amps
        public double temperature; // celsius
        public double voltage; // % max voltage
        public double speed; // in rps
  }

  public void updateInputs(HopperInputs inputs) {}

  public void setVoltage(double voltage) {}
}