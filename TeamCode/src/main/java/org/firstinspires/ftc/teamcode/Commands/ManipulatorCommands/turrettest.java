package org.firstinspires.ftc.teamcode.Commands.ManipulatorCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets.PushAndReset;
import org.firstinspires.ftc.teamcode.Commands.MultiSubsystemCommands.ScoringPresets.RedLowPreset;
import org.firstinspires.ftc.teamcode.Systems.Elevator;
import org.firstinspires.ftc.teamcode.Systems.Manipulator;

import java.util.function.DoubleSupplier;

public class turrettest extends SequentialCommandGroup {

    int delay = 1000;

    public turrettest(Manipulator manipulator, Elevator elevator) {
        addCommands(
                new WaitCommand(1000),
                new ManualPickup(manipulator),
                new WaitCommand(1000),
                new RedLowPreset(elevator, manipulator),
                new WaitCommand(1000),
                new PushAndReset(elevator, manipulator),
                new WaitCommand(1000),
                new ManualPickup(manipulator),
                new WaitCommand(1000),
                new RedLowPreset(elevator, manipulator),
                new WaitCommand(1000),
                new PushAndReset(elevator, manipulator),
                new WaitCommand(1000),
                new ManualPickup(manipulator),
                new WaitCommand(1000),
                new RedLowPreset(elevator, manipulator),
                new WaitCommand(1000),
                new PushAndReset(elevator, manipulator),
                new WaitCommand(1000),
                new ManualPickup(manipulator),
                new WaitCommand(1000),
                new RedLowPreset(elevator, manipulator),
                new WaitCommand(1000),
                new PushAndReset(elevator, manipulator),
                new WaitCommand(1000),
                new ManualPickup(manipulator),
                new WaitCommand(1000),
                new RedLowPreset(elevator, manipulator),
                new WaitCommand(1000),
                new PushAndReset(elevator, manipulator),
                new WaitCommand(1000),
                new ManualPickup(manipulator),
                new WaitCommand(1000),
                new RedLowPreset(elevator, manipulator),
                new WaitCommand(1000),
                new PushAndReset(elevator, manipulator),
                new WaitCommand(1000),
                new ManualPickup(manipulator),
                new WaitCommand(1000),
                new RedLowPreset(elevator, manipulator),
                new WaitCommand(1000),
                new PushAndReset(elevator, manipulator),
                new WaitCommand(1000),
                new ManualPickup(manipulator),
                new WaitCommand(1000),
                new RedLowPreset(elevator, manipulator),
                new WaitCommand(1000),
                new PushAndReset(elevator, manipulator),
                new WaitCommand(1000),
                new ManualPickup(manipulator),
                new WaitCommand(1000),
                new RedLowPreset(elevator, manipulator),
                new WaitCommand(1000),
                new PushAndReset(elevator, manipulator),
                new WaitCommand(1000),
                new ManualPickup(manipulator),
                new WaitCommand(1000),
                new RedLowPreset(elevator, manipulator),
                new WaitCommand(1000),
                new PushAndReset(elevator, manipulator),
                new WaitCommand(1000),
                new ManualPickup(manipulator),
                new WaitCommand(1000),
                new RedLowPreset(elevator, manipulator),
                new WaitCommand(1000),
                new PushAndReset(elevator, manipulator)


                );

    }


}
