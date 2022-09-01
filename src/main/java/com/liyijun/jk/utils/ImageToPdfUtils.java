package com.liyijun.jk.utils;

import com.lowagie.text.*;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/*
图片转成pdf工具类
 */
@Slf4j
public class ImageToPdfUtils {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");

        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");

        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:8878/api/fdFileupload/file/minio/view/0/74/1657694959234.jpg");

        imageToPdf(list, "D:");
    }


    /**
     * imageUrllist：图片路径集合，
     * mOutputPdfFileName：pdf输出位置
     *
     * @param imageUrllist
     * @param mOutputPdfFileName
     * @return
     */
    public static File imageToPdf(List<String> imageUrllist, String mOutputPdfFileName) {

        String TAG = "PdfManager";
        Document doc = new Document(PageSize.A4, 20, 20, 20, 20);

        //导出的pdf名称，这里使用的是IdWorker
        //导出的pdf名称，这里使用的是IdWorker
        String title = UUID.randomUUID().toString().toUpperCase().replace("-","");
        String address = mOutputPdfFileName + "\\" + title + ".pdf";
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(mOutputPdfFileName + "\\" + address + ".pdf"));
            doc.open();
            for (int i = 0; i < imageUrllist.size(); i++) {

                Image png1 = Image.getInstance(imageUrllist.get(i));
                png1.setAlignment(Image.MIDDLE);
                png1.setBorder(Image.BOX); //边框，
                png1.setBorderWidth(2);//边框宽度
                png1.setBorderColor(Color.BLACK); //边框颜色，
                png1.scaleAbsolute(40, 40);//绝对宽和高
                png1.scalePercent(20); //百分比
                png1.scaleToFit(150,120);//像素大小

                doc.add(png1);

                doc.add(new Phrase("\n"));
                doc.add(new Phrase("\n"));
                doc.add(new Phrase("\n"));

                if (i != 0 && (i+1) % 4 == 0) {
                    doc.newPage();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            doc.close();

        }
        File mOutputPdfFile = new File(mOutputPdfFileName);
        if (!mOutputPdfFile.exists()) {
            mOutputPdfFile.deleteOnExit();
            return null;
        }
        return mOutputPdfFile;
    }

    /**
     * 第一种解决方案 在不改变图片形状的同时，判断，如果h>w，则按h压缩，否则在w>h或w=h的情况下，按宽度压缩
     *
     * @param h
     * @param w
     * @return
     */
    private static int getPercent(float h, float w) {
        int p = 0;
        float p2 = 0.0f;
        if (h > w) {
            p2 = 297 / h * 100;
        } else {
            p2 = 210 / w * 100;
        }
        p = Math.round(p2);
        return p;
    }

    /**
     * 第二种解决方案，统一按照宽度压缩 这样来的效果是，所有图片的宽度是相等的（推荐）
     *
     * @param
     */
    private static int getPercent2(float h, float w) {
        int p = 0;
        float p2 = 0.0f;
        p2 = 530 / w * 100;
        p = Math.round(p2);
        return p;
    }

}