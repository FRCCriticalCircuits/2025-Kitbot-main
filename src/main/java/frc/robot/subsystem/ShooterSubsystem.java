package frc.robot.subsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase{
        private PWMVictorSPX shooter;
        XboxController controller = new XboxController(0);
        double shooterSpeed;

        public ShooterSubsystem(){
            shooter = new PWMVictorSPX(0);
            shooter.setInverted(true);
        }
        public void setShooter(double shooterSpeed){
            this.shooterSpeed = shooterSpeed;
            shooter.set(shooterSpeed);
        }

        @Override
        public void periodic(){
            setShooter(controller.getLeftTriggerAxis());
        }
}
