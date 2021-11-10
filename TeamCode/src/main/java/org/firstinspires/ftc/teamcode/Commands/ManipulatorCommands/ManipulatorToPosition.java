package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Systems.Manipulator;
import org.firstinspires.ftc.teamcode.Util.StopWatch;

public class ManipulatorToPosition extends CommandBase {

    final double turretTarget;
    final double extenderTarget;
    final double clawTarget;

    final Manipulator manipulator;

    final StopWatch timer;

    public ManipulatorToPosition(Manipulator manipulator, double turretTarget, double extenderTarget, double clawTarget) {
        this.manipulator = manipulator;

        this.turretTarget = turretTarget;
        this.extenderTarget = extenderTarget;
        this.clawTarget = clawTarget;

        this.timer = new StopWatch(500);

        addRequirements(manipulator);
    }

    @Override
    public void initialize()
    {
        manipulator.setTurretPosition(turretTarget);
        manipulator.setExtenderPosition(extenderTarget);
        manipulator.setClawPosition(clawTarget);
    }

    @Override()
    public boolean isFinished()
    {
        return timer.isExpired();
    }
}
