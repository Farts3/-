package com.ruoyi.system.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberToAmountInWords {

    public static String numberToAmountInWords(BigDecimal number) {
        // 处理整数部分
        long integerPart = number.longValue();
        String integerPartInWords = integerPartToWords(integerPart);

        // 处理小数部分
        BigDecimal decimalPart = number.remainder(BigDecimal.ONE);
        if (decimalPart.compareTo(BigDecimal.ZERO) == 0) {
            return integerPartInWords + "整";
        } else {
            int decimalPlaces = decimalPart.scale();
            decimalPart = decimalPart.setScale(2, RoundingMode.DOWN);
            int fraction = decimalPart.multiply(BigDecimal.valueOf(100)).intValue();
            String decimalPartInWords = decimalPartToWords(fraction);
            return integerPartInWords + "" + decimalPartInWords;
        }
    }

    private static String integerPartToWords(long number) {
        if (number == 0) {
            return "零";
        }

        String[] bigUnits = {"", "万", "亿", "万亿"};
        String[] smallUnits = {"", "十", "百", "千"};
        String result = "";
        int bigUnitIndex = 0;

        while (number > 0) {
            int section = (int) (number % 10000);
            if (section!= 0) {
                String sectionStr = "";
                int smallUnitIndex = 0;
                while (section > 0) {
                    int digit = section % 10;
                    if (digit!= 0) {
                        sectionStr = chineseDigit(digit) + smallUnits[smallUnitIndex] + sectionStr;
                    } else if (sectionStr.length() > 0 && sectionStr.charAt(0)!= '零') {
                        sectionStr = "零" + sectionStr;
                    }
                    section /= 10;
                    smallUnitIndex++;
                }
                result = sectionStr + bigUnits[bigUnitIndex] + result;
            }
            number /= 10000;
            bigUnitIndex++;
        }

        return result + "元";
    }

    private static String decimalPartToWords(int fraction) {
        if (fraction == 0) {
            return "";
        }
        String result = "";
        int jiao = fraction / 10;
        int fen = fraction % 10;
        if (jiao > 0) {
            result += chineseDigit(jiao) + "角";
        }
        if (fen > 0) {
            result += chineseDigit(fen) + "分";
        }
        return result;
    }

    private static String chineseDigit(int digit) {
        switch (digit) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            default:
                return "";
        }
    }


}