package com.study.Aworkqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.study.utils.RabbitUtils;

import java.io.IOException;

public class Producer {
    public static void main(String[] args) throws IOException {
        // 2.通过工具类获得连接
        Connection connection = RabbitUtils.getConnection();
        // 3.通过连接获取通道
        Channel channel = connection.createChannel();
        // 使用信道来定义一个队列
        // 4.声明队列
        // 第一个参数：队列名称
        // 第二个参数：是否持久化这个队列
        // 第三个参数：该通道是否独占这个队列
        // 第四个参数：当队列中没有消息以后 是否删除这个队列
        // 第五个参数：这个队列的其他设置（延迟队列时使用）
        channel.queueDeclare("work_queue",true,false,false,null);
        // 第一个参数：交换机的名字 不要写null  如果没有给""
        // 第二个参数：路由/队列名称  当我们没有路由的时候 这个位置写队列名称就可以了
        // 第三个参数：消息的一些属性设置
        // 第四个参数：消息内容
        for (int i = 1; i <= 10 ; i++) {
            channel.basicPublish("","work_queue",null,("this is "+ i +" work_queue msg").getBytes());
        }
        RabbitUtils.close(connection,channel);
        System.out.println("设置完成");
    }
}
