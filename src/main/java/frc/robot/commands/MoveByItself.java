/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveByItself extends Command {

  double moveTime, moveRightSpeed, moveLeftSpeed;
  
  public MoveByItself(double time, double rightSpeed, double leftSpeed) {
    this.moveTime = time;
    this.moveRightSpeed = rightSpeed;
    this.moveLeftSpeed = leftSpeed;

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.chassisDriveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.chassisDriveTrain.setLeftMotors(moveLeftSpeed);
    Robot.chassisDriveTrain.setRightMotors(moveRightSpeed);
    setTimeout(moveTime);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //return false;
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.chassisDriveTrain.setLeftMotors(0);
    Robot.chassisDriveTrain.setRightMotors(0);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
