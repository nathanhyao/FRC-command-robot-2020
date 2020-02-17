/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//https://github.com/4627ManningRobotics/2019-DeepSpace

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class TankDrive extends Command {
  public TankDrive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    requires(Robot.chassisDriveTrain);
    //requires a subsystem: ChassisDriveTrain, but you have to create an instance in Robot Class
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double leftStickY_value = Robot.m_oi.GetDriverRawAxis(RobotMap.LEFT_STICK_Y);
    double RightStickY_value = Robot.m_oi.GetDriverRawAxis(RobotMap.RIGHT_STICK_Y);
    //m_oi is an instance of OI and it's located in Robot class.
    //OI class has a method called GetDriverRawAxis, which runs method getRawAxis
    //getRawAxis is a method to get value of axis

    Robot.chassisDriveTrain.setLeftMotors(leftStickY_value);
    Robot.chassisDriveTrain.setRightMotors(RightStickY_value);
    //remember: chassisDriveTrain is an instance of ChassisDriveTrain, and it's stored in Robot class
    //setLeft/RightMotors is a method inside of ChassisDriveTrain class to tell motor controllers value

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  //or called when you call it e.g. in interrupted.
  @Override
  protected void end() {
    Robot.chassisDriveTrain.setLeftMotors(0);
    Robot.chassisDriveTrain.setLeftMotors(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}
