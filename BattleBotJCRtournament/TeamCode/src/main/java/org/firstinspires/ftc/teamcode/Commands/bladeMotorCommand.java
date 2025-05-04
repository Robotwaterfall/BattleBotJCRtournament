package org.firstinspires.ftc.teamcode.Commands;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.bladeMotorSubsystem;

/**
 * This class is for setting the blade to the desired
 * motor speed.
 */
public class bladeMotorCommand {
    private final bladeMotorSubsystem bladeSub;
    private final Gamepad gamepad;

    private boolean lastToggleState = false;
    private boolean motorState = false;

    public bladeMotorCommand(bladeMotorSubsystem bladeSub, Gamepad gamepad){
        this.bladeSub = bladeSub;
        this.gamepad = gamepad;
    }

    public void bladeRun(){
        boolean togglePressed = gamepad.a;

        if(togglePressed && !lastToggleState){
            motorState = !motorState;
        }

        lastToggleState = togglePressed;

        if(motorState){
            bladeSub.setPower(1);
        }else{
            bladeSub.setPower(0);
        }

        telemetry.addData("isBladeSpinning", motorState ? "YES" : "NO");
    }


}
