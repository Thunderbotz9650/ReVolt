package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
  private final TalonFXS shooterMotorA = new TalonFXS(ShooterConstants.kShooterMotorAId);
  private final TalonFXS shooterMotorB = new TalonFXS(ShooterConstants.kShooterMotorBId);

  public ShooterSubsystem() {
    shooterMotorB.follow(shooterMotorA);
  }

  public void shoot() {
    shooterMotorA.set(ShooterConstants.kShootSpeed);
  }

  public void feed() {
    shooterMotorA.set(ShooterConstants.kFeedSpeed);
  }

  public void stop() {
    shooterMotorA.stopMotor();
  }
}