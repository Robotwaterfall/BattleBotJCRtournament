package org.firstinspires.ftc.teamcode.Commands;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.bladeMotorSubsystem;

/**
 * This class is for setting the blade to the desired
 * motor speed.
 */
public class bladeMotorCommand {
    private final bladeMotorSubsystem bladeSub;
    private final Gamepad gamepad;
    private boolean lastToggleState = false;
    public boolean motorState = false;
    private boolean lastReportedMotorState = false;

    public bladeMotorCommand(bladeMotorSubsystem bladeSub, Gamepad gamepad){
        this.bladeSub = bladeSub;
        this.gamepad = gamepad;
    }


    public void bladeRun() {
        boolean togglePressed = gamepad.a;

        if (togglePressed && !lastToggleState) {
            motorState = !motorState;
        }

        lastToggleState = togglePressed;

        bladeSub.setPower(motorState ? 1 : 0);

        if (motorState != lastReportedMotorState) {
            lastReportedMotorState = motorState;
        }

    }

}
