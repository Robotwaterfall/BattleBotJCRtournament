package org.firstinspires.ftc.teamcode.Subsystems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class omniDriveSubsystem {

    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorBack;

    public omniDriveSubsystem(HardwareMap hardwareMap){
        motorLeft = hardwareMap.get(DcMotor.class, "motor1");
        motorRight = hardwareMap.get(DcMotor.class, "motor2");
        motorBack = hardwareMap.get(DcMotor.class, "motor3");
    }


    public void drive(double x, double y, double rotation) {
        double powerLeft = -0.5 * x + (Math.sqrt(3)/2) * y + rotation;
        double powerRight = -0.5 * x - (Math.sqrt(3)/2) * y + rotation;
        double powerBack = x + rotation;

        motorLeft.setPower(powerLeft);
        motorRight.setPower(powerRight);
        motorBack.setPower(powerBack);

    }

}
