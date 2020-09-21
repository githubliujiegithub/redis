package com.example.redis.study.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StringExcelListener extends AnalysisEventListener {

    private List<List<String>> datas = new ArrayList<>();

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {

        @SuppressWarnings("unchecked") Map<String, String> stringMap = (Map<String, String>) o;

        datas.add(new ArrayList<>(stringMap.values()));

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public List<List<String>> getDatas() {
        return datas;
    }

    public void setDatas(List<List<String>> datas) {
        this.datas = datas;
    }
}
