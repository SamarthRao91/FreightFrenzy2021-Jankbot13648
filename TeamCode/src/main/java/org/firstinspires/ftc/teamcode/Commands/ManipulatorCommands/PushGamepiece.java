package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;


public class PushGamepiece extends ParallelCommandGroup {

    public PushGamepiece(Manipulator manipulator) {
        addCommands(
                new InstantCommand(manipulator::openClaw),
                new InstantCommand(() -> manipulator.setPusher(Constants.Manipulator.Pusher.PUSHER_PUSH_POS))
        );

        addRequirements(manipulator);
    }
}
