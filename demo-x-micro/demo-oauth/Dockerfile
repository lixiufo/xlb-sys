##依赖镜像
FROM amazoncorretto:11

MAINTAINER Yi.Pig  <wpf_1413@foxmail.com>

##工作目录
VOLUME /tmp

#拷贝文件
ADD demo-oauth-0.0.1.jar demo-oauth.jar

#修改时区
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \ 
    echo 'Asia/Shanghai' >/etc/timezone

##暴露端口 docker-compose 接管
##EXPOSE 8761

##应用部署后执行命令  docker-compose 接管启动配置
##ENTRYPOINT ["java","-jar","/demo-oauth-0.0.1.jar","--spring.profiles.active=prod"]
ENTRYPOINT ["java","-jar","/demo-oauth.jar"]