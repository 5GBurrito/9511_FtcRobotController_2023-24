package org.firstinspires.ftc.teamcode;

import static java.lang.Math.abs;
import static java.lang.Math.max;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class slideTest extends OpMode {

    //adds a working sleep function with the format on rest(time);
    public void sleepForMilliseconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private DcMotor slideMotor;

    private int slideZero;
    private int slidePosition;

    @Override
    public void init() {
        slideMotor = hardwareMap.dcMotor.get("slideMotor");
        slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slideZero = slideMotor.getCurrentPosition();
        slideMotor.setTargetPosition(slideMotor.getCurrentPosition());
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

//        telemetry.addData("Motor position", slideMotor.getCurrentPosition());
    }

    @Override
    public void loop() {
        slidePosition = slideZero + 500;
        slideMotor.setTargetPosition(slidePosition);
        slideMotor.setPower(max(0.2, abs(slidePosition - slideMotor.getCurrentPosition()) / 500.0));

//        sleepForMilliseconds(5000);
//        slideMotor.setTargetPosition(slideZero);
//        sleepForMilliseconds(5000);

        telemetry.addData("MotorPosition", slideMotor.getCurrentPosition());
        telemetry.addData("Target Position", slidePosition);
        telemetry.update();
    }
}
