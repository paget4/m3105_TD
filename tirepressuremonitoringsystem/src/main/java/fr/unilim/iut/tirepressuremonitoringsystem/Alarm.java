package fr.unilim.iut.tirepressuremonitoringsystem;

public class Alarm
{
    private final double lowPressureThreshold;
    private final double highPressureThreshold;
    
    PressureSensor sensor;

    boolean alarmOn;
    
    public Alarm(PressureSensor sensor) {
    	this.sensor=sensor;
    	this.alarmOn=false;
    	this.lowPressureThreshold=17;
    	this.highPressureThreshold=21;
    }
    
    public Alarm() {
    	this(new PressureSensor());
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
		return psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue;
	}

	private void activateAlarm() {
		alarmOn = true;
	}

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
