package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.omniDriveCommand;
import org.firstinspires.ftc.teamcode.Subsystems.omniDriveSubsystem;

@TeleOp(name = "TeleOperatedMode")
public class RobotContainer extends OpMode {
  omniDriveSubsystem driveSub;
  omniDriveCommand driveCommand;


  public void init(){
    driveSub = new omniDriveSubsystem(hardwareMap);

    driveCommand = new omniDriveCommand(driveSub, gamepad1);
  }

  public void loop(){
    driveCommand.run();
  }
}
