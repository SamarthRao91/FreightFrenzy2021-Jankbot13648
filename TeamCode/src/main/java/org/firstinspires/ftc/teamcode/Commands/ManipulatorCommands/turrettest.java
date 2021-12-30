package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Systems.Manipulator;

import java.util.function.DoubleSupplier;

public class turrettest extends SequentialCommandGroup {

int delay = 1000;
    public turrettest(Manipulator manipulator)
    {
        addCommands(
              new TurretToPosition(manipulator, 550, .5),
             new WaitCommand(delay),
             new TurretToPosition(manipulator, 0, .5),
              new WaitCommand(delay),
                new TurretToPosition(manipulator, 550, .5),
                new WaitCommand(delay),
                new TurretToPosition(manipulator, 0, .5),
                new WaitCommand(delay),
                new TurretToPosition(manipulator, 550, .5),
                new WaitCommand(delay),
                new TurretToPosition(manipulator, 0, .5),
                new WaitCommand(delay), new TurretToPosition(manipulator, 550, .5),
                new WaitCommand(delay),
                new TurretToPosition(manipulator, 0, .5),
                new WaitCommand(delay), new TurretToPosition(manipulator, 550, .5),
                new WaitCommand(delay),
                new TurretToPosition(manipulator, 0, .5),
                new WaitCommand(delay), new TurretToPosition(manipulator, 550, .5),
                new WaitCommand(delay),
                new TurretToPosition(manipulator, 0, .5),
                new WaitCommand(delay), new TurretToPosition(manipulator, 550, .5),
                new WaitCommand(delay),
                new TurretToPosition(manipulator, 0, .5),
                new WaitCommand(delay), new TurretToPosition(manipulator, 550, .5),
                new WaitCommand(delay),
                new TurretToPosition(manipulator, 0, .5),
                new WaitCommand(delay), new TurretToPosition(manipulator, 550, .5),
                new WaitCommand(delay),
                new TurretToPosition(manipulator, 0, .5),
                new WaitCommand(delay), new TurretToPosition(manipulator, 550, .5),
                new WaitCommand(delay),
                new TurretToPosition(manipulator, 0, .5),
                new WaitCommand(delay), new TurretToPosition(manipulator, 550, .5),
                new WaitCommand(delay),
                new TurretToPosition(manipulator, 0, .5),
                new WaitCommand(delay)


        );

    }





}
