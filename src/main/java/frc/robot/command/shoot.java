package frc.robot.command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystem.ShooterSubsystem;

public class shoot extends Command{
    ShooterSubsystem shooterSubsystem;
    double shooterVelocity = 0;

    public shoot(ShooterSubsystem shooterSubsystem,double shooterVelocity){
        this.shooterVelocity = shooterVelocity;
        this.shooterSubsystem = shooterSubsystem;

        addRequirements(shooterSubsystem);
    }
    @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    shooterSubsystem.setShooter(shooterVelocity);
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
