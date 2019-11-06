package junit.text;


import com.yjiuye.utils.ExcleUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InportTest {




    @Test
    public void test01(){
        try{
            Workbook wb = WorkbookFactory.create(new File("C:\\Users\\Administrator.ALJS-20180826YQ.000\\Desktop\\aa.xlsx"));
            Sheet sheet = wb.getSheetAt(0);
            //获取第一行的行数和最后一行的行数
            int firstRowNum = sheet.getFirstRowNum();
            int lastRowNum = sheet.getLastRowNum();
            for (int i = sheet.getFirstRowNum(); i <=sheet.getLastRowNum() ; i++) {
                Row row = sheet.getRow(i);
                //获取每一行中第一列的列数，和每一行中最后一列的列数
                int firstCellNum = row.getFirstCellNum();
                int lastCellNum = row.getLastCellNum();
                //内层for循环代表某一行中的数据
                for (int j =row.getFirstCellNum() ; j <row.getLastCellNum() ; j++) {
                    Cell cell = row.getCell(j);
                    //由于每一个单元格类型不一样,不同的类型取值时需要用到不同的方法
                    String value = ExcleUtils.parseExcleValueToString(cell);
                    if(i>0 &&j == 0){
                        value = value.substring(0,value.indexOf("."));
                    }
                    System.out.print(value+"  ");
                }
                System.out.println();
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    //
    public String parseExcleValueToString(Cell cell){
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
