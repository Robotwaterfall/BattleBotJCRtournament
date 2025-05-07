package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.bladeMotorCommand;
import org.firstinspires.ftc.teamcode.Commands.hammerCommand;
import org.firstinspires.ftc.teamcode.Commands.omniDriveCommand;
import org.firstinspires.ftc.teamcode.Subsystems.bladeMotorSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.hammerSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.omniDriveSubsystem;

/**
 * This class is for initializing the run commands we made in each command class.
 */
@TeleOp(name = "TeleOperatedMode")
public class RobotContainer extends OpMode {
  omniDriveSubsystem driveSub;
  omniDriveCommand driveCommand;

  bladeMotorSubsystem bladeSub;
  bladeMotorCommand bladeCommand;

  hammerSubsystem hammerSub;
  hammerCommand hammerCmd;



  public void init(){
    driveSub = new omniDriveSubsystem(hardwareMap);
    driveCommand = new omniDriveCommand(driveSub, gamepad1, telemetry);

    bladeSub = new bladeMotorSubsystem(hardwareMap);
    bladeCommand = new bladeMotorCommand(bladeSub, gamepad1, telemetry);

    hammerSub = new hammerSubsystem(hardwareMap);
    hammerCmd = new hammerCommand(hammerSub, gamepad1);
  }

  public void loop() {

    /*
     This runs the drive motors
     during the TeleOperated mode
     */
    driveCommand.run();
    /*
     * This runs the blade motor at 100% (forward) when
     * button 'a' is pressed(Toggled)
     */
    bladeCommand.bladeRun();

    hammerCmd.runSmash();

  }
}
