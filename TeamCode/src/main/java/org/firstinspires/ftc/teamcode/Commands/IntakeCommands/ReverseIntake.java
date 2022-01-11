package org.firstinspires.ftc.teamcode.Commands.IntakeCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Systems.Intake;

import java.util.function.DoubleSupplier;

public class ReverseIntake extends CommandBase {

    private final Intake intake;


    public ReverseIntake(Intake intake) {
        this.intake = intake;
        new WaitCommand(125);
        intake.setIntake(-.75);
        new WaitCommand(375);
        intake.setIntake(0);

        addRequirements(intake);
    }
}

