package org.firstinspires.ftc.teamcode.Util;

public class HeadingStorage {

    private static double heading = 0.0;

    public static double getHeading() {
        return heading;
    }

    public static void setHeading(double heading) {
        HeadingStorage.heading = heading;
    }
}
