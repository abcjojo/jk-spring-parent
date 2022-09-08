package com.liyijun.jk.utils;

import com.lowagie.text.*;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.itextpdf.text.Rectangle.NO_BORDER;

/*
图片转成pdf工具类
 */
@Slf4j
public class ImageToPdfUtils {
//
//    public static void main(String[] args) {
////        test(null);
//        test("  ");
//        test(" hello");
//        test(" 12345");
//    }
//
//    public static void test(String str) {
//        if (null == str | str.length() == 0) {
//            System.out.println("空串！");
//        } else {
//            System.out.println(str);
//        }
//    }


    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");


        list.add("http://cloud.fdwyjt.com:8878/api/fdFileupload/file/minio/view/0/74/1657694959234.jpg");

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

        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");
        list.add("http://cloud.fdwyjt.com:5001/fdFileupload/file/minio/view/c74d6da7-12d0-4692-ad6c-8d7a7cb0b822.png");


//        imageToPdf(list, "D:");
        picCreatePDF(list, "D:");
    }


    public static String picCreatePDF(List<String> imageUrllist, String mOutputPdfFileName) throws Exception {
        Document doc = new Document(PageSize.A4, 20, 20, 20, 20);
        //            String title = "2002";
        String title = UUID.randomUUID().toString().toUpperCase().replace("-", "");
        String address = mOutputPdfFileName + "\\" + title + ".pdf";
        log.info("pdf生成地址：{}", address);
        try {
            PdfWriter instance = PdfWriter.getInstance(doc, new FileOutputStream(address));
            doc.open(); //打开PDF  默认为第一页
            PdfPTable table = new PdfPTable(3);//设置3列
            for (int i = 1; i <= imageUrllist.size(); i++) {

                Image png1 = Image.getInstance(imageUrllist.get(i - 1));
                png1.setAlignment(Image.MIDDLE);
                png1.scaleAbsolute(40, 40);//绝对宽和高
                png1.scalePercent(20); //百分比
                png1.scaleToFit(150, 120);//像素大小

                PdfPCell cell = new PdfPCell();
                // 水平居中
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                // 垂直居中
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                // 高度
                cell.setFixedHeight(1);
                cell.setBorder(NO_BORDER);
                cell.setImage(png1);
                table.addCell(cell);
                if (i % 12 == 0) {
                    doc.newPage();
                }
                if (i == imageUrllist.size() && imageUrllist.size() % 3 != 0) {
                    int y = imageUrllist.size() % 3;
                    for (int j = 0; j < y; j++) {
                        PdfPCell cell1 = new PdfPCell();
                        cell1.setBorder(NO_BORDER);
                        table.addCell(cell1);
                    }
                }
            }
            //宽度100%
            table.setWidthPercentage(90);
            table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            doc.add(table);

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
        download(mOutputPdfFile, null);
        if (!mOutputPdfFile.exists()) {
            mOutputPdfFile.deleteOnExit();
            return null;
        }
        return address;
    }


    /**
     * @param response
     * @功能描述 下载文件:
     */
    public static void download(File file, HttpServletResponse response) {
        try {
            // path是指想要下载的文件的路径
//            File file = new File(path);
            log.info(file.getPath());
            // 获取文件名
            String filename = file.getName();
            // 获取文件后缀名
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
            log.info("文件后缀名：" + ext);

            // 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();

            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            //attachment表示以附件方式下载 inline表示在线打开 "Content-Disposition: inline; filename=文件名.mp3"
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
//        String title = UUID.randomUUID().toString().toUpperCase().replace("-","");
        String title = "1001";
        String address = mOutputPdfFileName + "\\" + title + ".pdf";
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(address));
            doc.open();
            for (int i = 0; i < imageUrllist.size(); i++) {

                Image png1 = Image.getInstance(imageUrllist.get(i));
                png1.setAlignment(Image.MIDDLE);
//                png1.setBorder(Image.BOX); //边框，
//                png1.setBorderWidth(2);//边框宽度
//                png1.setBorderColor(Color.BLACK); //边框颜色，
                png1.scaleAbsolute(40, 40);//绝对宽和高
                png1.scalePercent(20); //百分比
                png1.scaleToFit(150, 120);//像素大小

                doc.add(png1);

                doc.add(new Phrase("\n"));
                doc.add(new Phrase("\n"));
                doc.add(new Phrase("\n"));

                if (i != 0 && (i + 1) % 4 == 0) {
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