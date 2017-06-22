package com.test;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sichoon.kwon on 2017-06-22.
 */
public class PathMpTest {
    public void fileUpLoad(String bbsSeq) {
        boolean fileUploadCheck = false;

        // bbsSeq는 DB sequence 값이지만 보안진단에 걸려서 안 걸리게 처리
        boolean b = false;
        if(bbsSeq != null && !bbsSeq.equals("")) {
            Pattern p = Pattern.compile("^[0-9]*$");
            Matcher m = p.matcher(bbsSeq);
            b = m.matches();
        }

        if(b) {
            File uploadDirectory = new File("/usr/service/server/cdn32-adp/webapps/upload/support", bbsSeq); // CHANNEL_ID가 폴더명

            if (!uploadDirectory.exists()) {
                uploadDirectory.mkdirs();
                //log.info("uploadDirectory 디렉토리를 생성했습니다.");
            }
            System.out.println("fileUpLoad success");
        }
    }

    public static void main(String[] args) {
        PathMpTest pmt = new PathMpTest();
        pmt.fileUpLoad("1");
    }
}
