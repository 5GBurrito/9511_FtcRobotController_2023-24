package org.firstinspires.ftc.teamcode.old;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp

public class handAndWristTest extends OpMode {

    private Servo wristServo;
    private Servo handServo;

    @Override
    public void init() {
        wristServo = hardwareMap.servo.get("wristServo");
        wristServo.setPosition(0);
        handServo = hardwareMap.servo.get("handServo");
        handServo.setPosition(1);

    }

    @Override
    public void loop() {
        wristServo.setPosition(gamepad1.left_trigger);
        handServo.setPosition(1-gamepad1.right_trigger);

    }
}
