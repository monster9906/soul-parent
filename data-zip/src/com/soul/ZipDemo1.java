package com.soul;

import com.sun.javafx.scene.shape.PathUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author LingCoder
 * @date 2020/8/11 13:54
 *
 */
public class ZipDemo1 {

    public static void main(String[] args) throws FileNotFoundException {
//        try {
//            zipSingleFile("C:\\Users\\soul\\Desktop\\test\\demo.zip","C:\\Users\\soul\\Desktop\\test\\1.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        List<String> strings = Arrays.asList("C:\\Users\\soul\\Desktop\\test\\1.txt", "C:\\Users\\soul\\Desktop\\test\\2.txt");
//        try {
//            zipListFile(strings,"C:\\Users\\soul\\Desktop\\test\\demo.zip");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //被压缩的文件夹
//        String sourceFile = "C:\\Users\\soul\\Desktop\\test\\zipTest";
//        //压缩结果输出，即压缩包
//        FileOutputStream fos = new FileOutputStream("C:\\Users\\soul\\Desktop\\test\\demo.zip");
//        ZipOutputStream zipOut = new ZipOutputStream(fos);
//        File fileToZip = new File(sourceFile);
//        //递归压缩文件夹
//        try {
//            recursionZipFile(fileToZip, fileToZip.getName(), zipOut);
//            //关闭输出流
//            zipOut.close();
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            unzip("C:\\Users\\soul\\Desktop\\test\\demo.zip","C:\\Users\\soul\\Desktop\\test\\one");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 压缩单个文件
     * @param outPath 压缩输出文件
     * @param inPath 被压缩文件位置
     */
    public static void zipSingleFile(String outPath,String inPath) throws IOException {
        // 输出压缩包
        FileOutputStream fileOutputStream = new FileOutputStream(outPath);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

        // 被压缩文件
        File file = new File(inPath);
        FileInputStream fileInputStream = new FileInputStream(file);

        // 向压缩包中压缩文件
        ZipEntry zipEntry = new ZipEntry(file.getName());
        zipOutputStream.putNextEntry(zipEntry);
        // 缓冲区
        byte[] bytes = new byte[1024];
        int length;
        while ((length=fileInputStream.read(bytes)) >=0 ){
            zipOutputStream.write(bytes,0,length);
        }
        fileInputStream.close();
        zipOutputStream.close();
        fileOutputStream.close();



    }

    /**
     * 压缩多个文件夹
     * @param inpaths 被压缩文件位置位置集合
     * @param outPath  压缩文件输出位置
     */
    public static void zipListFile(List<String> inpaths,String outPath) throws IOException {
        Stream<String> lines = Files.lines( Paths.get(String.valueOf(ClassLoader.getSystemResource(""))));

        // 被压缩包位置
        FileOutputStream fileOutputStream = new FileOutputStream(outPath);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        for (String inpath : inpaths) {
            File file = new File(inpath);
            FileInputStream fileInputStream = new FileInputStream(file);
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipOutputStream.putNextEntry(zipEntry);
            // 缓冲区
            byte[] bytes = new byte[1024];
            int length;
            while ((length=fileInputStream.read(bytes)) >= 0){
                zipOutputStream.write(bytes, 0,length);
            }
            fileInputStream.close();
        }
        zipOutputStream.close();
        fileOutputStream.close();

    }

    /**
     * 将fileToZip文件夹及其子目录文件递归压缩到zip文件中
     * @param fileToZip 文件目录或是文静啊
     * @param fileName 文件目录名称或是文件名称
     * @param zipOutputStream 压缩文件输出流
     */
    public static void recursionZipFile(File fileToZip,String fileName,ZipOutputStream zipOutputStream) throws IOException {
        // 如果是隐藏文件夹就不压缩
        if (fileToZip.isHidden()) {
            return;
        }
        // 压缩对象是一个文件夹
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOutputStream.putNextEntry(new ZipEntry(fileName));
                zipOutputStream.closeEntry();
            }else {
                //如果文件夹不是以“/”结尾，将文件夹结尾加上“/”之后作为压缩箱放入zipOut压缩输出流
                zipOutputStream.putNextEntry(new ZipEntry(fileName + "/"));
                zipOutputStream.closeEntry();
            }
            //遍历文件夹子目录，进行递归的zipFile
            File[] files = fileToZip.listFiles();
            for (File file : files) {
                recursionZipFile(file,fileName +"/"+file.getName(),zipOutputStream);
            }

            return;
        }
        //如果当前的fileToZip不是一个文件夹，是一个文件，将其以字节码形式压缩到压缩包里面
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOutputStream.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOutputStream.write(bytes, 0, length);
        }
        fis.close();

    }

    /**
     * 将压缩包解压到指定文件夹
     * @param fileZip
     * @param dirPath
     */
    public static void unzip(String fileZip,String dirPath) throws IOException {
        // 解压的目标路径
        File file = new File(dirPath);
        byte[] bytes = new byte[1024];
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(fileZip));

        // 获取zip压缩包中的entry,并进行解压操作
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        while (nextEntry != null){
            File newFile = newFile(file, nextEntry);
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zipInputStream.read(bytes)) > 0) {
                fos.write(bytes, 0, len);
            }
            fos.close();
            //解压完成一个entry，再解压下一个
            nextEntry = zipInputStream.getNextEntry();
        }
        zipInputStream.closeEntry();
        zipInputStream.close();
    }

    /**
     * 在解压目标文件夹，新建一个文件
     * @return
     */
    private static File newFile(File dirFile, ZipEntry zipEntry) throws IOException {
        File file = new File(dirFile, zipEntry.getName());
        String destDirPath = dirFile.getCanonicalPath();
        String destFilePath = file.getCanonicalPath();

        if(!destFilePath.startsWith(destDirPath +File.separator)){
            throw new IOException("该解压项在目标文件夹之外: " + zipEntry.getName());
        }
        return file;
    }
}
