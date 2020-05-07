package com.gp.principle;

/**
 * @author gp
 * @create 2020/2/18 20:39
 */

/**
 * 单一职责原则,每个模块都只负责某个特定的功能
 * 注意事项和原则:
 * 降低类的复杂度,一个类只负责一项职责
 * 提高类的可读性,可维护性
 * 降低变更引起的风险
 * 通常情况下:我们应当准守单一职责原则,只有当逻辑足够简单,才可以在代码级别违反单一职责原则
 * 只要类中方法数量足够少,可以在方法级别保持单一职责原则,否则,必须在类级别保持单一职责原则
 */
public class SingleResponsibility {
    public static void main(String[] args) {
        LoadRun loadRun = new LoadRun();
        AirRun airRun = new AirRun();
        WaterRun waterRun = new WaterRun();

        loadRun.run("法拉利");
        loadRun.run("H2R");
        airRun.run("波音747");
        waterRun.run("泰坦尼克号");

        System.out.println("-------------");
        Run run = new Run();
        run.runAir("歼15");
        run.runLoad("迈凯伦");
        run.runWater("辽宁舰");
    }
}

//拆分成每一个方法,各行其职
class Run {
    public void runLoad(String name) {
        System.out.println(name + "只能在陆地上运作!");
    }

    public void runAir(String name) {
        System.out.println(name + "只能在空中运作!");
    }

    public void runWater(String name) {
        System.out.println(name + "只能在水面上运作!");
    }
}

//将每个功能拆分成单独的一个类,缺点就是内存空间占用大
class LoadRun {
    public void run(String name) {
        System.out.println(name + "只能在陆地运作!");
    }
}

class AirRun {
    public void run(String name) {
        System.out.println(name + "只能在空中运作!");
    }
}

class WaterRun {
    public void run(String name) {
        System.out.println(name + "只能在水面上运作!");
    }
}