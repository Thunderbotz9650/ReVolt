package frc.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CANDriveSubsystem extends SubsystemBase {

    private final WPI_TalonSRX leftLeader;
    private final WPI_TalonSRX leftFollower;
    private final WPI_TalonSRX rightLeader;
    private final WPI_TalonSRX rightFollower;

    private final MotorControllerGroup leftGroup;
    private final MotorControllerGroup rightGroup;

    private final DifferentialDrive drive;

    @SuppressWarnings("removal")
    public CANDriveSubsystem() {

        leftLeader = new WPI_TalonSRX(1);
        leftFollower = new WPI_TalonSRX(2);
        rightLeader = new WPI_TalonSRX(3);
        rightFollower = new WPI_TalonSRX(4);

        leftGroup = new MotorControllerGroup(leftLeader, leftFollower);
        rightGroup = new MotorControllerGroup(rightLeader, rightFollower);

        rightGroup.setInverted(true);

        drive = new DifferentialDrive(leftGroup, rightGroup);
    }

    public void arcadeDrive(double forward, double rotation) {
        drive.arcadeDrive(forward, rotation);
    }

    public void stop() {
        drive.stopMotor();
    }
}