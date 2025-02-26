package frc.robot.subsystem;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class MotorGroup {
    private VictorSP frontMotor;
    private VictorSP rearMotor; 

    public MotorGroup(int frontID, int rearID, boolean invert){
        frontMotor = new VictorSP(frontID);
        rearMotor = new VictorSP(rearID);

        frontMotor.setInverted(invert);
        rearMotor.setInverted(invert);
    }

    public void setDutyCycle(double speed){
        frontMotor.set(speed);
        rearMotor.set(speed);
    }

    public void openLoopVelocity(double velocity){
        frontMotor.set(velocity / 3);
        rearMotor.set(velocity / 3);
    }
}
