package com.xblog.service;

import com.xblog.common.oss.OSSInterface;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OSSTest {

    @Autowired
    private OSSInterface ossInterface;

    @Test
    public void osstest(){
        ossInterface.uploadFile("11.txt");
    }
}
