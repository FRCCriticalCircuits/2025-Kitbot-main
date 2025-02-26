// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.command.driveForward;
import frc.robot.command.shoot;
import frc.robot.subsystem.DriveSubsystem;
import frc.robot.subsystem.ShooterSubsystem;

public class RobotContainer {
  public RobotContainer() {
    configureBindings();
  }
  DriveSubsystem driveSubsystem = new DriveSubsystem();
  ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

  private void configureBindings() {}

  public Command getAutonomousCommand() {  
    return new SequentialCommandGroup(
      new WaitCommand(5),
      new ParallelDeadlineGroup(
        new WaitCommand(3.3),
        new driveForward(driveSubsystem, 0.8)
      ),
        new ParallelDeadlineGroup(
        new WaitCommand(2),
        new shoot(shooterSubsystem, 0.5),
        new driveForward(driveSubsystem, 0)
      ),
      new ParallelDeadlineGroup(
        new shoot(shooterSubsystem, 0),
        new driveForward(driveSubsystem, 0)
      )
    );
  }
}
