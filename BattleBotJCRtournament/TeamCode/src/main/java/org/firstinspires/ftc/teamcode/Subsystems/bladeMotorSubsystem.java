package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * This class is for setting the motor that has a wooden blade
 * on it to define it so i can set its power in the command.
 */
public class bladeMotorSubsystem {
    DcMotor blade;

    public bladeMotorSubsystem(HardwareMap hardwareMap){
        // sets the motor we just created to its device port that i configured on the robot
        blade = hardwareMap.get(DcMotor.class, "motor4");

        blade.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        blade.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void setPower(double power){
        blade.setPower(power);
    }
}
