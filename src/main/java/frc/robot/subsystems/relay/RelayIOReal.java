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
    private final SparkMax indexerMotor;
    private final RelativeEncoder indexerEncoder;

    public RelayIOReal() {
        indexerMotor = new SparkMax(CANConstants.INDEXER, MotorType.kBrushless);

        SparkMaxConfig indexerConfig = new SparkMaxConfig();
        indexerConfig.smartCurrentLimit(RelayConstants.CURRENT_LIMIT);
        indexerConfig.idleMode(IdleMode.kBrake);
        indexerConfig.inverted(true);

        indexerConfig.encoder.positionConversionFactor(RelayConstants.POSITION_CONVERSION_FACTOR);
        indexerConfig.encoder.velocityConversionFactor(RelayConstants.VELOCITY_CONVERSION_FACTOR);

        indexerMotor.configure(indexerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        this.indexerEncoder = indexerMotor.getEncoder();
    }

    @Override
    public void setVoltage(double voltage) {
        indexerMotor.setVoltage(voltage);
    }

    @Override
    public void updateInputs(RelayInputs inputs) {
        inputs.velocity = indexerEncoder.getVelocity();
        inputs.position = indexerEncoder.getPosition();
        inputs.current = indexerMotor.getOutputCurrent();
        inputs.temperature = indexerMotor.getMotorTemperature();
        inputs.voltage = indexerMotor.getBusVoltage() * indexerMotor.getAppliedOutput();
    }
}
