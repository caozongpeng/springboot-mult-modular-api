### springboot 整合多模块项目脚手架基于restful API
如果觉得项目可以帮助到你，请帮忙`Star`支持一下

### 分支说明
* 分支 v1.0.0 脚手架
* 分支 v2.0.0 整合`redis`&`rabbitmq`

项目整合
* JDK1.8
* springboot2.1.5
* mybatis&Generator
* swagger&swagger-bootstrap-ui
* mysql5.7
* lombok

![project](https://github.com/caozongpeng/github-static/blob/master/springboot-mult-modular-api/project.png)

#### project-core
项目的核心类库，不依赖其它模块

![core](https://github.com/caozongpeng/github-static/blob/master/springboot-mult-modular-api/core.png)

#### project-dao
项目的数据库访问层，依赖于core模块

![dao](https://github.com/caozongpeng/github-static/blob/master/springboot-mult-modular-api/dao.png)


#### project-service
项目的服务层，依赖于dao模块

![service](https://github.com/caozongpeng/github-static/blob/master/springboot-mult-modular-api/service.png)


#### project-api
项目的API接口层，依赖于 service 模块

![api](https://github.com/caozongpeng/github-static/blob/master/springboot-mult-modular-api/api.png)

#### project-docs
项目存放文档目录以及sql脚本

### swagger 接口文档管理

访问路径：http://localhost:9100/doc.html

![swagger](https://github.com/caozongpeng/github-static/blob/master/springboot-mult-modular-api/swagger.png)

### 注意项
1.启动项目idea上需要安装 `lombok` 插件,如果没有装自行百度安装
