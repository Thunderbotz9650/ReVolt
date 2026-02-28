// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.CANDriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static Command exampleAuto(CANDriveSubsystem m_CANDriveSubsystem, ExampleSubsystem m_exampleSubsystem) {
    return Commands.sequence(m_CANDriveSubsystem.exampleMethodCommand(), new ExampleCommand(m_exampleSubsystem));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }

}
