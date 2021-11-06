package org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines;

import org.firstinspires.ftc.teamcode.Constants;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class CapstonePipeline extends OpenCvPipeline {

    public enum CapstonePosition
    {
        LEFT,
        CENTER,
        RIGHT
    }

    final Scalar RED = new Scalar(255, 0, 0);
    final Scalar GREEN = new Scalar(0, 255, 0);
    final Scalar BLUE = new Scalar(0, 0, 255);

    // TODO: Check Directions
    final Point LEFT_TOPLEFT_ANCHOR_POINT = new Point(0, 0);

    final int REGION_WIDTH = Constants.Vision.CAMERA_RESOLUTION_WIDTH/3;
    final int REGION_HEIGHT = Constants.Vision.CAMERA_RESOLUTION_HEIGHT;

    final Point CENTER_TOPLEFT_ANCHOR_POINT = new Point(LEFT_TOPLEFT_ANCHOR_POINT.x + REGION_WIDTH, 0);
    final Point RIGHT_TOPLEFT_ANCHOR_POINT = new Point(CENTER_TOPLEFT_ANCHOR_POINT.x + REGION_WIDTH, 0);

    final Point LEFT_BOTTOMRIGHT_ANCHOR_POINT = new Point(
            LEFT_TOPLEFT_ANCHOR_POINT.x + REGION_WIDTH,
            LEFT_TOPLEFT_ANCHOR_POINT.y + REGION_HEIGHT
    );

    final Point CENTER_BOTTOMRIGHT_ANCHOR_POINT = new Point(
            CENTER_TOPLEFT_ANCHOR_POINT.x + REGION_WIDTH,
            CENTER_TOPLEFT_ANCHOR_POINT.y + REGION_HEIGHT
    );

    final Point RIGHT_BOTTOMRIGHT_ANCHOR_POINT = new Point(
            RIGHT_TOPLEFT_ANCHOR_POINT.x + REGION_WIDTH,
            RIGHT_TOPLEFT_ANCHOR_POINT.y + REGION_HEIGHT
    );

    Mat leftRegionCb;
    Mat leftYCrCb = new Mat();
    Mat leftCr = new Mat();
    int leftAvg;

    Mat centerRegionCb;
    Mat centerYCrCb = new Mat();
    Mat centerCr = new Mat();
    int centerAvg;

    Mat rightRegionCb;
    Mat rightYCrCb = new Mat();
    Mat rightCr = new Mat();
    int rightAvg;

    public volatile CapstonePosition position = CapstonePosition.LEFT;

    void inputToCb(Mat input)
    {
        Imgproc.cvtColor(input, leftYCrCb, Imgproc.COLOR_RGB2YCrCb);
        Core.extractChannel(leftYCrCb, leftCr, 1);

        Imgproc.cvtColor(input, centerYCrCb, Imgproc.COLOR_RGB2YCrCb);
        Core.extractChannel(centerYCrCb, centerCr, 1);

        Imgproc.cvtColor(input, rightYCrCb, Imgproc.COLOR_RGB2YCrCb);
        Core.extractChannel(rightYCrCb, rightCr, 1);
    }

    @Override
    public void init(Mat firstFrame)
    {
        inputToCb(firstFrame);

        leftRegionCb = leftCr.submat(new Rect(LEFT_TOPLEFT_ANCHOR_POINT, LEFT_BOTTOMRIGHT_ANCHOR_POINT));
        centerRegionCb = leftCr.submat(new Rect(CENTER_TOPLEFT_ANCHOR_POINT, CENTER_BOTTOMRIGHT_ANCHOR_POINT));
        rightRegionCb = leftCr.submat(new Rect(RIGHT_TOPLEFT_ANCHOR_POINT, RIGHT_BOTTOMRIGHT_ANCHOR_POINT));
    }

    @Override
    public Mat processFrame(Mat input) {

        inputToCb(input);

        leftAvg = (int) Core.mean(leftRegionCb).val[0];
        centerAvg = (int) Core.mean(centerRegionCb).val[0];
        rightAvg = (int) Core.mean(rightRegionCb).val[0];

        position = CapstonePosition.LEFT;

        if(centerAvg > leftAvg && centerAvg > rightAvg)
        {
            position = CapstonePosition.CENTER;
        }

        else if(rightAvg > leftAvg && rightAvg > centerAvg)
        {
            position = CapstonePosition.RIGHT;
        }

        Imgproc.rectangle(
                input,
                LEFT_TOPLEFT_ANCHOR_POINT,
                LEFT_BOTTOMRIGHT_ANCHOR_POINT,
                RED,
                2
        );

        Imgproc.rectangle(
                input,
                CENTER_TOPLEFT_ANCHOR_POINT,
                CENTER_BOTTOMRIGHT_ANCHOR_POINT,
                GREEN,
                2
        );

        Imgproc.rectangle(
                input,
                RIGHT_TOPLEFT_ANCHOR_POINT,
                RIGHT_BOTTOMRIGHT_ANCHOR_POINT,
                BLUE,
                2
        );

        return input;
    }

    public int[] getAnalysis()
    {
        return new int[]{leftAvg, centerAvg, rightAvg};
    }
}
