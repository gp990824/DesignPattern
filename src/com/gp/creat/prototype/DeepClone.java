package com.gp.creat.prototype;

import java.io.*;

/**
 * @author gp
 * @create 2020/2/24 10:29
 */

/**
 * 深拷贝:
 * 先把基本类型出来,引用类型要单独处理
 */
public class DeepClone implements Cloneable, Serializable {
    String name;
    Sheep2 sheep2;

    public DeepClone() {
        super();
    }

    //方式一: 使用clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepClone deepClone = (DeepClone) super.clone();
        deepClone.sheep2 = (Sheep2) sheep2.clone();
        return deepClone;
    }

    //方式二: 使用序列化(推荐)
    public Object deepClone() {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            //序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            //反序列化
            bais = new ByteArrayInputStream(baos.toByteArray());
            ois = new ObjectInputStream(bais);
            DeepClone sheep2 = (DeepClone) ois.readObject();
            return sheep2;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                ois.close();
                bais.close();
                oos.close();
                bais.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
