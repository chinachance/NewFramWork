package com.haohao.framwork.haoframwork.utils;

import android.annotation.SuppressLint;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author hao
 * @date 2015-11-20
 * @package com.easttime.beauty.utils
 * @description 时间工具类
 */
@SuppressLint("SimpleDateFormat")
public class TimeUtil {
    public static final long ONE_SECOND = 1000;// 一秒的毫秒值
    public static final long ONE_MINUTE = 60 * ONE_SECOND;// 一分钟的毫秒值
    public static final long ONE_HOUR = 60 * ONE_MINUTE;// 一小时的毫秒值
    public static final long ONE_DAY = 24 * ONE_HOUR;// 一天的毫秒值
    public static final long ONE_MONTH = 30 * ONE_DAY;// 一月的毫秒值
    public static final long ONE_YEAR = 12 * ONE_MONTH;// 一年的毫秒值
    /**
     * 日期格式（yyyy-MM-dd）
     */
    public static final String DATE_TEMPLATE_DATE = "yyyy-MM-dd";
    /**
     * 日期格式（yyyy年MM月dd日）
     */
    public static final String DATE_TEMPLATE_DATE_TWO = "yyyy年MM月dd日";
    /**
     * 日期格式（MM月dd日）
     */
    public static final String DATE_TEMPLATE_DATE_THREE = "MM月dd日";
    /**
     * 日期格式（MM-dd）
     */
    public static final String DATE_TEMPLATE_DATE_THREE_TWO = "MM-dd";
    /**
     * 日期格式（yyyy.MM.dd）
     */
    public static final String DATE_TEMPLATE_DATE_FOUR = "yyyy.MM.dd";
    /**
     * 日期格式（yy.MM.dd）
     */
    public static final String DATE_TEMPLATE_DATE_FOUR_TWO = "yy.MM.dd";
    /**
     * 日期格式（yyyy-MM-dd HH:mm:ss）
     */
    public static final String DATE_TEMPLATE_SECOND = "yyyy-MM-dd HH:mm:ss";
    /**
     * 日期格式（yyyy-MM-dd HH:mm）
     */
    public static final String DATE_TEMPLATE_MINUTE = "yyyy-MM-dd HH:mm";
    /**
     * 时间格式（HH:mm）
     */
    public static final String DATE_TEMPLATE_HOUR_MIN = "HH:mm";
    /**
     * 时间格式（mm:ss）
     */
    public static final String DATE_TEMPLATE_HOUR_MIN_SEC = "HH:mm:ss";
    /**
     * 时间格式（MM月）
     */
    public static final String DATE_TEMPLATE_HOUR = "MM月";


    /**
     * 获取今天日期
     *
     * @param template 日期格式
     * @return
     */
    public static String getTodayTime(String template) {
        if (StringUtil.isEmpty(template)) {
            template = DATE_TEMPLATE_DATE;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(template, Locale.CHINESE);
        return dateFormat.format(new Date());
    }

    /**
     * 获取昨天日期
     *
     * @param template 日期格式
     * @return
     */
    public static String getYesterdayTime(String template) {
        if (StringUtil.isEmpty(template)) {
            template = DATE_TEMPLATE_DATE;
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return new SimpleDateFormat(template).format(cal.getTime());
    }

    /**
     * 获取前n天日期
     *
     * @param template 日期格式
     * @param days 前n天
     * @return
     */
    public static String getBeforeDayTime(String template, int days) {
        if (StringUtil.isEmpty(template)) {
            template = DATE_TEMPLATE_DATE;
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        return new SimpleDateFormat(template).format(cal.getTime());
    }

    /**
     * 获取时间
     *
     * @param template
     * @param calendar
     * @return
     */
    public static String getTime(String template, int calendar) {
        if (StringUtil.isEmpty(template)) {
            template = DATE_TEMPLATE_DATE_TWO;
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, calendar);
        return new SimpleDateFormat(template).format(cal.getTime());
    }

    /**
     * 获取时间
     *
     * @param milliseconds 时间戳
     * @param template     时间格式
     * @return
     */
    public static String getTime(String milliseconds, String template) {
        if (!StringUtil.isEmpty(milliseconds)) {
            return getTime(Long.parseLong(milliseconds), template);
        }
        return "";
    }

    public static String getTime(long milliseconds, String template) {
        if (StringUtil.isEmpty(template)) {
            template = DATE_TEMPLATE_DATE;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(template, Locale.CHINESE);
            return dateFormat.format(new Date(milliseconds));
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 获取日期间相差天数
     *
     * @param startDate 日期格式
     * @param endDate   日期格式
     * @return
     */
    public static int getDaysBetweenNumber(String startDate, String endDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_TEMPLATE_DATE);
            Calendar mCalendar = Calendar.getInstance();
            mCalendar.setTime(sdf.parse(startDate));
            long time1 = mCalendar.getTimeInMillis();
            mCalendar.setTime(sdf.parse(endDate));
            long time2 = mCalendar.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(between_days));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 获取显示时间
     *
     * @param milliseconds 时间戳
     * @return 几秒前, 几分钟前...
     */
    public static String getShowTime(String milliseconds) {
        String showTime = "";
        if (!StringUtil.isEmpty(milliseconds) && !"0".equals(milliseconds)) {
            long currentTime = System.currentTimeMillis();
            long timeDiff = currentTime - Long.parseLong(milliseconds);
            long timeNumber = 0;
            if (timeDiff < 0) {
                showTime = "";
            } else if (timeDiff < ONE_MINUTE) {
                timeNumber = timeDiff / ONE_SECOND;
                showTime = timeNumber + "秒前";
            } else if (timeDiff < ONE_HOUR) {
                timeNumber = timeDiff / ONE_MINUTE;
                showTime = timeNumber + "分钟前";
            } else if (timeDiff < ONE_DAY) {
                timeNumber = timeDiff / ONE_HOUR;
                showTime = timeNumber + "小时前";
            } else if (timeDiff < (ONE_DAY * 10)) {
                timeNumber = timeDiff / ONE_DAY;
                showTime = timeNumber + "天前";
            } else {
                showTime = HaoTimeUtil.getTime(milliseconds, HaoTimeUtil.FORMAT_DATE);
            }
        }
        return showTime;
    }

    public static String getShowTime(long milliseconds) {
        String showTime = "";
        if (milliseconds > 0) {
            long currentTime = System.currentTimeMillis();
            long timeDiff = currentTime - milliseconds;
            long timeNumber = 0;
            if (timeDiff < 0) {
                showTime = "";
            } else if (timeDiff < ONE_MINUTE) {
                timeNumber = timeDiff / ONE_SECOND;
                showTime = timeNumber + "秒前";
            } else if (timeDiff < ONE_HOUR) {
                timeNumber = timeDiff / ONE_MINUTE;
                showTime = timeNumber + "分钟前";
            } else if (timeDiff < ONE_DAY) {
                timeNumber = timeDiff / ONE_HOUR;
                showTime = timeNumber + "小时前";
            } else if (timeDiff < (ONE_DAY * 10)) {
                timeNumber = timeDiff / ONE_DAY;
                showTime = timeNumber + "天前";
            } else {
                showTime = HaoTimeUtil.getTime(milliseconds, HaoTimeUtil.FORMAT_DATE);
            }
        }
        return showTime;
    }

    /**
     * 将日期转换为时间戳
     *
     * @param dateString
     * @param
     * @return
     */
    public static long getTimestamp(String dateString, String template) {
        long temp = 0;
        if (StringUtil.isEmpty(template)) {
            template = DATE_TEMPLATE_DATE;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(template, Locale.CHINESE);
            Date date = dateFormat.parse(dateString);
            temp = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * 剩余毫秒 转 时间格式
     *
     * @param time
     * @param isDay 是否计算天
     * @return
     */
    public static String[] converLongTimeToStr(long time, boolean isDay) {
        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dy = hh * 24;
        //
        long day = 0;
        long hour = 0;
        long minute = 0;
        long second = 0;
        if (isDay) {
            day = time / dy;
            hour = (time - day * dy) / hh;
            minute = (time - day * dy - hour * hh) / mi;
            second = (time - day * dy - hour * hh - minute * mi) / ss;
        } else {
            hour = (time) / hh;
            minute = (time - hour * hh) / mi;
            second = (time - hour * hh - minute * mi) / ss;
        }
        //
        String strDay = day < 10 ? "0" + day : "" + day;
        String strHour = hour < 10 ? "0" + hour : "" + hour;
        String strMinute = minute < 10 ? "0" + minute : "" + minute;
        String strSecond = second < 10 ? "0" + second : "" + second;
        if (isDay) {
            return new String[]{strDay, strHour, strMinute, strSecond};
        } else {
            return new String[]{strHour, strMinute, strSecond};
        }
    }

    /**
     * 解析时间戳
     *
     * @param jsonObject
     * @return
     */
    public static String optTimestamp(JSONObject jsonObject, String keyword) {
        if (keyword != null && !"".equals(keyword) && jsonObject != null) {
            if (!jsonObject.isNull(keyword)) {
                String tempTimestamp = jsonObject.optString(keyword, "0");

                if (tempTimestamp != null && !"".equals(tempTimestamp) && !"null".equals(tempTimestamp)) {
                    if (tempTimestamp.length() < 10) {
                        tempTimestamp = tempTimestamp + "0";
                    }
                    //
                    if (tempTimestamp.startsWith("1")) {
                        tempTimestamp = tempTimestamp + "000";
                    } else {
                        tempTimestamp = tempTimestamp + "00";
                    }
                    String trim = tempTimestamp.replaceAll(" ", "");
                    return trim;
                }
            }
        }
        return "0";
    }

    /**
     * 获取日期区间集合
     *
     * @param startDate
     * @param endDate
     * @return 2016-11-24
     */
    public static List<String> getDateLntervalList(Date startDate, Date endDate) {
        List<String> dateList = new ArrayList<String>();
        if (startDate != null && endDate != null) {
            long startTime = startDate.getTime();
            long endTime = endDate.getTime();
            if (startTime > 0 && endTime > 0 && startTime < endTime) {
                int daysBetweenNumber = TimeUtil.getDaysBetweenNumber(TimeUtil.getTime(startTime, null), TimeUtil.getTime(endTime, null));
                dateList.add(TimeUtil.getTime(startTime, null));
                for (int i = 0; i < daysBetweenNumber; i++) {
                    startTime = startTime + 1000 * 60 * 60 * 24;
                    dateList.add(TimeUtil.getTime(startTime, null));
                }
            }
        }
        return dateList;
    }
}
