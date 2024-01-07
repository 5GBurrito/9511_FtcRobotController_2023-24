package org.firstinspires.ftc.teamcode; // Replace with your package name

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
@Disabled
public class encoderReseterForArms extends LinearOpMode {

    private DcMotorEx motor1;
    private DcMotorEx motor2;

    @Override
    public void runOpMode() {
        motor1 = hardwareMap.get(DcMotorEx.class, "motor1"); // Replace "motor1" with the actual name of your first motor
        motor2 = hardwareMap.get(DcMotorEx.class, "motor2"); // Replace "motor2" with the actual name of your second motor

        // Set the run mode of both motors to STOP_AND_RESET_ENCODER
        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Set the run mode of both motors to RUN_USING_ENCODER or any other appropriate mode
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        while (opModeIsActive()) {
            // Your teleop control code can go here
        }
    }
}
