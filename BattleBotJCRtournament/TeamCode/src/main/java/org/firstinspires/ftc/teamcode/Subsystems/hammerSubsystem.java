package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class hammerSubsystem {
    Servo hamServo;

    public hammerSubsystem(HardwareMap hardwareMap){
        hamServo = hardwareMap.get(Servo.class, "servo0");
    }

    public void setSmash(double servoPosition){
        hamServo.setPosition(servoPosition);
    }
}
