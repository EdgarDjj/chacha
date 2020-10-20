package com.ttt.chacha.chacha.utils;

import com.fasterxml.jackson.core.format.DataFormatMatcher;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;

/**
 * Description:
 * 时间工具类
 * @author:edgarding
 * @date:2020/10/20
 **/
public class DateUtil {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public static Timestamp createTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public static Timestamp timeConvert(String time) {
        return Timestamp.valueOf(time);
    }
}
