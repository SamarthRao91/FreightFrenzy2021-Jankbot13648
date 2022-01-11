package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

public class TurretResetWithPot extends CommandBase{
    private final Manipulator manipulator;

    public TurretResetWithPot(Manipulator manipulator) {
        this.manipulator = manipulator;

        addRequirements(manipulator);


    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {


        if (manipulator.getPotValue() > Constants.Manipulator.Turret.POT_ZERO_VALUE) {
            manipulator.setSpeed(.8*(manipulator.getPotValue() - Constants.Manipulator.Turret.POT_ZERO_VALUE) + .14);
        }
        else {
            manipulator.setSpeed(.8*(manipulator.getPotValue() - Constants.Manipulator.Turret.POT_ZERO_VALUE) - .14);
        }
        //manipulator.resetTurretEncoder();
    }

    @Override
    public void end(boolean isInterrupted) {
        manipulator.setSpeed(0);
        manipulator.resetTurretEncoder();
    }

    @Override
    public boolean isFinished() {
        return (Math.abs(manipulator.getPotValue() - Constants.Manipulator.Turret.POT_ZERO_VALUE) < .001    );
    }
}
