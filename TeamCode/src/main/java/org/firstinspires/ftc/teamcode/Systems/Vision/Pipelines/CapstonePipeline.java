package org.firstinspires.ftc.teamcode.Systems.Vision.Pipelines;

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
    final Scalar BLUE = new Scalar(0, 0, 255);

    final Point LEFT_TOPLEFT_ANCHOR_POINT = new Point(100, 100);
    final Point CENTER_TOPLEFT_ANCHOR_POINT = new Point(100, 100);
    final Point RIGHT_TOPLEFT_ANCHOR_POINT = new Point(100, 100);

    final int REGION_WIDTH = 85;
    final int REGION_HEIGHT = 150;

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
    Mat leftCb = new Mat();
    int leftAvg;

    Mat centerRegionCb;
    Mat centerYCrCb = new Mat();
    Mat centerCb = new Mat();
    int centerAvg;

    Mat rightRegionCb;
    Mat rightYCrCb = new Mat();
    Mat rightCb = new Mat();
    int rightAvg;

    public volatile CapstonePosition position = CapstonePosition.LEFT;

    void inputToCb(Mat input)
    {
        Imgproc.cvtColor(input, leftYCrCb, Imgproc.COLOR_RGB2YCrCb);
        Core.extractChannel(leftYCrCb, leftCb, 1);

        Imgproc.cvtColor(input, centerYCrCb, Imgproc.COLOR_RGB2YCrCb);
        Core.extractChannel(centerYCrCb, centerCb, 1);

        Imgproc.cvtColor(input, rightYCrCb, Imgproc.COLOR_RGB2YCrCb);
        Core.extractChannel(rightYCrCb, rightCb, 1);
    }

    @Override
    public void init(Mat firstFrame)
    {
        inputToCb(firstFrame);

        leftRegionCb = leftCb.submat(new Rect(LEFT_TOPLEFT_ANCHOR_POINT, LEFT_BOTTOMRIGHT_ANCHOR_POINT));
        centerRegionCb = leftCb.submat(new Rect(CENTER_TOPLEFT_ANCHOR_POINT, CENTER_BOTTOMRIGHT_ANCHOR_POINT));
        rightRegionCb = leftCb.submat(new Rect(RIGHT_TOPLEFT_ANCHOR_POINT, RIGHT_BOTTOMRIGHT_ANCHOR_POINT));
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
                BLUE,
                2
        );

        Imgproc.rectangle(
                input,
                CENTER_TOPLEFT_ANCHOR_POINT,
                CENTER_BOTTOMRIGHT_ANCHOR_POINT,
                BLUE,
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
