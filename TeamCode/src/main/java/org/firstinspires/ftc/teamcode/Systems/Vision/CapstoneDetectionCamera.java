package org.firstinspires.ftc.teamcode.Systems.Vision;

import static org.firstinspires.ftc.teamcode.Constants.Vision.CAPSTONE_DETECTION_CAMERA_NAME_LEFT;
import static org.firstinspires.ftc.teamcode.Constants.Vision.CAPSTONE_DETECTION_CAMERA_NAME_RIGHT;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines.CapstonePipeline;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvSwitchableWebcam;


public class CapstoneDetectionCamera implements Runnable {
    WebcamName webcam1;
    WebcamName webcam2;
    OpenCvSwitchableWebcam switchableWebcam;
    CapstonePipeline pipeline;
    Telemetry telemetry;

    public CapstoneDetectionCamera(HardwareMap hardwareMap) {
        webcam1 = hardwareMap.get(WebcamName.class, CAPSTONE_DETECTION_CAMERA_NAME_LEFT);
        webcam2 = hardwareMap.get(WebcamName.class, CAPSTONE_DETECTION_CAMERA_NAME_RIGHT);

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());

        switchableWebcam = OpenCvCameraFactory.getInstance().createSwitchableWebcam(cameraMonitorViewId, webcam1, webcam2);

        pipeline = new CapstonePipeline();
        switchableWebcam.setPipeline(pipeline);


        switchableWebcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
                                                   @Override
                                                   public void onOpened() {
                                                       switchableWebcam.startStreaming(Constants.Vision.CAMERA_RESOLUTION_WIDTH, Constants.Vision.CAMERA_RESOLUTION_HEIGHT, OpenCvCameraRotation.UPRIGHT);
                                                       FtcDashboard.getInstance().startCameraStream(switchableWebcam, 0);
                                                   }

                                                   @Override
                                                   public void onError(int errorCode) {
                                                       System.out.println("error" + errorCode);
                                                       telemetry.addData("Error has occured. Error code - ", errorCode);
                                                   }
                                               }
        );
    }

    public CapstonePipeline.CapstonePosition getPosition()
    {
        return pipeline.position;
    }

    public int[] getAnalysis()
    {
        return pipeline.getAnalysis();
    }

    @Override
    public void run() {

    }
}
