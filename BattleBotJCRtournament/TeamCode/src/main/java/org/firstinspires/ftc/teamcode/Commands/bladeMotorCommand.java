package org.firstinspires.ftc.teamcode.Commands;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.bladeMotorSubsystem;

/**
 * This class is for setting the blade to the desired
 * motor speed.
 */
public class bladeMotorCommand {
    private final bladeMotorSubsystem bladeSub;
    private final Gamepad gamepad;

    public bladeMotorCommand(bladeMotorSubsystem bladeSub, Gamepad gamepad){
        this.bladeSub = bladeSub;
        this.gamepad = gamepad;
    }

    public void runBlade(){
        bladeSub.setPower(1);
    }
}
