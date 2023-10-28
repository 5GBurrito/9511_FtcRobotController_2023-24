//motor 1, top: -75, bottom: 82
//motor 2, top: 144, bottom: 105

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp

public class scrimmageTest extends OpMode {

    //movement motors
    private DcMotor frontLeftMotor;
    private DcMotor backLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backRightMotor;
    //arm motors
    private DcMotor motor1;
    private DcMotor motor2;
    //arm servo
    private Servo armServo;
    //hand servos
    private Servo leftFinger;
    private Servo rightFinger;
    //limiter values
    private final int motor1Top = -75;
    private final int motor1Bottom = 82;
    private final int motor2Top = 144;
    private final int motor2Bottom = 105;


    @Override
    public void init() {
        //movement motors
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
        //arm motors
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        //arm servo
        armServo = hardwareMap.servo.get("armServo");
        //hand servos
        leftFinger = hardwareMap.servo.get("leftFinger");
        rightFinger = hardwareMap.servo.get("rightFinger");

        //resets hand servos
        //leftFinger.setPosition(0.75);
        //rightFinger.setPosition(0);
    }

    @Override
    public void loop() {

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

        double rightStickY = gamepad1.right_stick_y;
        double rightStickPower = -gamepad1.right_stick_y;
//        if (motor1.getCurrentPosition() >= motor1Bottom && motor1.getCurrentPosition() <= motor1Top) {
//            motor1.setPower(leftStickPower);
//            motor2.setPower(rightStickPower);
//        } else {
//            if (motor1.getCurrentPosition() > motor1Top) {
//                motor1.setPower(-0.5);
//                motor1.setPower(0.5);
//            }
//            if (motor1.getCurrentPosition() < motor1Bottom) {
//                motor1.setPower(0.5);
//                motor1.setPower(-0.5);
//            }
//        }
        motor1.setPower(rightStickY);
        motor2.setPower(rightStickPower);

        //arm servo control
        armServo.setPosition(gamepad1.left_trigger/2);

        //hand control
        leftFinger.setPosition(gamepad1.right_trigger);
        rightFinger.setPosition(gamepad1.right_trigger);

    }
}