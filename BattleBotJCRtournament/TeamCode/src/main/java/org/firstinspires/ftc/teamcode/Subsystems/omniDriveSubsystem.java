package org.firstinspires.ftc.teamcode.Subsystems;


import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;


/**
 * This subsystem class is used for setting the powers
 * of the 3 omni wheels in the kiwi base formation.
 */
public class omniDriveSubsystem {

    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorBack;

    private final BNO055IMU imu;

    public omniDriveSubsystem(HardwareMap hardwareMap){
        motorLeft = hardwareMap.get(DcMotor.class, "motor1");
        motorRight = hardwareMap.get(DcMotor.class, "motor2");
        motorBack = hardwareMap.get(DcMotor.class, "motor3");

        imu = hardwareMap.get(BNO055IMU.class, "imu");
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.RADIANS;
        imu.initialize(parameters);
    }

    private double headingOffset = 0;


    public void zeroHeading() {
        headingOffset = getRawHeading();  // store the current angle as zero
    }


    public double getRawHeading() {
        return imu.getAngularOrientation().firstAngle;
    }

    public double getHeading() {
        return AngleUnit.normalizeRadians(getRawHeading() - headingOffset);
    }


    /**
     * This sets the motors to
     * the joysticks x and y position.
     */
    public void drive(double x, double y, double rotation) {
        double heading = getHeading();  // get robot heading in radians

        // Rotate joystick input for field-centric control
        double rotatedX = x * Math.cos(-heading) - y * Math.sin(-heading);
        double rotatedY = x * Math.sin(-heading) + y * Math.cos(-heading);

        // Kiwi drive formulas
        double powerLeft  = -0.5 * rotatedX + (Math.sqrt(3)/2) * rotatedY + rotation;
        double powerRight = -0.5 * rotatedX - (Math.sqrt(3)/2) * rotatedY + rotation;
        double powerBack  = rotatedX + rotation;

        // Normalizing the powers so the motors are all equal :)
        double max = Math.max(Math.abs(powerLeft), Math.max(Math.abs(powerRight), Math.abs(powerBack)));
        if (max > 1.0) {
            powerLeft  /= max;
            powerRight /= max;
            powerBack  /= max;
        }

        motorLeft.setPower(powerLeft);
        motorRight.setPower(powerRight);
        motorBack.setPower(powerBack);
    }

}
