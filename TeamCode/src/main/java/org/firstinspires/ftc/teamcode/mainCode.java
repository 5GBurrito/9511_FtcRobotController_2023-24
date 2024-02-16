package org.firstinspires.ftc.teamcode;

import static java.lang.Math.abs;
import static java.lang.Math.max;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class mainCode extends OpMode {

    //mecanum motors
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    //launcher servo
    private Servo launcherServo;

    //linear slide motor
    private DcMotor slideMotor;

    //wrist servo
    private Servo wristServo;

    //hand servo
    private Servo handServo;

    private int slideZero;
    private int slidePosition;

    @Override
    public void init() {

        //mecanum motors
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeft");
        frontRightMotor = hardwareMap.dcMotor.get("frontRight");
        backLeftMotor = hardwareMap.dcMotor.get("backLeft");
        backRightMotor = hardwareMap.dcMotor.get("backRight");

        //launcher servo
        launcherServo = hardwareMap.servo.get("launcherServo");
        launcherServo.setPosition(0.70);
        //launcherServo.setPosition(0.75);

        //linear slide servo
        slideMotor = hardwareMap.dcMotor.get("slideMotor");
        slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slideZero = slideMotor.getCurrentPosition();
        slideMotor.setTargetPosition(slideMotor.getCurrentPosition());
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //wrist servo
        wristServo = hardwareMap.servo.get("wristServo");
        wristServo.setPosition(0);

        //hand servo
        handServo = hardwareMap.servo.get("handServo");
        handServo.setPosition(1);

        //slide stuff
        slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slideZero = slideMotor.getCurrentPosition();
        slideMotor.setTargetPosition(slideMotor.getCurrentPosition());
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void loop() {

        //mecanum code
        double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
        double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
        double rx = gamepad1.right_stick_x;

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        frontLeftMotor.setPower(-frontLeftPower);
        backLeftMotor.setPower(-backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);

        //wrist and hand control
        //wristServo.setPosition(gamepad1.left_trigger*0.45);
        wristServo.setPosition((gamepad1.left_trigger*0.70));
        handServo.setPosition(gamepad1.right_trigger*0.80) ;

        //arm control
        if (gamepad1.cross) {
            slidePosition = slideZero;
        }
        if (gamepad1.square) {
            slidePosition = slideZero + 500;
        }
        if (gamepad1.triangle) {
            slidePosition = slideZero + 1000;
        }
        if (gamepad1.left_bumper) {
            slidePosition = slideZero + 250;
        }

        slideMotor.setTargetPosition(slidePosition);
        slideMotor.setPower(max(0.2, abs(slidePosition - slideMotor.getCurrentPosition()) / 500.0));

        //launcher code
        if (gamepad1.circle) {
            launcherServo.setPosition(0);
        }
    }
}