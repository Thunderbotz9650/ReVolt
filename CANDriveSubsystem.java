package frc.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CANDriveSubsystem extends SubsystemBase {

    private final CANSparkMax leftLeader;
    private final CANSparkMax leftFollower;
    private final CANSparkMax rightLeader;
    private final CANSparkMax rightFollower;

    private final MotorControllerGroup leftGroup;
    private final MotorControllerGroup rightGroup;

    private final DifferentialDrive drive;

        leftLeader = new CimMotorController(1, MotorType.kBrush);
        leftFollower = new CimMotorController(2, MotorType.kBrush);
        rightLeader = new CimMotorController(3, MotorType.kBrush);
        rightFollower = new CimMotorController(4, MotorType.kBrush);

        leftGroup = new MotorControllerGroup(leftLeader, leftFollower);
        rightGroup = new MotorControllerGroup(rightLeader, rightFollower);

        rightGroup.setInverted(true); // Most drivetrains need one side inverted

        drive = new DifferentialDrive(leftGroup, rightGroup);
    }

    public void arcadeDrive(double xSpeed, double zRotation) {
        drive.arcadeDrive(xSpeed, zRotation);
    }

    public void stop() {
        drive.stopMotor();
    }

	public Command exampleMethodCommand() {

		throw new UnsupportedOperationException("Unimplemented method 'exampleMethodCommand'");
	}
}