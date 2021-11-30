package fr.unilim.iut.tirepressuremonitoringsystem.helper;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fr.unilim.iut.tirepressuremonitoringsystem.PressureSensor;
import fr.unilim.iut.tirepressuremonitoringsystem.Sensor;

public class SensorFactory {

	public static Sensor probe(Double value, Double...values) {
		PressureSensor sensor = mock(PressureSensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(value, values);
		return sensor;
	}

}
