package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.*;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
@TeleOp(name = "Extenderererer Check")
public class EncoderCheck extends LinearOpMode {
    //different subsystems
    //MecanumDrive drive;
    //Claw claw;
    //DuckSpinner spinner;
    Extender extender;
    //Intake intake;
   // Turret turret;



    @Override
    public void runOpMode() {

        extender = new Extender(hardwareMap);

        waitForStart();

        if (isStopRequested()) return;

        while (!isStopRequested() && opModeIsActive())
        {
            if(gamepad1.a) {
                extender.setExtenderPosition(Constants.extenderPosition1);
            }
            if(gamepad1.b)
            {
                extender.setExtenderPosition(Constants.extenderPosition2);

            }




        }
    }
}
