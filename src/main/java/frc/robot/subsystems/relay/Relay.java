package frc.robot.subsystems.relay;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RelayConstants;
import org.littletonrobotics.junction.Logger;

public class Relay extends SubsystemBase {
    private final RelayIO io;
    private final RelayInputsAutoLogged inputs = new RelayInputsAutoLogged();

    private final SimpleMotorFeedforward feedforward;

    private double targetVelocity;
    private double lastTargetVelocity;

    private final MedianFilter filter = new MedianFilter(RelayConstants.MEDIAN_FILTER_SIZE);
    private double medianCurrent;

    public Relay(RelayIO io) {
        this.io = io;
        this.feedforward = new SimpleMotorFeedforward(RelayConstants.kS, RelayConstants.kV, RelayConstants.kA);
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        // medianCurrent = filter.calculate(inputs.current);

        io.setVoltage(
                feedforward.calculate(targetVelocity, (targetVelocity - lastTargetVelocity) / 0.02));

        Logger.processInputs("Relay", inputs);
        lastTargetVelocity = targetVelocity;
    }

    /**
     * Get the maximum velocity between the two Relay motors.
     *
     * @return in meters of tread per second
     */
    public double getVelocity() {
        return inputs.velocity;
    }

    /**
     * Set the target rotational speed of the Relay motors.
     *
     * @param rps rotations per second.
     */
    public void setRPS(double rps) {
        lastTargetVelocity = targetVelocity;
        targetVelocity = rps;
    }

    /**
     * Set the target rotational speed of the Relay motors.
     *
     * @param rpm rotations per minute.
     */
    public void setRPM(double rpm) {
        setRPS(rpm / 60);
    }

    /**
     * Set the voltage of both Relay motors.
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
