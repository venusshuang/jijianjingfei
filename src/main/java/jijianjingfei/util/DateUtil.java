package jijianjingfei.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static String getDate_Short(String ppDateString) {
		SimpleDateFormat mmDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date mmDate = mmDateFormat.parse(ppDateString);
			return mmDateFormat.format(mmDate);
		} catch (ParseException e) {
			return "";
		}
	} 

	public static Date AddMonth(Date ppDate, int ppAddNum) {
		Calendar mmCalendar = Calendar.getInstance();
		mmCalendar.setTime(ppDate);
		mmCalendar.add(Calendar.MONTH, ppAddNum);

		return mmCalendar.getTime();
	}

	public static Date convertStringToDate(String ppDateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(ppDateString);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date convertShortStringToMonth(String ppDateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		try {
			return sdf.parse(ppDateString);
		} catch (ParseException e) {
			return null;
		}
	}
 
	public static Date convertShortStringToDate(String ppDateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(ppDateString);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String getDateStart(Date ppDate) {
		Calendar mmCalendar = Calendar.getInstance();
		mmCalendar.setTime(ppDate);
		return mmCalendar.get(Calendar.YEAR) + "-"
				+ (mmCalendar.get(Calendar.MONTH) + 1) + "-"
				+ mmCalendar.get(Calendar.DAY_OF_MONTH) + " 0:00:00";
	}

	public static String getDateEnd(Date ppDate) {
		Calendar mmCalendar = Calendar.getInstance();
		mmCalendar.setTime(ppDate);
		return mmCalendar.get(Calendar.YEAR) + "-"
				+ (mmCalendar.get(Calendar.MONTH) + 1) + "-"
				+ mmCalendar.get(Calendar.DAY_OF_MONTH) + " 23:59:59";
	}

	public static String getDate_CN_Today() {
		return getDate_CN(new Date());
	}

	public static String getDate_CN(Date ppDate) {
		SimpleDateFormat mmDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		return mmDateFormat.format(ppDate);
	}

	public static String getWeekDay_CN_Today() {
		return getWeekDay_CN(new Date());
	}

	public static String getWeekDay_CN(Date ppDate) {
		SimpleDateFormat mmDateFormat = new SimpleDateFormat("E");
		String mmWeekDay = mmDateFormat.format(ppDate);

		return mmWeekDay;
	}

	public static String getWeekStartString(Date ppDate) {
		Calendar mmCalendar = Calendar.getInstance();
		mmCalendar.setTime(ppDate);
		int mmWeekDay = mmCalendar.get(Calendar.DAY_OF_WEEK) - 1;

		mmCalendar.add(Calendar.DATE, (mmWeekDay * -1) + 1);
		return DateUtil.getDateStart(mmCalendar.getTime());
	}

	public static String getWeekEndString(Date ppDate) {
		Calendar mmCalendar = Calendar.getInstance();
		mmCalendar.setTime(ppDate);
		int mmWeekDay = mmCalendar.get(Calendar.DAY_OF_WEEK) - 1;

		mmCalendar.add(Calendar.DATE, 7 - mmWeekDay);
		return DateUtil.getDateEnd(mmCalendar.getTime());
	}

	public static Date getWeekStart(Date ppDate) {
		return DateUtil
				.convertStringToDate(DateUtil.getWeekStartString(ppDate));
	}

	public static Date getWeekEnd(Date ppDate) {
		return DateUtil.convertStringToDate(DateUtil.getWeekEndString(ppDate));
	}
}
