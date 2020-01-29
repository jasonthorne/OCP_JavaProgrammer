package com.android;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.Era;
import java.util.List;
import java.util.stream.Collectors;

public class Examples {
	
	
static void ex1() {
		
		//=================================================DATES AND TIMES ++++++++++++++++++++++++++++++++++++++++++++
		
		System.out.println("\nex1:");
		
		
		/*
		 * There are 3 basic time types in Java:
		 * LocalDate
		 * LocalTime
		 * LocalDateTime
		 * 
		 * There is also a forth type called:
		 * ZonedDateTime, which oracle recommends you avoid using unless you really have to. 
		 * 
		 */
		
		
		//---------recap:
		
		System.out.println("today's date is: " + LocalDate.now()); //YYYY-mm-dd
		System.out.println("today's time is: " + LocalTime.now()); //hr:mm:ss:ss
		System.out.println("today's date & time is: " + LocalDateTime.now()); //YYYY-mm-dd T hr:mm:ss:ss
		
		
		/*
		 * You can't create any of the time types by using the keyword "new" -  LocalDate d1 = new LocalDate();
		 * you have to use one of the static methods to create a LocalDate, localTime opr LocalDateTime
		 * .now() is a static method that returns the current time as a new DateTime
		 */
		
		//---------ZonedDateTime:
		
		/*
		 * This prints out the current time and the locale of the machine this code is running on
		 */
		System.out.println(ZonedDateTime.now());
		
		/*
		 * There is no ZonedDate or ZonedTime
		 */
		
		
		//----------.of()
		
		//this takes 3 ints: 1st is year, 2d is month, 3rd is date
		LocalDate date1 = LocalDate.of(2022, 1, 23); //months and dates start at 0
		
		//month can also be an enum:
		LocalDate date2 = LocalDate.of(3333, Month.OCTOBER, 21);
		
		Month myMonth = Month.APRIL;
		//Month myMonth2 = 3; //will not compile ++++++++++
		
		
		//Day myDay; -no day type
		Year myYear = Year.of(1999);
		Era myEra; //this can be any length of dates
		
		//-----------times:
		
		/*
		 * times can vary in level of detail
		 */
		
		LocalTime time1 = LocalTime.of(14, 15); //hrs & mins
		System.out.println("time1: " + time1);
		
		LocalTime time2 = LocalTime.of(4, 15, 25); //hrs & mins &  sec
		System.out.println("time2: " + time2);
		
		LocalTime time3 = LocalTime.of(13, 20, 45, 89); //hrs & mins & secs
		System.out.println("time3: " + time3);
		
		LocalDateTime ldt1 = LocalDateTime.of(2045, Month.DECEMBER, 30, 20, 15, 45, 10000);
		System.out.println("ldt1: " + ldt1);
		
		//combination of localDate & localTime to create a localDateTime
		LocalDateTime ldt2 = LocalDateTime.of(date1, time2);
		System.out.println("ldt2: " + ldt2);
		
		
		//=============================================================TIMEZONES:
		
		/*
		 * TimeZones have their own data type: ZoneId
		 * 
		 * this class has a number of static methods, just like the localDate, localTime, localDateTime
		 * you cant create a timeZone by using the 'new' keyword 
		 */
		
		//-----------------------------system default:
		
		/*
		 * This is getting the timezone your application is running on
		 */
		System.out.println("timeZone on this machine is: " + ZoneId.systemDefault());
		
		//get all available timezones:
		System.out.println(ZoneId.getAvailableZoneIds());
		
		//count of timeZones:
		System.out.println(ZoneId.getAvailableZoneIds().stream().count());
		
		ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);
		
		List<String>timeZones = ZoneId.getAvailableZoneIds()
						.stream()
						.sorted()
						.filter(s->s.contains("Europe"))
						.sorted()
						.collect(Collectors.toList());
		
		System.out.println(timeZones);
		

		//-----------------------creating a timeZone:
		
		ZoneId shaZone = ZoneId.of("Asia/Shanghai");
		System.out.println("timeZone of shanghai: " + shaZone);
		
		ZonedDateTime zoned1 = ZonedDateTime.of(date1, time1, shaZone);
		System.out.println("timeZone of shanghai: " + zoned1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
