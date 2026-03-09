// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.drivetrain.TeleopDrive;
import frc.robot.commands.intake.FuelIntake;
import frc.robot.commands.shooter.Shoot;
import frc.robot.constants.ControllerConstants;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.collector.CollectorIOReal;
import frc.robot.subsystems.drivetrain.Drivetrain;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.intake.IntakeIOReal;
import frc.robot.subsystems.relay.Relay;
import frc.robot.subsystems.relay.RelayIOReal;
import frc.robot.subsystems.shooter.Shooter;
import frc.robot.subsystems.shooter.ShooterIOReal;

import java.io.File;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = new CommandXboxController(
      OperatorConstants.kDriverControllerPort);

  public final XboxController driverController = new XboxController(ControllerConstants.DRIVER_CONTROLLER);
  public final XboxController operatorController = new XboxController(ControllerConstants.OPERATOR_CONTROLLER);

  public final Drivetrain drivetrain;
  public final Shooter shooter;
  public final Relay relay;
  public final Collector collector;
  public final Intake intake;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    drivetrain = new Drivetrain(new File(Filesystem.getDeployDirectory(), "swerve"));
    shooter = new Shooter(new ShooterIOReal());
    relay = new Relay(new RelayIOReal());
    collector = new Collector(new CollectorIOReal());
    intake = new Intake(new IntakeIOReal());

    drivetrain.setDefaultCommand(new TeleopDrive(drivetrain, driverController));

    // This should automatically bind the shooter (check command execute)
    shooter.setDefaultCommand(new Shoot(shooter, relay, operatorController));

    // This should automatically bind the intake (check command execute)
    intake.setDefaultCommand(new FuelIntake(intake, collector, operatorController));

    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
