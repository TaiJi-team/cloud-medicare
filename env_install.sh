# redis standlone
docker run -d --name redis -p 6379:6379 -v /usr/local/redis/config:/etc/redis -v /usr/local/redis/data:/data redis

# nacos
# /opt/nacos/init.d/custom.properties内容如下
# management.endpoints.web.exposure.include=*
docker run -d -p 8848:8848 -e MODE=standalone -v /opt/nacos/init.d/custom.properties:/home/nacos/init.d/custom.properties -v /opt/nacos/logs:/home/nacos/logs --restart always --name nacos nacos/nacos-server




docker run -d -p 8848:8848 -e MODE=standalone -v /home/yuan/data/docker/nacos/init.d/custom.properties:/home/nacos/init.d/custom.properties -v /home/yuan/data/docker/nacos/logs:/home/nacos/logs --name nacos nacos/nacos-server
docker run -d --name redis -p 6379:6379 -v /home/yuan/docker/redis/config:/etc/redis -v /home/yuan/data/docker/redis/data:/data redis


by ${USER}
docker run -d --name redis -p 6379:6379 -v /home/${USER}/docker/redis/config:/etc/redis -v /home/${USER}/data/docker/redis/data:/data redis:latest
docker run -d -p 8848:8848 -e MODE=standalone -v /home/${USER}/data/docker/nacos/init.d/custom.properties:/home/nacos/init.d/custom.properties -v /home/${USER}/data/docker/nacos/logs:/home/nacos/logs --name nacos nacos/nacos-server

# nacos by compose
https://www.jianshu.com/p/e053f016371a


# nacos by redis


# nacos by mysql


