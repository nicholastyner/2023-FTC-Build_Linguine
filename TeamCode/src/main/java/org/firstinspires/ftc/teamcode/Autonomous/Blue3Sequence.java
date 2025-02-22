package org.firstinspires.ftc.teamcode.Autonomous;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.hardware.Hardware;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

public class Blue3Sequence {
    SampleMecanumDrive drive;
    Hardware hardware;
    Utilities utilities;

    //Trajectories
    TrajectorySequence toGoal;
    TrajectorySequence parkThree;


    Pose2d startPose = new Pose2d(-60,12,Math.toRadians(180));

    public Blue3Sequence(HardwareMap hardwareMap , Utilities utilities){
        hardware = new Hardware();
        hardware.init(hardwareMap);
        this.utilities = utilities;
        drive = new SampleMecanumDrive(hardwareMap);
        drive.setPoseEstimate(startPose);

        toGoal = drive.trajectorySequenceBuilder(startPose)
                .strafeLeft(4)
                .forward(-73)
                .turn(Math.toRadians(-22.5))
                .build();
        parkThree = drive.trajectorySequenceBuilder((toGoal.end()))
                .turn(Math.toRadians(22.5))
                .strafeLeft(-28)
                .forward(24)
                .build();




    }

    public void blue3(){
        drive.followTrajectorySequence(toGoal);
        utilities.outtakeWheel(1);
        utilities.wait(2000);
        utilities.shoot();
        utilities.wait(2000);
        utilities.outtakeWheel(0);
        drive.followTrajectorySequence(parkThree);

    }

}