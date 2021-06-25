package day04.ballgame;

import java.awt.*;

public class BallGame01 extends Frame {
    // 球桌和桌球图片
    Image ball = Toolkit.getDefaultToolkit().getImage("JavaSE/images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("JavaSE/images/desk.jpg");
    // 桌球的起始位置
    double x = 100;
    double y = 100;
    // 桌球移动的初始角度60°
    double degree = 3.14 / 3;

    /**
     * 绘制一次桌面和桌球
     */
    public void paint(Graphics g) {
        // 绘制一次桌面和桌球
        System.out.println("窗口被画了一次！");
        // 绘制桌面
        g.drawImage(desk, 0, 0, null);
        // 绘制桌球
        g.drawImage(ball, (int) x, (int) y, null);
        // 桌球的下一次坐标位置
        x = x + 10 * Math.cos(degree);
        y = y + 10 * Math.sin(degree);
        // 到了球桌四个边框后桌球角度的变化
        // 1.如果到了底部，就要变角度
        if (y > 480 - 30 - 40) {
            degree = -degree;
        }
        // 2.如果到了右边界，就要变角度
        if (x > 856 - 30 - 40) {
            degree = 3.14 - degree;
        }
        // 3.如果到了上边界，就要变角度
        if (x < 20 + 20) {
            degree = 3.14 - degree;
        }
        // 4.如果到了左边界，就要变角度
        if (y < 20 + 20) {
            degree = -degree;
        }
    }

    /**
     * 绘制多次次桌面和桌球
     */
    void launchFrame() {
        // 设置窗口大小
        setSize(856, 480);
        // 设置窗口距离屏幕左上角位置
        setLocation(50, 50);
        // 设置窗口标题
        setTitle("动力节点--程序猿作品");
        // 设置窗口显示
        setVisible(true);
        // 每隔40毫秒绘制一次桌面和桌球
        while (true) {
            // 重画窗口！
            repaint();
            // 睡眠40毫秒
            try {
                Thread.sleep(40);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("动力节点--程序猿作品！");
        BallGame01 bg = new BallGame01();
        bg.launchFrame();
    }
}