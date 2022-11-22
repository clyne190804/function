package common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonDate {
    /**
     * 현재 일자를 리턴한다.
     * ex)2022-11-20
     * @return 현재 일자
     */
    public static String getNowDate(){
        LocalDate localDate = LocalDate.now();
        return localDate.toString().replaceAll("-", "");
    }

    /**
     *
     * 파라미터 형식에 맞는 현재 일자를 리턴한다.
     * ex)2022-11-20 -> 20221120
     * @param str 치환할 문자열
     * @return 파라미터로 치환된 현재 일자
     */
    public String getNowDatePattern(String str){
        LocalDate localDate = LocalDate.now();
        return localDate.toString().replaceAll("-", str);
    }

    /**
     * 현재 시간을 리턴한다.
     * ex)20221120222632 -> 222632
     * @return 현재 시간
     */
    public static String getNowTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")).substring(8);
    }

    /**
     * 현재 일자와 시간을 리턴한다.
     * ex)20221120222632
     * @return 현재 일자와 시간
     */
    public static String getNowDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

}
