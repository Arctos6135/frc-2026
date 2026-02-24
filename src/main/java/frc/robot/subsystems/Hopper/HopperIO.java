package frc.robot.subsystems.Hopper;

public class HopperIO {
    //I was going to program this but I have had to change to the drivetrain -Thomas
    public static class HopperInputs {
        public double current; // amps
        public double temperature; // celsius
        public double voltage; // % max voltage
        public double speed; // in rps
  }

  public void updateInputs(HopperInputs inputs) {}

  public void setVoltage(double voltage) {}
}