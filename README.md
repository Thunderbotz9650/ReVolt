# FRC 2026 ReVolt - Command-Based Template

This repository now contains a command-based Java structure for:
- 4-CIM differential drivetrain (arcade drive)
- Intake subsystem (2 CIM motors)
- Shooter subsystem (2 CIM motors)
- Two Xbox controllers (driver + operator)

## Hardware assumptions
Each CIM motor is connected to a CTRE Talon FX motor controller on CAN.
The code uses `WPI_TalonFX` so it can be used directly with WPILib command-based and `DifferentialDrive`.

## CAN IDs to update
Set your real CAN IDs in `Constants.java`:
- Drive motors: IDs 1-4
- Intake motors: IDs 5-6
- Shooter motors: IDs 7-8

## Controls
### Driver controller (port 0)
- Left stick Y: forward/reverse
- Right stick X: turn


### Operator controller (port 1)
- Y button: shooter full speed
- A button: shooter feed speed
- Right bumper: intake in
- Left bumper: intake out

## Important tuning notes
- Verify inversion on left/right drive sides and on intake/shooter as needed.
- Check motor safety directions before running at full speed.
- Add current limits and ramp rates once your baseline control works