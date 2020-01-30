package com.android;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.Era;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.*;

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
			
			//Always consists of a localDate, LocalTime & a zoneID:
			ZonedDateTime zoned1 = ZonedDateTime.of(date1, time1, shaZone);
			System.out.println("timeZone of shanghai: " + zoned1);
			
			//zone id for Dublin:
			ZoneId irish = ZoneId.of("Europe/Dublin");
			ZonedDateTime irishZone = irishZone=ZonedDateTime.of(LocalDateTime.now(), irish);
			System.out.println(irishZone);
			
			
			//-------------
			
			date1 = LocalDate.of(2035, Month.JUNE, 20);
			time1 = LocalTime.of(14, 35);
			
			//time in US/Eastern in relation to the irishZone time:
			System.out.println(irishZone.withZoneSameInstant(ZoneId.of("US/Eastern")));
			
			//time in Asia/Shanghai in relation to the irishZone time:
			System.out.println(irishZone.withZoneSameInstant(ZoneId.of("Asia/Shanghai")));
			
		}
	
	
	static void ex2() {
		
		//=================================================DATES AND TIMES REVISION 
		System.out.println("\nex2:");
		
		
		//---------------------TIME & PERIODS:
		
		LocalDate d1 = LocalDate.now();
		
		//todays date:
		System.out.println("d1: " + d1);
		
		//add 2 days to it:
		d1 = d1.plusDays(2);
		System.out.println("d1: " + d1);
		
		//add 4 weeks:
		d1 = d1.plusWeeks(4);
		System.out.println("d1: " + d1);
		
		//add 2 mopnths:
		d1 = d1.plusMonths(2);
		System.out.println("d1: " + d1);
		
		//add 4 years:
		d1 = d1.plusYears(4);
		System.out.println("d1: " + d1);
		
		
		//minus works in exactly the same way:
		d1 = d1.minusWeeks(3);
		System.out.println("d1: " + d1);
		
		
		//----------------------
		
		d1 = LocalDate.now();
		
		//you can chain the minus & the plus methods:
		d1 = d1.plusWeeks(4).plusMonths(2).plusDays(5).minusDays(3);
		System.out.println("d1: " + d1);
		
		/*
		 * You can add and subtract hours, mins, secs, nanosecs to a time and dateTime
		 * can add days, months to a date and a dareTime
		 * Cant add days, hours, months, years to a time
		 * Cant add hours, mins, secs, nanosecs to a date.
		 */
	
	}
	
	
	static void ex3() {
		
		//=================================================PERIODS
		System.out.println("\nex3:");
		
		//periods work for dates:
		
		/*
		 * if we leave in plus days  we get wrong result 
		 * when we first ran this it was the 29th of jan. so this looked for a 31 feb. 
		 * so it goes first to the end of feb and the ngoes to the 29th of every other month.
		 */
		
		LocalDate start = LocalDate.now(); //.plusDays(2);
		LocalDate finish = start.plusMonths(10);
		
		while(start.isBefore(finish)) {
			System.out.println("date is: " + start);
			start=start.plusMonths(1);
		}
		
		//----------------periods:
		
		/*
		 * We can use periods to define a set amount of days & months
		 * 
		 */
		
		
		Period p1 = Period.ofDays(2); //.ofMonths(4); //these CANR BE CHAINED
		
		LocalDate today = LocalDate.now();
		//you can't know the exact time period of period until you use it with a date. 
		System.out.println("2 days in the future: " + today.plus(p1));
		
		
		//=================================================DURATIONS
		
		/*
		 * Durations are for time. 
		 * These work for times and dateTimes
		 * 
		 * Like periods these CANT BE CHAINED
		 */
		
		Duration dur1 = Duration.ofHours(2);
		System.out.println("2 hours in the future: " + LocalTime.now().plus(dur1));
		
		
		//------
		
		/*
		 * This loop goes 100 times, but localTime doesnt display any dates, 
		 * so this goes forward 96 times, which is 48 hours, so its the same time 2 days in the future.
		 * But localTime cannot display dates so four more iteration of the loop will give 2 hours in the future.
		 */
		
		LocalTime now = LocalTime.now();
		
		for(int i=0;i<100;i++) {
			now= now.plus(dur1);
		}
		
		
		System.out.println("now: " + now);
		
		//----------
		
		
		LocalDateTime dateTimeNow = LocalDateTime.now();
		
		for(int i=0;i<100;i++) {
			dateTimeNow= dateTimeNow.plus(dur1);
		}
		
		System.out.println("dateTimeNow: " + dateTimeNow);
		
		
		//==========================================================
		
		System.out.println("p1: " + p1); //p1 was originally 2 days. 
		p1 = p1.plusMonths(4); //now its 4 months & 2 days.
		System.out.println("p1: " + p1); 
		
		
		System.out.println(p1.getMonths()); //this will only display the amount of months (4)
		System.out.println(p1.getDays()); //this will only display the amount of days (2)
		
		
		//------------
		
		/*
		 * Periods do not store weeks, only months, days & years. 
		 */
		
		p1 = p1.plusYears(5);
		System.out.println(p1); //this is now 5 years, 4 months & 2 days (P5Y4M2D)
		
		
		//------------
		
		
		//get years
		
		System.out.println(p1.getYears()); 
		
		//A period of weeks is stored as days: ++++++++++++++++++++++++++++++++++++++
		Period per2 = Period.ofWeeks(4);
		System.out.println("per2 is 4 weeks which is: " + per2);
		
		
		//================================
		
		LocalDate future = today.plusMonths(4).plusYears(3).plusWeeks(19).plusDays(678);
		System.out.println("future: " + future);
		
		Period between = Period.between(today, future);
		System.out.println("between: " + between);
		
		/*
		 * to check this is right, we add our periods onto today's date and we should get the same future date
		 */
		
		System.out.println("today.plus(between): " + today.plus(between));

	}
	
	
	static void ex4() {
		
		//=================================================DIFFERENT TYPES OF DURATION
		System.out.println("\nex4:");
		
		//duration is for times:
		//if you have a duraion for days, this will print our hours.
		Duration daily = Duration.ofDays(2);
		System.out.println("daily: " + daily);
		
		Duration hourly = Duration.ofHours(2);
		System.out.println("hourly: " + hourly);
		
		//any duration longer than an hour, (if you use minutes) will be stored as hours.
		Duration minutes = Duration.ofMinutes(333);
		System.out.println("minutes: " + minutes);
		
		//any duration longer than an hour, (if you use minutes) will be stored as hours.
		Duration everyMinute = Duration.ofSeconds(60);
		System.out.println("everyMinute: " + everyMinute);
		
		Duration lotSeconds = Duration.ofSeconds(3661); //one hour, one min, and one sec.
		System.out.println("lotSeconds: " + lotSeconds);
		
		Duration.ofMillis(100); //millisecs
		Duration.ofNanos(100); ///nanoseconds
		
		//---------------------------------CHRONOUNITS 
		
		/*
		 * 
		 */
		
		daily = Duration.of(1, ChronoUnit.DAYS);
		hourly = Duration.of(1, ChronoUnit.HOURS);
		
		/*
		 * Duration only works for TIMES. Once you go over days this will not compile ++++++++++++++++++++++++++
		 */
		//System.out.println(Duration.of(7, ChronoUnit.CENTURIES));
		
		everyMinute=Duration.of(10, ChronoUnit.MINUTES);
		
		System.out.println(everyMinute);
		System.out.println(Duration.of(10, ChronoUnit.MINUTES));
		
		
		//--------------------
		
		LocalTime midnight = LocalTime.MIDNIGHT;
		System.out.println("time to midnight: " + midnight);
		
		LocalTime now = LocalTime.now();
		System.out.println("time now: " + now);
		
		
		//time period between now & midnight:
		System.out.println(ChronoUnit.SECONDS.between(now, midnight)); //the amount of seconds from midnight
		
		System.out.println(Duration.of(ChronoUnit.SECONDS.between(now, midnight), ChronoUnit.SECONDS));
		
		//-----------------
		
		LocalDateTime td1 = LocalDateTime.now();
		LocalDateTime td2 = td1.plusDays(13).plusHours(4).plusMinutes(20);
		
		System.out.println(td1);
		System.out.println(td2);
		
		System.out.println(ChronoUnit.MINUTES.between(td1, td2));
		System.out.println(ChronoUnit.DAYS.between(td1, td2));
		
		
		td2 = td1.plusWeeks(100).plusMonths(50).plusDays(100).plusYears(70);
		System.out.println(ChronoUnit.MINUTES.between(td1,  td2));
		
		System.out.println("years between td1 & td2: " + ChronoUnit.YEARS.between(td1, td2));
		
		
		/*
		 * You can use durations with LocalTimes and LocalDateTimes, but you cant use durtations with LocalDates +++++++++++++++++++++++++++++++++++
		 * 
		 * everyMinute is a duration so you can add this to a localDateTime:
		 */
		System.out.println(td1.plus(everyMinute));
		
		//You CANT add it to a LocalDate:
		//LocalDate.now().plus(everyMinute);
		
		//-------------
		
		//Periods DONT take ChronoUnits:
		//Period per1=Period.of(years, months, days);
		
		System.out.println(td1.plus(everyMinute).plus(lotSeconds)); //++++++++++++++++you CAN chain these as their NOT PERIODS or DURATIONS (which CANT be chained)++++++
		

	}
	
	
	static void ex5() {
		
		//=================================================INSTANT
		System.out.println("\nex5:");
		
		/*
		 * Instant is a particular point in time in the GMT time zone
		 * 
		 * So for instance, if the current GMT time is 13:00 this will be the same on the machine in Tokyo or London
		 */
		
		Instant now = Instant.now();
		
		System.out.println("now: " + now);
		
		long j=0;
		
		for(long i=0;i<1_200_000_000L;i++) {
			j=j+1;
		}
		
		System.out.println(j);
		Instant later = Instant.now();
		
		Duration duration=Duration.between(now, later);
		
		System.out.println("duration: " + duration.toNanos());
		
		
		//----------------------
		
		now = Instant.now();
		/*
		 * cooment this out to see how long it takes a stream to create 1.2 billion Integer wrapper objects (approx 9 secs)
		 */
		//Stream.iterate(0, n-> n+1).limit(1200000000).count();	//.collect(Collectors.toList());
		later = Instant.now();
		
		System.out.println("duration2: " + Duration.between(now, later).toMillis());
		
		
		//--------------------
		
		LocalDateTime ldt1 = LocalDateTime.of(LocalDate.now().plusDays(27), LocalTime.now().plusMinutes(72));
		
		System.out.println(ldt1);
		
		
		/*
		 * this is the offSet of Paris. paris is one hour ahead of GMT.
		 * We are asuming the above date was on a machine in paris.
		 */
		ZoneOffset zOffset = ZoneOffset.ofHours(-1); 
		System.out.println(ldt1.toInstant(zOffset)); //this will be GMT, which is instant time.
		
		//------------using ZoneId:
		
		LocalDate date=LocalDate.of(2022, Month.JULY, 2);
		LocalTime time = LocalTime.of(14, 25);
		
		ZoneId zone = ZoneId.of("Asia/Shanghai");
		
		ZonedDateTime zonedDateTime = ZonedDateTime.of(date,  time, zone);
		System.out.println("zonedDateTime: " + zonedDateTime); //the plus 8 it is 8 hours ahead of GMT.
		
		Instant instant2 = zonedDateTime.toInstant();
		System.out.println("instant2: " + instant2);
		
		
		//-------------
		
		zone = ZoneId.of("Asia/Shanghai");
		
		//this is the current time applied to Shanghi timezone, so this will print out: 2:12 in the afternoon. 
		zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zone);
		System.out.println("zonedDateTime: " + zonedDateTime); //the plus 8 it is 8 hours ahead of GMT.
		
		//the GMT time when it was 2:12 in shanghai was 8 hours before which will be 6:12 in the morning.
		
		instant2 = zonedDateTime.toInstant();
		System.out.println("instant2: " + instant2);
		
		
		
		
		

	}
	

}
