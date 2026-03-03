package frc.robot.subsystems.intake;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import frc.robot.constants.CANConstants;

public class IntakeIOReal extends IntakeIO {
  private final SparkMax intakeMotor = new SparkMax(CANConstants.INTAKE_MOTOR, MotorType.kBrushless);

  private final RelativeEncoder intakeMotorEncoder;

  public IntakeIOReal() {} // TODO
}
