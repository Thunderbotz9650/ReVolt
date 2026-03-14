package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;
import com.ctre.phoenix6.hardware.TalonFXS;


public class ShooterSubsystem extends SubsystemBase {
  private final TalonFXS shooterMotorA = new TalonFXS(6);

  public ShooterSubsystem() {
    // shooterMotorB.follow(shooterMotorA);
  }

  public void shoot() {
    shooterMotorA.set(ShooterConstants.kShootSpeed);
  }

  public void feed() {
    shooterMotorA.set(-ShooterConstants.kFeedSpeed);
  }

  public void stop() {
    shooterMotorA.stopMotor();
  }
}