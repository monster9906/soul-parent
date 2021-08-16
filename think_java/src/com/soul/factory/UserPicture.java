package com.soul.factory;

import java.io.Serializable;

/**
 * @author Rich_fu
 * @date 2021/3/29
 */
public class UserPicture implements Cloneable, Serializable {
    private static final long serialVersionUID = 8756895922228278060L;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
