package org.firstinspires.ftc.teamcode;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous

public class redAuto extends OpMode {

    //adds a working sleep function with the format on rest(time);
    public void sleepForMilliseconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //mecanum motors
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;


    //launcher servo
    private Servo launcherServo;

    //stop moving function
    private void stopMoving() {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    //move forward function
    public void moveForward(int length) {
        frontLeftMotor.setPower(-1);
        frontRightMotor.setPower(-1);
        backLeftMotor.setPower(1);
        backRightMotor.setPower(1);
        sleepForMilliseconds(length);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    //move backwards function
    public void moveBackwards(int length) {
        frontLeftMotor.setPower(1);
        frontRightMotor.setPower(1);
        backLeftMotor.setPower(-1);
        backRightMotor.setPower(-1);
        sleepForMilliseconds(length);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    //turn left function
    public void turnLeft(int length) {
        frontLeftMotor.setPower(1);
        frontRightMotor.setPower(-1);
        backLeftMotor.setPower(-1);
        backRightMotor.setPower(1);
        sleepForMilliseconds(length);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    //turn right function
    public void turnRight(int length) {
        frontLeftMotor.setPower(-1);
        frontRightMotor.setPower(1);
        backLeftMotor.setPower(1);
        backRightMotor.setPower(-1);
        sleepForMilliseconds(length);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    //strafe left function
    public void strafeLeft(int length) {
        frontLeftMotor.setPower(1);
        frontRightMotor.setPower(-1);
        backLeftMotor.setPower(1);
        backRightMotor.setPower(-1);
        sleepForMilliseconds(length);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    //strafe right function
    public void strafeRight(int length) {
        frontLeftMotor.setPower(-1);
        frontRightMotor.setPower(1);
        backLeftMotor.setPower(-1);
        backRightMotor.setPower(1);
        sleepForMilliseconds(length);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    @Override
    public void init() {

        //mecanum motors
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeft");
        frontRightMotor = hardwareMap.dcMotor.get("frontRight");
        backLeftMotor = hardwareMap.dcMotor.get("backLeft");
        backRightMotor = hardwareMap.dcMotor.get("backRight");

        //launcher servo
        launcherServo = hardwareMap.servo.get("launcherServo");
        //launcherServo.setPosition(0);
        launcherServo.setPosition(0.75);

    }

    @Override
    public void loop() {
        strafeRight(250);
        requestOpModeStop();
    }
}
