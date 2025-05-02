package org.firstinspires.ftc.teamcode.Commands;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.bladeMotorSubsystem;

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
