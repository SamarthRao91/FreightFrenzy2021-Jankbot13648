 package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;

 @TeleOp(name = "TeleOp - Main")
public class TeleOpMain extends LinearOpMode {

     MecanumDrive drive;

     @Override
     public void runOpMode() {

         waitForStart();

         if (isStopRequested()) return;

         while (!isStopRequested() && opModeIsActive())
         {
             // Tele-Op Drive
             Pose2d poseEstimate = drive.getPoseEstimate();

             Vector2d input = new Vector2d(
                     -gamepad1.left_stick_y,
                     -gamepad1.left_stick_x
             ).rotated(-poseEstimate.getHeading());

             drive.setWeightedDrivePower(
                     new Pose2d(
                             input.getX(),
                             input.getY(),
                             -gamepad1.right_stick_x
                     )
             );
         }
     }
 }
