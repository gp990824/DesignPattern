package javase.gp.oom;

import sun.misc.VM;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @author Gp
 * @create 2020/4/3 15:44
 */
public class DirectBufferMemory {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("堆空间可使用最大内存:"+VM.maxDirectMemory());
        Thread.sleep(1000);
        ByteBuffer.allocateDirect(11 * 1024 * 1024);
    }
}
