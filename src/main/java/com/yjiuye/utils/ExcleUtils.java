package com.yjiuye.utils;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcleUtils {
    public static String parseExcleValueToString(Cell cell){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String result = "";
        switch (cell.getCellType()){
            //String类型
            case Cell.CELL_TYPE_STRING:
                result = cell.getStringCellValue();
                break;
            //Boolean类型
            case Cell.CELL_TYPE_BOOLEAN:
                result = String.valueOf(cell.getBooleanCellValue());
                break;
            //数值类型
            case Cell.CELL_TYPE_NUMERIC:
                //这里由于时间类型也在数值类型里面，因此需要判断是否是时间类型
                if(HSSFDateUtil.isCellDateFormatted(cell)){
                    Date date = cell.getDateCellValue();
                    result = sdf.format(date);
                }else {
                    BigDecimal one = new BigDecimal(cell.getNumericCellValue()+"");
                    result = one.toPlainString();
                }
                break;
            default:
                result= "";
        }
        return result;
    }
}
