// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Autos;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.RunCommand;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  @SuppressWarnings("unused")
  private static final int OPERATOR_CONTROLLER_PORT = 2;
    private static final int DRIVER_CONTROLLER_PORT = 1;
      // The robot's subsystems and commands are defined here...
      private final CANDriveSubsystem m_CANDriveSubsystem = new CANDriveSubsystem();
      private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
    
    //Driver controller
      private final CommandXboxController drivercontroller = new CommandXboxController(DRIVER_CONTROLLER_PORT);
// the auto chooser
private final SendableChooser<Command> autochooser = new SendableChooser<>();

public RobotContainer() {
  // Configure the trigger bindings
  configureBindings();
  // Set default autonomous option
  autochooser.setDefaultOption("Autonomous", Autos.exampleAuto(m_CANDriveSubsystem, m_exampleSubsystem));
}

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
  
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    drivercontroller.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }
}
driveSubsystem.setDefaultCommand(
    new RunCommand(
        () -> driveSubsystem.arcadeDrive(
            -driverController.getLeftY(),
            driverController.getRightX()
        ),
        driveSubsystem
    )
);
