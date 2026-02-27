package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CANFuelSubsystem extends SubsystemBase {

    private final MotorController intakeLauncherRoller;
    private final MotorController feederRoller;

    private double lastIntakeLauncherOutput = 0.0;
    private double lastFeederOutput = 0.0;

    public CANFuelSubsystem(MotorController intakeLauncherRoller,
                            MotorController feederRoller) {
        this.intakeLauncherRoller = intakeLauncherRoller;
        this.feederRoller = feederRoller;
    }

    private double clamp(double value) {
        return Math.max(-1.0, Math.min(1.0, value));
    }

    public void setIntakeLauncherRoller(double output) {
        output = clamp(output);
        intakeLauncherRoller.set(output);
        lastIntakeLauncherOutput = output;
    }

    public void setFeederRoller(double output) {
        output = clamp(output);
        feederRoller.set(output);
        lastFeederOutput = output;
    }

    public void stop() {
        feederRoller.stopMotor();
        intakeLauncherRoller.stopMotor();
        lastFeederOutput = 0.0;
        lastIntakeLauncherOutput = 0.0;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Feeder Roller Output", lastFeederOutput);
        SmartDashboard.putNumber("Intake Roller Output", lastIntakeLauncherOutput);
    }
}