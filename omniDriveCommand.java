package org.firstinspires.ftc.teamcode.Commands;


import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.omniDriveSubsystem;

import java.sql.Time;

/**
 * This class is for setting the joystick to the value we created
 * in the subsystem class. This class is also used for running the motors
 * because in the RobotContainer class i execute the line "run()" down below.
 */
public class omniDriveCommand {
   private final omniDriveSubsystem drivesub;
   private final Gamepad gamepad;
   public boolean slowMode = false;
   private boolean lastToggleState = false;
   private final Telemetry telemetry;
   ElapsedTime timer = new ElapsedTime();


   public omniDriveCommand(omniDriveSubsystem drivesub, Gamepad gamepad, Telemetry telemetry){
       this.drivesub = drivesub;
       this.gamepad = gamepad;
       this.telemetry = telemetry;
   }

   public void resetTimer(){
       timer.reset();
   }

   public void run(){

       double seconds = timer.seconds();

       //Toggle logic using 'x' button
       boolean togglePressed = gamepad.x;

       if(togglePressed && !lastToggleState){
           slowMode = !slowMode; //toggle the state
       }
       lastToggleState = togglePressed; //update the state for next loop

       double multiplier = slowMode ? 0.6 : 1.0; //sets the slow mode speed to 60%

       double x = gamepad.left_stick_x * multiplier;
       double y = -gamepad.left_stick_y * multiplier;
       double rotation = -gamepad.right_stick_x * multiplier;

       if(gamepad.dpad_down){
           drivesub.zeroHeading();
       }

       drivesub.drive(x,y,rotation);

   }
}
