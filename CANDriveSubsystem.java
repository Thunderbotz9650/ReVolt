package frc.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
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

    @SuppressWarnings("removal")
    public CANDriveSubsystem() {

        leftLeader = new CANSparkMax(1, MotorType.kBrushless);
        leftFollower = new CANSparkMax(2, MotorType.kBrushless);
        rightLeader = new CANSparkMax(3, MotorType.kBrushless);
        rightFollower = new CANSparkMax(4, MotorType.kBrushless);

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

    public Command exampleMethodCommand() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exampleMethodCommand'");
    }
}