package frc.robot.command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystem.DriveSubsystem;

// Command to run the robot at 1/2 power for 1 second in autonomous
public class driveForward extends Command {
  DriveSubsystem driveSubsystem;
  double velocity = 0;

  public driveForward(DriveSubsystem driveSubsystem, double velocity) {
    this.driveSubsystem = driveSubsystem;
    this.velocity = velocity;

    addRequirements(driveSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    driveSubsystem.drive(velocity, 0, 0);
  }

  // Runs each time the command ends via isFinished or being interrupted.
  @Override
  public void end(boolean isInterrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
