package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  private final TalonFXS frontLeft = new TalonFXS(DriveConstants.kFrontLeftMotorId);
  private final TalonFXS rearLeft = new TalonFXS(DriveConstants.kRearLeftMotorId);
  private final TalonFXS frontRight = new TalonFXS(DriveConstants.kFrontRightMotorId);
  private final TalonFXS rearRight = new TalonFXS(DriveConstants.kRearRightMotorId);

  private final DifferentialDrive drive =
      new DifferentialDrive(this::setLeftOutput, this::setRightOutput);

  public DriveSubsystem() {}

  public void arcadeDrive(double forward, double rotation) {
    drive.arcadeDrive(
        MathUtil.applyDeadband(forward, ControllerConstants.kDriveDeadband),
        MathUtil.applyDeadband(rotation, ControllerConstants.kDriveDeadband));
  }

  public void stop() {
    setLeftOutput(0.0);
    setRightOutput(0.0);
    drive.stopMotor();
  }

  private void setLeftOutput(double output) {
    double signedOutput = DriveConstants.kLeftInverted ? -output : output;
    frontLeft.set(signedOutput);
    rearLeft.set(signedOutput);
  }

  private void setRightOutput(double output) {
    double signedOutput = DriveConstants.kRightInverted ? -output : output;
    frontRight.set(signedOutput);
    rearRight.set(signedOutput);
  }
}