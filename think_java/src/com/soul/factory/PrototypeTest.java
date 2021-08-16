package com.soul.factory;

/**
 * @author Rich_fu
 * @date 2021/3/29
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        ResumeTemplate resumeTemplate = new ResumeTemplate();
        resumeTemplate.setUserPicture(new UserPicture());

        // 初始对象
        System.out.println("原来用户照片对象："+ resumeTemplate.getUserPicture());

        ResumeTemplate clone = resumeTemplate.clone(); // 浅拷贝获取的对象
        System.out.println("浅拷贝查询用户照片对象："+clone.getUserPicture());

        System.out.println("两个picture是否是同一个："+(resumeTemplate == clone));
        System.out.println("浅拷贝两个用户照片是否是同一个："+(resumeTemplate.getUserPicture() == clone.getUserPicture()));

        // 深拷贝获取对象
        ResumeTemplate picture1 = resumeTemplate.deepClone();
        System.out.println("深拷贝获取到的用户照片对象:"+picture1.getUserPicture());

        System.out.println("深拷贝对象与原生对象是否相等:"+(resumeTemplate == picture1));
        System.out.println("深拷贝两个用户照片是否是同一个："+(resumeTemplate.getUserPicture() == picture1.getUserPicture()));

    }
}
