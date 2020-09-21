package com.example.redis;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.example.redis.study.easyexcel.ExcelOptionsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@SpringBootTest
@Slf4j
public class ExcelTest {

    @Autowired
    private ExcelOptionsService excelOptionsService;

    @Test
    void test() throws FileNotFoundException {
        File file = new File("D:\\test.xlsx");

        List<List<String>> lists = excelOptionsService.writeWithoutHead(new FileInputStream(file));

        System.out.println(lists);
    }

    @Test
    void test2() throws FileNotFoundException {
        File file = new File("D:\\test.xlsx");

//        ExcelReaderBuilder read = EasyExcelFactory.read(new FileInputStream(file), new Sheet(1));
//        ExcelReader build = read.build();
//        build.read();
//        System.out.println("fdsf");

    }
}
