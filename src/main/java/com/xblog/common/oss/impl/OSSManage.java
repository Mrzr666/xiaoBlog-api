package com.xblog.common.oss.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xblog.common.oss.OSSInterface;
import com.xblog.common.sysconfig.entity.Config;
import com.xblog.common.sysconfig.mapper.ConfigMapper;
import com.xblog.common.sysconfig.service.ConfigService;
import com.xblog.modules.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;

public class OSSManage extends ServiceImpl<ConfigMapper, Config> implements OSSInterface {

    @Autowired
    private ConfigService configService;

    @Override
    public void uploadFile(String file) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = getEndpoint();
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = getAccessKeyId();
        String accessKeySecret = getAccessKeySecret();
        String bucketName = getBucketName();
        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String objectName = file;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
        String content = "Hello OSS";
        ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));

        // 关闭OSSClient。
        ossClient.shutdown();

    }

    private String getEndpoint(){
        return configService.queryValueByKey("endpoint");
    }
    private String getAccessKeyId(){
        return configService.queryValueByKey("accessKeyId");
    }
    private String getAccessKeySecret(){
        return configService.queryValueByKey("accessKeySecret");
    }
    private String getBucketName(){
        return configService.queryValueByKey("bucketName");
    }
}
