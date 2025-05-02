package org.firstinspires.ftc.teamcode.Commands;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.omniDriveSubsystem;

public class omniDriveCommand {
   private final omniDriveSubsystem drivesub;
   private final Gamepad gamepad;

   public omniDriveCommand(omniDriveSubsystem drivesub, Gamepad gamepad){
       this.drivesub = drivesub;
       this.gamepad = gamepad;
   }

   public void run(){
       double x = gamepad.left_stick_x;
       double y = -gamepad.left_stick_y;
       double rotation = gamepad.right_stick_x;

       drivesub.drive(x,y,rotation);
   }
}
