package frc.robot.subsystems.shooter;

import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkParameters;

import frc.robot.constants.CANConstants;
import frc.robot.constants.ShooterConstants;

public class ShooterIOReal extends ShooterIO {
  private final SparkMax rightMotor;
  private final SparkMax leftMotor;

  private final RelativeEncoder rightEncoder;
  private final RelativeEncoder leftEncoder;

  public ShooterIOReal() {
    rightMotor = new SparkMax(CANConstants.SHOOTER_LEFT, MotorType.kBrushless);
    leftMotor = new SparkMax(CANConstants.SHOOTER_RIGHT, MotorType.kBrushless);

    SparkMaxConfig rightConfig = new SparkMaxConfig();
    rightConfig.smartCurrentLimit(ShooterConstants.CURRENT_LIMIT);
    rightConfig.idleMode(IdleMode.kBrake);
    rightConfig.inverted(true);

    rightConfig.encoder.positionConversionFactor(ShooterConstants.POSITION_CONVERSION_FACTOR);
    rightConfig.encoder.velocityConversionFactor(ShooterConstants.VELOCITY_CONVERSION_FACTOR);

    rightMotor.configure(rightConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    SparkMaxConfig leftConfig = new SparkMaxConfig();
    leftConfig.follow(rightMotor, true);
    leftConfig.smartCurrentLimit(ShooterConstants.CURRENT_LIMIT);
    leftConfig.idleMode(IdleMode.kBrake);

    leftConfig.encoder.positionConversionFactor(ShooterConstants.POSITION_CONVERSION_FACTOR);
    leftConfig.encoder.velocityConversionFactor(ShooterConstants.VELOCITY_CONVERSION_FACTOR);


    leftMotor.configure(leftConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    this.rightEncoder = rightMotor.getEncoder();
    this.leftEncoder = leftMotor.getEncoder();
  }

  @Override
  public void setVoltage(double voltage) {
    rightMotor.setVoltage(voltage);
  }

  @Override
  public void updateInputs(ShooterInputs inputs) {
    inputs.velocity = rightEncoder.getVelocity();
    inputs.position = rightEncoder.getPosition();
    inputs.current = rightMotor.getOutputCurrent();
    inputs.temperature = rightMotor.getMotorTemperature();
    inputs.voltage = rightMotor.getBusVoltage() * rightMotor.getAppliedOutput();
  }
}
