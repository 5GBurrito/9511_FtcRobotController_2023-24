package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Encoder Value Grabber", group = "Example")
public class encoderValueGrabber extends LinearOpMode {

    private DcMotor motor1;
    private DcMotor motor2;

    @Override
    public void runOpMode() {
        motor1 = hardwareMap.get(DcMotor.class, "motor1"); // Replace "motor1" with the actual name of your motor
        motor2 = hardwareMap.get(DcMotor.class, "motor2"); // Replace "motor2" with the actual name of your motor

        // Set motor run modes to encoders
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        while (opModeIsActive()) {
            // Read encoder values
            int encoder1Value = motor1.getCurrentPosition();
            int encoder2Value = motor2.getCurrentPosition();

            // Send encoder values to telemetry (display on the driver station)
            telemetry.addData("Encoder 1 Value", encoder1Value);
            telemetry.addData("Encoder 2 Value", encoder2Value);

            // Control motors using gamepad 1's left and right sticks
            double leftStickPower = gamepad1.left_stick_y;
            double rightStickPower = -gamepad1.left_stick_y;
            motor1.setPower(leftStickPower);
            motor2.setPower(rightStickPower);

            telemetry.update();
        }
    }
}
