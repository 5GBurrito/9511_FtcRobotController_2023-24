package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class meetThreePushbotCode extends OpMode {

    //mecanum motors
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    //arm motors
    private DcMotor armMotor;

    //hand servo
    private Servo leftFinger;
    private Servo rightFinger;

    //launcher servo
    private Servo launcherServo;

    //elbow servo
    private DcMotor elbowMotor;

    @Override
    public void init() {

        //mecanum motors
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeft");
        frontRightMotor = hardwareMap.dcMotor.get("frontRight");
        backLeftMotor = hardwareMap.dcMotor.get("backLeft");
        backRightMotor = hardwareMap.dcMotor.get("backRight");

//        //arm motors
//        armMotor = hardwareMap.dcMotor.get("armMotor");

        //hand servo
//        leftFinger = hardwareMap.servo.get("leftFinger");
//        rightFinger = hardwareMap.servo.get("rightFinger");

        //launcher servo
        launcherServo = hardwareMap.servo.get("launcherServo");
        //launcherServo.setPosition(0);
        launcherServo.setPosition(0.75);

//        //elbow motor
//        elbowMotor = hardwareMap.dcMotor.get("elbowMotor");
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

        //arm motor
//        armMotor.setPower(-gamepad1.right_stick_y);

        //hand servo
//        leftFinger.setPosition(-gamepad1.right_trigger*0.75);
//        rightFinger.setPosition(gamepad1.right_trigger*0.75);

        //launcher
        if (gamepad1.a) {
            //launcherServo.setPosition(0.75);
            launcherServo.setPosition(0);
        }

//        //elbow
//        elbowMotor.setPower(gamepad1.touchpad_finger_1_y);
    }
}