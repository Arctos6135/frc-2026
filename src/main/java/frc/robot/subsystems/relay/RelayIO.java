package frc.robot.subsystems.relay;

import org.littletonrobotics.junction.AutoLog;

public class RelayIO {
    @AutoLog
    public static class RelayInputs {
        public double velocity;
        public double position;
        public double temperature;
        public double current;
        public double voltage;
    }

    public void updateInputs(RelayInputs inputs) {
    }

    public void setVoltage(double voltage) {
    }
}
