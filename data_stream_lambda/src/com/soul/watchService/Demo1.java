package com.soul.watchService;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/9/14-8:27
 */
public class Demo1 {
  public static void main(String[] args) throws IOException {
      Path path = Paths.get(".");
      Files.list(path).forEach(System.out::println);

      // 获取监听对象
      WatchService watchService = path.getFileSystem().newWatchService();

      // 遍历并注册目录
      walkAndRegisterDirectories(path,watchService);

      try {
          while (true){
              WatchKey watchKey = watchService.take();
              for (WatchEvent event : watchKey.pollEvents()) {
                  System.out.println(event.kind());
              }
          }
      } catch (InterruptedException e) {
          e.printStackTrace();
      }


  }

  private static void walkAndRegisterDirectories(Path path, WatchService watchService) throws IOException {
    Files.walkFileTree(path,new SimpleFileVisitor<Path>(){

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            registerDir(dir, watchService);
            return FileVisitResult.CONTINUE;
        }
    });
  }

  private static void registerDir(Path dir, WatchService watchService) throws IOException {
      WatchKey key =  dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE
              , StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
  }
}
