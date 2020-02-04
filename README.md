### springboot 整合多模块项目脚手架基于restful API

项目整合
* springboot
* mybatis&Generator
* swagger&swagger-bootstrap-ui
* mysql5.7
* lombok

运行项目idea上需要安装 `lombok` 插件,如果没有装自行百度安装

#### project-core
项目的核心类库，不依赖其它模块

#### project-dao
项目的数据库访问层，依赖于core模块

#### project-service
项目的服务层，依赖于dao模块

#### project-api
项目的API接口层，依赖于 service 模块

#### project-docs
项目存放文档目录以及sql脚本







