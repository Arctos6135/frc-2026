package frc.robot.subsystems.collector;

import org.littletonrobotics.junction.AutoLog;

public class CollectorIO {
    @AutoLog
    public static class CollectorInputs {
        public double velocity;
        public double position;
        public double temperature;
        public double current;
        public double voltage;
    }

    public void updateInputs(CollectorInputs inputs) {
    }

    public void setVoltage(double voltage) {
    }
}
