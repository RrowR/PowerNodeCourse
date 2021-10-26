FROM openjdk:11
ENV workdir = /root/eureka/eureka-server
COPY . ${workdir}                # 复制当前文件和当前文件夹一起到这个路径
WORKDIR ${workdir}
EXPOSE 8761
CMD ["java","-jar","04-server-1.0.0.jar"]