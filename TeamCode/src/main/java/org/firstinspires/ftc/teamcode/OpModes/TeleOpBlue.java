package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.*;
import org.firstinspires.ftc.teamcode.Systems.DriveBase.drive.MecanumDrive;
@TeleOp(name = "TeleOp - Blue")
public class TeleOpBlue extends LinearOpMode {
    //different subsystems
    MecanumDrive drive;
    Claw claw;
    DuckSpinner spinner;
    Extender extender;
    Intake intake;
    Turret turret;
    Elevator elevator;
    public void resetMechanisms()
    {
        claw.setClaw(Constants.claw_close);
        if (Constants.elevator_postion < .5 && Constants.turret_position == Constants.turret_zeropos) { //skips function if already reset
            return;
        }
        if(Constants.elevator_postion < Constants.elevator_minimumsafepos) { //raises elevator if turret needs to spin or if extender needs to retract
            if (Constants.turret_position == Constants.turret_zeropos) { //lowers elevator if turret is almost in intaking position, extender should never be extended here
                //elevator.setpos(0); @todo here
                return; //superstructure should be reset
            }
            // elevator.setpos(Constants.elevator_minimumsafepos + .5); //otherwise raise the elevator @todo here
        }
        if (Constants.turret_position > Constants.turret_left_safepos && Constants.turret_position < Constants.turret_right_safepos) turret.turretPresets(Constants.turret_zeropos); //sets turret to zero if its between safe zones,
        { //do these in paralell
            if(Constants.elevator_postion < Constants.elevator_minimumsafepos) // @todo elevator.setpos(Constants.elevator_mimimumsafepos + .5); //lowers the elevator, do not wait for this to finish to continue
                extender.setExtenderPosition(Constants.ex_minpos); //retract extender to minimum
            if(Constants.turret_position> Constants.turret_right_safepos) turret.turretPresets(Constants.turret_right_safepos); //move turret as close to center if outside assuming worst-case scenario which extender is extended
            else if(Constants.turret_position < Constants.turret_left_safepos) turret.turretPresets(Constants.turret_left_safepos); //same as above but for the other side
            else if(Constants.turret_position == Constants.turret_zeropos );//this only happens if turret is at zero

        }
        //extender should now be retracted and turret is close to center, elevator should now be lower than it started
        { //do these in paralell
            // @todo elevator.setpos(Constants.elevator_minimumsafepos + .5);
            turret.turretPresets(Constants.turret_zeropos);
        }
        //turret should be centered now and is above zero position
        //elevator.setposition(0);
        claw.setClaw(Constants.claw_open);
        return;
    }
    @Override
    public void runOpMode() {
        drive = new MecanumDrive(hardwareMap);
        claw = new Claw(hardwareMap);
        spinner = new DuckSpinner(hardwareMap);
        extender = new Extender(hardwareMap);
        intake = new Intake(hardwareMap);
        turret = new Turret(hardwareMap);
        elevator = new Elevator(hardwareMap);

        waitForStart();

        if (isStopRequested()) return;

        while (!isStopRequested() && opModeIsActive())
        {
            // Tele-Op Drive
            Pose2d poseEstimate = drive.getPoseEstimate();

            Vector2d input = new Vector2d(
                    -gamepad1.left_stick_y,
                    -gamepad1.left_stick_x
            ).rotated(-drive.getRawExternalHeading());

            drive.setWeightedDrivePower(
                    new Pose2d(
                            input.getX(),
                            input.getY(),
                            -gamepad1.right_stick_x
                    )
            );
            //driver 1 controls
            if(gamepad1.right_trigger == 1)
            {
                intake.setIntake(1,0);
            }
            else if(gamepad1.left_trigger == 1)
            {
                intake.setIntake(0,1);
            }
            if(gamepad1.a)
            {
                resetMechanisms();
            }
            if(gamepad1.b)
            {   //low preset
                elevator.toPosition(300);
                turret.turretPresets(Constants.turret_right_safepos);
                extender.setExtenderPosition(Constants.ex_maxpos);
            }
            if(gamepad1.y)
            {   //high preset
                elevator.toPosition(600);
                turret.turretPresets(Constants.turret_right_safepos);
                extender.setExtenderPosition(Constants.ex_maxpos);
            }
            if(gamepad1.x)
            {
                //score gamepiece
            }
            if(gamepad1.start)
            {
                //high reverse preset
                elevator.toPosition(600);
                turret.turretPresets(Constants.turret_left_safepos);
                extender.setExtenderPosition(Constants.ex_maxpos);
            }

            //driver 2 controls
            if(gamepad2.a)
            {
                resetMechanisms();
            }
            if(gamepad2.b)
            {   //low preset
                elevator.toPosition(300);
                turret.turretPresets(Constants.turret_right_safepos);
                extender.setExtenderPosition(Constants.ex_maxpos);
            }
            if(gamepad2.y)
            {   //high preset
                elevator.toPosition(600);
                turret.turretPresets(Constants.turret_right_safepos);
                extender.setExtenderPosition(Constants.ex_maxpos);
            }
            if(gamepad2.x)
            {
                //score gamepiece
            }
            if(gamepad2.start)
            {
                //high reverse preset
                elevator.toPosition(600);
                turret.turretPresets(Constants.turret_left_safepos);
                extender.setExtenderPosition(Constants.ex_maxpos);
            }
            elevator.setSpeed(gamepad2.right_stick_y);
            turret.turretPresets(gamepad2.left_stick_x);
            extender.setExtenderPosition(gamepad2.left_stick_y);
            if(gamepad2.dpad_down)
            {
                claw.setClaw(Constants.claw_close);
            }
            if(gamepad2.dpad_up)
            {
                claw.setClaw(Constants.claw_open);
            }
            if(gamepad2.dpad_right)
            {
                claw.setClaw(Constants.openClawFully);
            }





        }
    }
}
