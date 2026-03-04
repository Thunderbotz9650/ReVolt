package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
  private final TalonFXS intakeMotorA = new TalonFXS(IntakeConstants.kIntakeMotorAId);
  private final TalonFXS intakeMotorB = new TalonFXS(IntakeConstants.kIntakeMotorBId);

  public IntakeSubsystem() {
    intakeMotorB.follow(intakeMotorA);
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