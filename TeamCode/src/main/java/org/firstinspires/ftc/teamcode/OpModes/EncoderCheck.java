package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.*;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
@TeleOp(name = "TeleOp-Encoder Check")
public class EncoderCheck extends LinearOpMode {
    //different subsystems
   Elevator elevator;
    @Override
    public void runOpMode() {

        elevator = new Elevator(hardwareMap);

        waitForStart();

        if (isStopRequested()) return;

        while (!isStopRequested() && opModeIsActive())
        {
            telemetry.addData("Elevator Position" , elevator.getPosition());
            telemetry.update();
            System.out.println(elevator.getPosition());
            if(gamepad1.x)
            {
                elevator.toPosition(1200);
            }



            if(gamepad1.y) {

                elevator.setSpeed(0.5);
            }
            else{
                elevator.setSpeed(0);
            }
        }
    }
}
