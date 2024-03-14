package org.example;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeApi {
  private static final String OFFSET_UA = "+02:00";
  private static final DateTimeFormatter DATE_FORMATTER =
    DateTimeFormatter.ofPattern("d MMM yyyy");
  private static final DateTimeFormatter DATE_TIME_FORMATTER =
    DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");
  private static final int YEAR_INDEX = 0;
  private static final int MONTH_INDEX = 1;
  private static final int DAY_INDEX = 2;
  public enum DateTimePart {
    FULL, YEAR, MONTH, DAY, HOURS, MINUTES, SECONDS
  }

  public String todayDate(DateTimePart datePart) {
    // depending on value return String representation of specific date's part
    switch (datePart) {
      // return current year
      case YEAR:
        return String.valueOf(LocalDate.now().getYear());
      // return current month
      case MONTH:
        return String.valueOf(LocalDate.now().getMonth());
      // return current day of month
      case DAY:
        return String.valueOf(LocalDate.now().getDayOfMonth());
      // return whole date in such format 'yyyy-MM-dd'
      case FULL:
        return String.valueOf(LocalDate.now());
      /*
        in case if passed 'datePart' doesn't exist
        throw DateTimeException
      */
      default:
        throw new DateTimeException("Wrong request!");
    }
  }

  public LocalDate getDate(Integer[] dateParams) {
    // check if dateParams's length is valid
    if (dateParams.length != 3) {
      // in case if it's not valid throw DateTimeException
      throw new DateTimeException("Invalid input parameters.");
    }
    // form LocalDate of dateParams elements
    return LocalDate.of(
      dateParams[YEAR_INDEX],
      dateParams[MONTH_INDEX],
      dateParams[DAY_INDEX]
    );
  }

  public LocalTime addHours(LocalTime localTime, Integer hoursToAdd) {
    // add needed number of hours to passed time and return it
    return localTime.plusHours(hoursToAdd);
  }

  public LocalTime addMinutes(LocalTime localTime, Integer minutesToAdd) {
    // add needed number of minutes to passed time and return it
    return localTime.plusMinutes(minutesToAdd);
  }

  public LocalTime addSeconds(LocalTime localTime, Integer secondsToAdd) {
    // add needed number of seconds to passed time and return it
    return localTime.plusSeconds(secondsToAdd);
  }

  public LocalDate addWeeks(LocalDate localDate, Integer numberOfWeeks) {
    // add needed number of weeks to passed date and return it
    return localDate.plusWeeks(numberOfWeeks);
  }

  public String beforeOrAfter(LocalDate someDate) {
    LocalDate today = LocalDate.now();
    // check if passed date is after today's date
    return someDate.isAfter(today)
      // if true then return 'some_date is after today_date'
      ? someDate + " is after " + today
      // if false then check if passed date is before today's date
      : someDate.isBefore(today)
      // if true then return 'some_date is before today_date'
      ? someDate + " is before " + today
      // if false then return 'some_date is today'
      : someDate + " is today";
  }

  public LocalDateTime getDateInSpecificTimeZone(String dateInString, String zone) {
    // variable for storing parsed date as Instant (timestamp)
    Instant instant = Instant.parse(dateInString);
    // variable for storing date and time at the passed zone
    ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of(zone));
    // convert ZoneDateTime -> LocalDateTime and return it
    return zonedDateTime.toLocalDateTime();
  }

  public OffsetDateTime offsetDateTime(LocalDateTime localTime) {
    // variable for storing zone offset of Ukraine
    ZoneOffset zoneOffset = ZoneOffset.of(OFFSET_UA);
    /*
      form OffsetDateTime using passed time
      and zone offset of Ukraine and return it
    */
    return OffsetDateTime.of(localTime, zoneOffset);
  }

  public LocalDate parseDate(String date) {
    // parse date passed in such format 'yyyyMMdd', using existent DateTimeFormatter
    return LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
  }

  public LocalDate customParseDate(String date) {
    // parse date passed in such format 'd MMM yyyy', using custom DateTimeFormatter
    return LocalDate.parse(date, DATE_FORMATTER);
  }

  public String formatDate(LocalDateTime dateTime) {
    /*
      convert LocalDateTime -> String in such format 'dd MMMM yyyy HH:mm',
      using custom DateTimeFormatter
    */
    return dateTime.format(DATE_TIME_FORMATTER);
  }
}
