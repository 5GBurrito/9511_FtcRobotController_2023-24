package org.firstinspires.ftc.teamcode.old;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp

public class bippityBoppityYourValueIsNowMyProperty extends OpMode {

    private DcMotor slideMotor;

    private int slideZero;

    @Override
    public void init() {
        slideMotor = hardwareMap.dcMotor.get("slideMotor");
        slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slideZero = slideMotor.getCurrentPosition();
        slideMotor.setTargetPosition(slideMotor.getCurrentPosition());
        slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {
        slideMotor.setPower(gamepad1.left_stick_y);
        telemetry.addData("MotorPosition", slideMotor.getCurrentPosition());
        telemetry.update();
    }
}
