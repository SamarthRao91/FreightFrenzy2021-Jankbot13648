package org.firstinspires.ftc.teamcode.Commands.IntakeCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Systems.Intake;

import java.util.function.DoubleSupplier;

public class IntakeDefault extends CommandBase {

    private final Intake intake;

    private final DoubleSupplier forwardSpeed;
    private final DoubleSupplier reverseSpeed;

    public IntakeDefault(Intake intake, DoubleSupplier forwardSpeed, DoubleSupplier reverseSpeed) {
        this.intake = intake;

        this.forwardSpeed = forwardSpeed;
        this.reverseSpeed = reverseSpeed;

        addRequirements(intake);
    }

    @Override
    public void execute()
    {
        intake.setIntake(forwardSpeed.getAsDouble(), reverseSpeed.getAsDouble());
    }
}
