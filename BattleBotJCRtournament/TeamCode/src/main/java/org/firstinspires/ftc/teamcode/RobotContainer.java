package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.bladeMotorCommand;
import org.firstinspires.ftc.teamcode.Subsystems.bladeMotorSubsystem;

@TeleOp(name = "TeleOperatedMode")
public class RobotContainer extends OpMode {
    bladeMotorSubsystem bladeSub;
    bladeMotorCommand bladeCmd;

    public void init(){
        bladeSub = new bladeMotorSubsystem (hardwareMap);

        bladeCmd = new bladeMotorCommand(bladeSub, gamepad1);
    }

    public void loop(){
        bladeCmd.runBlade();
    }
}
