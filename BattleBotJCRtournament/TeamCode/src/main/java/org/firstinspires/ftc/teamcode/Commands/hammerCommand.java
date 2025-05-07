package org.firstinspires.ftc.teamcode.Commands;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.hammerSubsystem;

public class hammerCommand {
    private final hammerSubsystem hamSub;
    private Gamepad gamepad;

    public hammerCommand(hammerSubsystem hamSub, Gamepad gamepad){
        this.hamSub = hamSub;
        this.gamepad = gamepad;
    }

    public void runSmash() {
        if (gamepad.y) {
            hamSub.setSmash(90);
        }
    }
}
