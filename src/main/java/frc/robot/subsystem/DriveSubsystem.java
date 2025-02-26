package frc.robot.subsystem;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystem.Constants.DriveBase;

public class DriveSubsystem extends SubsystemBase{    
    private MotorGroup leftGroup;
    private MotorGroup rightGroup;
    public XboxController controller = new XboxController(0);

    public DriveSubsystem(){
        leftGroup = new MotorGroup(0, 1, false);
        rightGroup = new MotorGroup(3, 2, true);
    }

    public void drive(double xSpd, double ySpd, double rotSpd){
        ChassisSpeeds chassisSpeeds = new ChassisSpeeds(xSpd, ySpd, rotSpd);
        DifferentialDriveWheelSpeeds wheelSpeeds = DriveBase.kinematics.toWheelSpeeds(chassisSpeeds);
        
        leftGroup.openLoopVelocity(wheelSpeeds.leftMetersPerSecond);
        rightGroup.openLoopVelocity(wheelSpeeds.rightMetersPerSecond);
    } 

    @Override
    public void periodic(){
        drive(-controller.getLeftY() * 3, -controller.getLeftX() * 3, -controller.getRightX() * Math.PI);
    }
}
