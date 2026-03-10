package frc.robot.subsystems.relay;

import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkParameters;

import frc.robot.constants.CANConstants;
import frc.robot.constants.RelayConstants;

public class RelayIOReal extends RelayIO {
    private final SparkMax relayMotor;
    private final RelativeEncoder relayEncoder;

    public RelayIOReal() {
        relayMotor = new SparkMax(CANConstants.RELAY, MotorType.kBrushless);

        SparkMaxConfig relayConfig = new SparkMaxConfig();
        relayConfig.smartCurrentLimit(RelayConstants.CURRENT_LIMIT);
        relayConfig.idleMode(IdleMode.kBrake);
        relayConfig.inverted(true);

        relayConfig.encoder.positionConversionFactor(RelayConstants.POSITION_CONVERSION_FACTOR);
        relayConfig.encoder.velocityConversionFactor(RelayConstants.VELOCITY_CONVERSION_FACTOR);

        relayMotor.configure(relayConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        this.relayEncoder = relayMotor.getEncoder();
    }

    @Override
    public void setVoltage(double voltage) {
        relayMotor.setVoltage(voltage);
    }

    @Override
    public void updateInputs(RelayInputs inputs) {
        inputs.velocity = relayEncoder.getVelocity();
        inputs.position = relayEncoder.getPosition();
        inputs.current = relayMotor.getOutputCurrent();
        inputs.temperature = relayMotor.getMotorTemperature();
        inputs.voltage = relayMotor.getBusVoltage() * relayMotor.getAppliedOutput();
    }
}
