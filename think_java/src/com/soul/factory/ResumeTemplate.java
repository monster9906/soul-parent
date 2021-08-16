package com.soul.factory;

import java.io.*;

/**
 * @author Rich_fu
 * @date 2021/3/29
 */
public class ResumeTemplate implements Cloneable, Serializable {
    private static final long serialVersionUID = 8756895922228278060L;

    private UserPicture userPicture ;

    public void setUserPicture(UserPicture userPicture) {
        this.userPicture = userPicture;
    }

    public UserPicture getUserPicture(){
        return userPicture;
    }

    // 浅拷贝
    public ResumeTemplate clone() throws CloneNotSupportedException {
        ResumeTemplate resumeTemplate = (ResumeTemplate) super.clone();
        return resumeTemplate;
    }

    public ResumeTemplate deepClone() {
        try
        {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            // 获取流对象
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (ResumeTemplate) ois.readObject();
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
