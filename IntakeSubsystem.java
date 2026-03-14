package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import com.ctre.phoenix6.hardware.TalonFXS;


public class IntakeSubsystem extends SubsystemBase {
  private final TalonFXS intakeMotorA = new TalonFXS(2);//id 2

  public IntakeSubsystem() {
    // intakeMotorB.follow(intakeMotorA);
  }

  public void intakeIn() {
    intakeMotorA.set(IntakeConstants.kIntakeSpeed);
  }

  public void intakeOut() {
    intakeMotorA.set(IntakeConstants.kOuttakeSpeed);
  }

  public void stop() {
    intakeMotorA.stopMotor();
  }
}