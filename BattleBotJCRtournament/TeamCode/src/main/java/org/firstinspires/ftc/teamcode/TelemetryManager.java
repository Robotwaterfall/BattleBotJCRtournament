package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Commands.bladeMotorCommand;
import org.firstinspires.ftc.teamcode.Commands.omniDriveCommand;
import org.firstinspires.ftc.teamcode.Subsystems.bladeMotorSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.omniDriveSubsystem;

public class TelemetryManager {
    private final bladeMotorCommand bladeCmd;
    private final bladeMotorSubsystem bladeSub;
    private final omniDriveCommand driveCmd;
    private final omniDriveSubsystem driveSub;
    private final Telemetry telemetry;
    ElapsedTime timer = new ElapsedTime();
    private final Gamepad gamepad;

    public TelemetryManager(bladeMotorCommand bladeCmd, bladeMotorSubsystem bladeSub,
                            omniDriveCommand driveCmd, omniDriveSubsystem driveSub, Telemetry telemetry,
                            Gamepad gamepad){
        this.bladeSub = bladeSub;
        this.driveSub = driveSub;
        this.bladeCmd = bladeCmd;
        this.driveCmd = driveCmd;
        this.telemetry = telemetry;
        this.gamepad = gamepad;
    }

    public void runTelemetry(){
        telemetry.addData("Initialized Time", "%.2f Seconds", timer.seconds());
        telemetry.addData("Slow Mode", driveCmd.slowMode ? "ON" : "OFF");
        telemetry.addData("Blade State", bladeCmd.motorState ? "ON" : "OFF");
        telemetry.addData("Heading (rad)", driveSub.getHeading());
        telemetry.addData("Motor Powers", "L: %.2f | R: %.2f | B: %.2f",
                driveSub.getLeftPower(),
                driveSub.getRightPower(),
                driveSub.getBackPower()
        );
        telemetry.addData("Blade Power", "BP: %.2f",
                bladeSub.getBladePower());
        telemetry.addData("Joysticks", "lY: %.2f | lX: %.2f | rX: %.2f",
                gamepad.left_stick_y,
                gamepad.left_stick_x,
                gamepad.right_stick_x);
        telemetry.update();

    }
}
