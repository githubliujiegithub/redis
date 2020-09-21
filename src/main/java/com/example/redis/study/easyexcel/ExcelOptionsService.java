package com.example.redis.study.easyexcel;


import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class ExcelOptionsService {

    public List<List<String>> writeWithoutHead(InputStream inputStream) {
        StringExcelListener listener = new StringExcelListener();
        ExcelReader excelReader = EasyExcelFactory.read(inputStream, null, listener).headRowNumber(0).build();
        excelReader.read();
        List<List<String>> dates = listener.getDatas();
        excelReader.finish();
        return dates;
    }
}
