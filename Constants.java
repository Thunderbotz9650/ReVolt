package frc.robot;

public final class Constants {
  private Constants() {}

  public static final class ControllerConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;
    public static final double kDriveDeadband = 0.08;

    private ControllerConstants() {}
  }

  public static final class DriveConstants {
    // Differential drive: 4 CIM motors, each on a Talon FX controller.
    public static final int kFrontLeftMotorId = 1;
    public static final int kRearLeftMotorId = 2;
    public static final int kFrontRightMotorId = 3;
    public static final int kRearRightMotorId = 4;

    public static final boolean kLeftInverted = false;
    public static final boolean kRightInverted = true;

    private DriveConstants() {}
  }

  public static final class IntakeConstants {
    public static final int kIntakeMotorAId = 5;
    public static final int kIntakeMotorBId = 6;

    public static final double kIntakeSpeed = 1.0;
    public static final double kOuttakeSpeed = -1.0;

    private IntakeConstants() {}
  }

  public static final class ShooterConstants {
    public static final int kShooterMotorAId = 7;
    public static final int kShooterMotorBId = 8;

    public static final double kShootSpeed = 1.0;
    public static final double kFeedSpeed = 1.0;

    private ShooterConstants() {}
  }
}