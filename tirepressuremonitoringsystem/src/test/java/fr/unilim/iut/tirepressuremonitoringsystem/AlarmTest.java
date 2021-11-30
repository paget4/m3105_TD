package fr.unilim.iut.tirepressuremonitoringsystem;

import static fr.unilim.iut.tirepressuremonitoringsystem.helper.AlarmBuilder.anAlarm;
import static fr.unilim.iut.tirepressuremonitoringsystem.helper.SensorFactory.probe;
import static org.junit.Assert.*;

import org.junit.Test;

import fr.unilim.iut.tirepressuremonitoringsystem.helper.SensorFactory;

import static org.mockito.Mockito.*;
public class AlarmTest {

	@Test
	public void alarmOn_when_value_too_low () {		
		Alarm alarm1=anAlarm()
				.withSensor(probe(16.0))
				.withSafetyRange(new SafetyRange(17,21))
				.build();
		alarm1.check();
		
		assertTrue(alarm1.isAlarmOn());
	}
	
	@Test
	public void alarmOn_when_value_too_high () {
		Sensor sensor = probe(22.0);
		Alarm alarm=new Alarm(sensor, new SafetyRange(17,21));
		
		alarm.check();
		
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	public void alarmOn_when_value_in_safety_range () {
		Sensor sensor = probe(17.0,19.0);
		Alarm alarm=new Alarm(sensor, new SafetyRange(17,21));
		
		alarm.check();
		
		assertFalse(alarm.isAlarmOn());
	}
	
	@Test
	public void alarmOn_when_alarm_activate_at_once () {
		Sensor sensor = probe(25.0,19.0);
		Alarm alarm=new Alarm(sensor, new SafetyRange(17,21));
		
		alarm.check();
		
		assertTrue(alarm.isAlarmOn());
		
		alarm.check();
		
		assertTrue(alarm.isAlarmOn());
		
		
	}
	
}
