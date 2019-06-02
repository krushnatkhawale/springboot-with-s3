package com.example.controller;

import com.example.service.SpringCloudS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProxyController {

    @Autowired
    private SpringCloudS3Service s3Service;

    @GetMapping("/buckets")
    public List<String> listBuckets() {
        return s3Service.listBuckets();
    }

    @GetMapping("/buckets/{bucketName}/docs")
    public List<String> listDocs(@PathVariable String bucketName) {
        return s3Service.listDocs(bucketName);
    }

    @GetMapping("/buckets/{bucketName}/docs/{docName}")
    public String contents(@PathVariable String bucketName, @PathVariable String docName) {
        return s3Service.getContents(bucketName, docName);
    }
}