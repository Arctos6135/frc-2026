package frc.robot.subsystems.intake;

import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.constants.CANConstants;
import frc.robot.constants.IntakeConstants;

public class IntakeIOReal extends IntakeIO {
  private final SparkMax leftMotor = new SparkMax(CANConstants.INTAKE_RIGHT, MotorType.kBrushless);
  private final SparkMax rightMotor = new SparkMax(CANConstants.INTAKE_LEFT, MotorType.kBrushless);
  
  private final RelativeEncoder leftEncoder;
  private final RelativeEncoder rightEncoder;

  public IntakeIOReal() {
    SparkMaxConfig rightConfig = new SparkMaxConfig();
    rightConfig
      .smartCurrentLimit(IntakeConstants.CURRENT_LIMIT)
      .inverted(false)
      .idleMode(IdleMode.kBrake);

    rightConfig
      .encoder
      .positionConversionFactor(IntakeConstants.POSITION_CONVERSION_FACTOR)
      .velocityConversionFactor(IntakeConstants.VELOCITY_CONVERSION_FACTOR);

    rightMotor.configure(rightConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
    this.rightEncoder = rightMotor.getEncoder();

    SparkMaxConfig leftConfig = new SparkMaxConfig();
    leftConfig
      .follow(rightMotor, true)
      .smartCurrentLimit(IntakeConstants.CURRENT_LIMIT)
      .idleMode(IdleMode.kBrake);

    leftConfig
      .encoder
      .positionConversionFactor(IntakeConstants.POSITION_CONVERSION_FACTOR)
      .velocityConversionFactor(IntakeConstants.VELOCITY_CONVERSION_FACTOR);

    leftMotor.configure(leftConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
    this.leftEncoder = leftMotor.getEncoder();
  }

  @Override
  public void setVoltage(double voltage) {
    // leftMotor.setVoltage(voltage);
    rightMotor.setVoltage(voltage);
  }

  @Override
  public void updateInputs(IntakeInputs inputs) {
    inputs.current = rightMotor.getOutputCurrent();
    inputs.temperature = rightMotor.getMotorTemperature();
    inputs.voltage = rightMotor.getBusVoltage() * rightMotor.getAppliedOutput();
    inputs.speed = rightEncoder.getVelocity();
  }
}
