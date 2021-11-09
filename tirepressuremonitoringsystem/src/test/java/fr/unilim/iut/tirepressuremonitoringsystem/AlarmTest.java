package fr.unilim.iut.tirepressuremonitoringsystem;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;
public class AlarmTest {

	@Test
	public void alarmOn_when_value_too_low () {
		PressureSensor sensor = probe(16.0);
		Alarm alarm=new Alarm(sensor);
		
		alarm.check();
		
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	public void alarmOn_when_value_too_high () {
		PressureSensor sensor = probe(22.0);
		Alarm alarm=new Alarm(sensor);
		
		alarm.check();
		
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	public void alarmOn_when_value_in_safety_range () {
		PressureSensor sensor = probe(17.0,19.0);
		Alarm alarm=new Alarm(sensor);
		
		alarm.check();
		
		assertFalse(alarm.isAlarmOn());
	}
	
	@Test
	public void alarmOn_when_alarm_activate_at_once () {
		PressureSensor sensor = probe(25.0,19.0);
		Alarm alarm=new Alarm(sensor);
		
		alarm.check();
		
		assertTrue(alarm.isAlarmOn());
		
		alarm.check();
		
		assertTrue(alarm.isAlarmOn());
		
		
	}
	
	private PressureSensor probe(Double value, Double...values) {
		PressureSensor sensor = mock(PressureSensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(value, values);
		return sensor;
	}
	
}
