package org.firstinspires.ftc.teamcode.Systems.Vision;

import com.acmerobotics.dashboard.FtcDashboard;
import static org.firstinspires.ftc.teamcode.Constants.*;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvSwitchableWebcam;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.openftc.easyopencv.OpenCvPipeline;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.*;



public class CapstoneDetectionCamera {
    WebcamName webcam1;
    WebcamName webcam2;
    OpenCvSwitchableWebcam switchableWebcam;
    Telemetry telemetry;

    public CapstoneDetectionCamera(HardwareMap hardwareMap) {
        webcam1 = hardwareMap.get(WebcamName.class, CAPSTONE_DETECTION_CAMERA_NAME_LEFT);
        webcam2 = hardwareMap.get(WebcamName.class, CAPSTONE_DETECTION_CAMERA_NAME_RIGHT);

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());

        switchableWebcam = OpenCvCameraFactory.getInstance().createSwitchableWebcam(cameraMonitorViewId, webcam1, webcam2);

        switchableWebcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                //switchableWebcam.setPipeline();
                switchableWebcam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
            }
            @Override public void onError(int errorCode) {
                System.out.println("error" + errorCode);
                telemetry.addData("Error has occured. Error code - " , errorCode);
            }
        }
        );

    }
}
