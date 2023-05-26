package com.wegether.app.controller;

import com.wegether.app.domain.dto.ThumbnailSize;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@Slf4j
@RequestMapping("/lecture-files/*")
public class LectureFileController {


    //    파일 업로드
    @PostMapping("upload")
    @ResponseBody
    public List<String> upload(@RequestParam("uploadFile") List<MultipartFile> uploadFiles) throws IOException {
        Map<String, ThumbnailSize> sizeMap = new HashMap<>();
        int width = 0, height = 0;
        String path = "C:/upload/" + getPath();
        List<String> uuids = new ArrayList<>();
        File file = new File(path);

        sizeMap.put("upload1", new ThumbnailSize(359, 179));
        sizeMap.put("upload2", new ThumbnailSize(540, 390));
        sizeMap.put("upload3", new ThumbnailSize(800, 1260));


        if(!file.exists()){file.mkdirs();}
        for (int i=0; i<uploadFiles.size(); i++){
            width = sizeMap.get(uploadFiles.get(i).getName()).getWidth();
            height = sizeMap.get(uploadFiles.get(i).getName()).getHeigth();
            uuids.add(UUID.randomUUID().toString());
            uploadFiles.get(i).transferTo(new File(path, uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
            if(uploadFiles.get(i).getContentType().startsWith("image")){
                FileOutputStream out = new FileOutputStream(new File(path, "t_"+ uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
                Thumbnailator.createThumbnail(uploadFiles.get(i).getInputStream(), out, width, height);
                out.close();
            }
        }
        return uuids;
    }




    public String getPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    //    파일 불러오기
    @GetMapping("display")
    @ResponseBody
    public byte[] display(String fileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload/", fileName));
    }

    //    파일 다운로드
    @GetMapping
    public ResponseEntity<Resource> download(String fileName) throws UnsupportedEncodingException {
        Resource resource = new FileSystemResource("C:/upload/" + fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + new String(fileName.substring(fileName.indexOf("_") + 1).getBytes("UTF-8"), "ISO-8859"));
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }



}



















