
# 功能点

## 业界较为流行的模块划分

- api 所有接口包文件，可以单独打包对外提供服务
- common 抽象基础服务下沉，如调用第三方服务、本系统各模块通用服务
- server 本系统核心业务模块
- main 本系统web各种配置模块，启动类，启动配置项等

## 增益功能

1. 出参、入参包装（可以开启和关闭）
2. 日志aop记录，可以抓取当前时间、调用方法、uri、ip地址、出参、入参
3. 统一异常捕获、自定义系统异常
4. 自定义异常捕获、系统异常捕获
5. 分布式id生成器，雪花id生成器
6. 时间工具类、本地host工具类、IP工具类、正则表达式工具类

# 使用

## 生成骨架

在maven项目下，执行 `mvn archetype:create-from-project`，在 `target/generated-sources/archetype` 目录下生成 `Archetype project`

## 安装骨架到本地

1. `cd target/generated-sources/archetype`
2. `mvn install` 安装 `archetype project` 到本地仓库
3. `mvn install` 后，会在本地的maven仓库，按照maven坐标创建对应的archetype文件

注意：*骨架的ArtifactId默认使用当前且添加后缀-archetype*

## 使用自定义模板

### step by step

1. 查看本地，在当前的目录下，`mvn archetype:generate -DarchetypeCatalog=local` 查看本地archetype列表
2. 选择使用，选择 `choose number` 按步骤输入基本参数 `groupId`, `artifactId`, `version`, `package`
3. 随后在当前目录下，以 `artifactId` 为目录创建一个新的项目

### one step

在新开的项目路径下执行以下命令

```
mvn archetype:generate \
-DgroupId=com.jelly.boot \
-DartifactId=demo \
-Dversion=1.0.0-SNAPSHOT \
-DarchetypeGroupId=com.jelly \
-DarchetypeArtifactId=scaffold \
-DarchetypeVersion=1.0 -X -DarchetypeCatalog=local 
```

### 在 IDEA 中使用自定义模板

1. File->New-> Project
2. 选择Create from archetype
3. Add Archetype
4. 输入 *刚创建的骨架*

>GroupId：xx.xx.xx
>ArtifactId：xx-xx-archetype
>Version：1.0-SNAPSHOT
>Repository(option)：local

5. 随后点击Next
6. 输入 *新的项目标识* , `groupId`, `artifactId`, `version`, `package`
7. 修改生成的项目结构为所需