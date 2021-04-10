package org.nerdcore.PatientIntake;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarTest {

    @Test
    public void allowEntryOfAnAppointment() {
        ClinicCalendar calendar = new ClinicCalendar();
        calendar.addAppointment("John", "Pitts","avery", "1/7/2021 12:00 PM");
        List<PatientAppointment> appointments = calendar.getAppointments();
        assertNotNull(appointments);
        assertEquals(1, appointments.size());
        PatientAppointment appt = appointments.get(0);
        assertEquals("John", appt.getPatientFirstName());
        assertEquals("Pitts", appt.getPatientLastName());
        assertEquals(Doctor.avery, appt.getDoctor());
        assertEquals("1/7/2021 12:00 PM",
                appt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")));

    }

}