package fr.unilim.iut.tirepressuremonitoringsystem;

public class Alarm
{
    SafetyRange safetyrange;
    Sensor sensor;

    boolean alarmOn;
    
    public Alarm(Sensor sensor, SafetyRange safetyRange) {
    	this.sensor=sensor;
    	this.alarmOn=false;
    	this.safetyrange=safetyRange;
    	
    }
    
    public Alarm() {
    	this(new PressureSensor(), new SafetyRange(17,21));
    }
    
    public void check()
    {
        double psiPressureValue = probePsiPressureValue();

        if (isNotInSafetyRange(psiPressureValue))
        {
            activateAlarm();
        }
    }

	private double probePsiPressureValue() {
		return sensor.popNextPressurePsiValue();
	}

	private boolean isNotInSafetyRange(double psiPressureValue) {
		return safetyrange.doesNotContain(psiPressureValue);
	}

	private void activateAlarm() {
		alarmOn = true;
	}

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
