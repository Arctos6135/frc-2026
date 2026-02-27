package frc.robot.subsystems.shooter;

import org.littletonrobotics.junction.AutoLog;

public class ShooterIO {
    @AutoLog
    public static class ShooterInputs {
        public double current; // amps
        public double temperature; // celsius
        public double voltage; // % max voltage
        public double speed; // in rps
    }

    public void updateInputs(ShooterInputs inputs) {}

    public void setVoltage(double voltage) {}
}