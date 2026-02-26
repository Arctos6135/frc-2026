package frc.robot.subsystems.drivetrain;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import swervelib.SwerveDrive;
import swervelib.parser.SwerveParser;
import java.io.File;
import frc.robot.constants.SwerveConstants;
import edu.wpi.first.math.Matrix;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.math.numbers.N3;
import org.ejml.simple.SimpleMatrix;

public class Drivetrain extends SubsystemBase {
    //Drivetrain details
    //frame perimetre is 26in by 28in
    //6.12:1 gear ratio
    //krakens for drive moters, neos for Steering
    //wheel radius: 1.75in
    //distance from module centre to robot centre: ~15.496in

    // Only use this if you need to DEBUG! Micah thinks doing TelemetryVerbosity.LOW
    // may have caused errors that crahsed the robot last year... 😭
    //SwerveDriveTelemetry.verbosity = TelemetryVerbosity.LOW;

  public final SwerveDrive swerveDrive;

  public Drivetrain(File directory) {
    try {
    this.swerveDrive = new SwerveParser(directory).createSwerveDrive(SwerveConstants.MAX_SPEED);
    } catch (Exception e) {
    throw new RuntimeException(e);
    }

    this.swerveDrive.setHeadingCorrection(false);
    this.swerveDrive.setCosineCompensator(true);
    this.swerveDrive.setVisionMeasurementStdDevs(
        new Matrix<N3, N1>(new SimpleMatrix(new double[][] {{0.00001}, {0.000001}, {0.0000001}})));

    this.swerveDrive.setMotorIdleMode(false);
  }

  @Override
  public void periodic() {

  }
}