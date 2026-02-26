package frc.robot.subsystems.shooter;

public class ShooterIO {
    @Autolog
    public static class HopperInputs {
        public double current; // amps
        public double temperature; // celsius
        public double voltage; // % max voltage
        public double speed; // in rps
    }

    public void updateInputs(ShooterInputs inputs) {}

    public void setVoltage(double voltage) {}
}