package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.ControllerConstants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

  private final XboxController driverController =
      new XboxController(ControllerConstants.kDriverControllerPort);
  private final XboxController operatorController =
      new XboxController(ControllerConstants.kOperatorControllerPort);

  public RobotContainer() {
    configureDefaultCommands();
    configureButtonBindings();
  }

  private void configureDefaultCommands() {
    driveSubsystem.setDefaultCommand(
        new RunCommand(
            () ->
                driveSubsystem.arcadeDrive(
                    -driverController.getLeftY(),
                    driverController.getRightX()),
            driveSubsystem));
  }

  private void configureButtonBindings() {
    // Driver buttons
    new JoystickButton(driverController, XboxController.Button.kRightBumper.value)
        .whileTrue(new StartEndCommand(intakeSubsystem::intakeIn, intakeSubsystem::stop, intakeSubsystem));

    new JoystickButton(driverController, XboxController.Button.kLeftBumper.value)
        .whileTrue(new StartEndCommand(intakeSubsystem::intakeOut, intakeSubsystem::stop, intakeSubsystem));

    // Operator buttons
    new JoystickButton(operatorController, XboxController.Button.kY.value)
        .whileTrue(new StartEndCommand(shooterSubsystem::shoot, shooterSubsystem::stop, shooterSubsystem));

    new JoystickButton(operatorController, XboxController.Button.kA.value)
        .whileTrue(new StartEndCommand(shooterSubsystem::feed, shooterSubsystem::stop, shooterSubsystem));
  }
}