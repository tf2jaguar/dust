# 功能点

## 业界较为流行的模块划分

- api 所有接口包文件，可以单独打包对外提供服务
- common 抽象基础服务下沉，如调用第三方服务、本系统各模块通用服务
- server 本系统核心业务模块
- main 本系统web各种配置模块，启动类，启动配置项等

## 增益功能

1. 出参、入参包装（可以开启和关闭）
2. 日志aop记录，可以抓取当前时间、调用方法、uri、ip地址、出参、入参、header等
3. 统一异常捕获、自定义系统异常
4. 自定义异常捕获、系统异常捕获
5. 分布式id生成器，雪花id生成器
6. 时间工具类、本地host工具类、IP工具类、正则表达式工具类

# 使用

使用骨架前，需要现将项目 clone 下来，并使用 maven 安装到本地

## 生成骨架

```shell
git clone https://github.com/tf2jaguar/dust.git

cd dust

mvn clean install -Dmaven.test.skip=true

mvn archetype:create-from-project
```

以上操作将构建代码，并会在 `target/generated-sources/archetype` 下生成项目骨架。之后需要将骨架安装到本地

## 安装骨架到本地

```shell
cd target/generated-sources/archetype

mvn install
```

执行 `mvn install` 后，会在本地的maven仓库，按照本项目的maven坐标（com.example:dust-archetype）创建对应的archetype文件

## 使用模板生成项目

1。 查看本地archetype列表

```shell
mvn archetype:generate -DarchetypeCatalog=local
```

2。执行完后最终会显示本地已有的 archetype 列表，当然也包含刚才生成的骨架，如下

```shell
INFO] Generating project in Interactive mode
[INFO] No archetype defined. Using maven-archetype-quickstart (org.apache.maven.archetypes:maven-archetype-quickstart:1.0)
Choose archetype:
1: local -> com.example:dust-archetype (Parent pom providing dependency and plugin management for applications
		built with Maven)
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): : 
```

3。选择刚才生成的骨架。在下一行行尾输入 com.example:dust-archetype 所对应的编码，然后回车确认。 如上编码是：1，这里输入 1

```shell
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): : 1
```

4。按照步骤输入新项目的基本参数，确认完成后，输入字母 y ，进行确认

示例：生成如下项目示例

```
    <groupId>io.github.tf2jaguar</groupId>
    <artifactId>microcosm</artifactId>
    <packaging>pom</packaging>
    <version>1.0.0-SNAPSHOT</version>
```

```shell
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): : 1
Define value for property 'groupId': io.github.tf2jaguar
Define value for property 'artifactId': microcosm
Define value for property 'version' 1.0-SNAPSHOT: : 1.0.0-SNAPSHOT
Define value for property 'package' io.github.tf2jaguar: : io.github.tf2jaguar.microcosm
Confirm properties configuration:
groupId: io.github.tf2jaguar
artifactId: microcosm
version: 1.0.0-SNAPSHOT
package: io.github.tf2jaguar.microcosm
 Y: : Y # 这里输入 Y 进行确认
```

字段解释 

```shell
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): : 1
Define value for property 'groupId': # 这里写新项目的groupId
Define value for property 'artifactId': # 这里写新项目的artifactId （即项目名）
Define value for property 'version' 1.0-SNAPSHOT: : 1.0.0-SNAPSHOT # 这里写新项目的版本，默认为 1.0-SNAPSHO
Define value for property 'package' xxx.xxx: : # 这里写新项目的package，默认为上边输入的groupId，这里可以使用 groupId.artifactId
Confirm properties configuration:
groupId: io.github.tf2jaguar
artifactId: microcosm
version: 1.0.0-SNAPSHOT
package: io.github.tf2jaguar.microcosm
 Y: : y # 这里输入 y 进行确认
```

5。随后在当前目录下，会以上边输入的新项目的 `artifactId` 为目录创建一个新的项目。使用编辑器打开即可

### 方式二

在新开的项目路径下执行以下命令

```shell
mvn archetype:generate \
-DgroupId=com.example \
-DartifactId=dust \
-Dversion=这里写本项目最新版本 \
-DarchetypeGroupId=这里写新项目的groupId \
-DarchetypeArtifactId=这里写新项目的artifactId \
-DarchetypeVersion=这里写新项目的版本 \
-X -DarchetypeCatalog=local 
```

### 方式三

在IDEA中

1. File->New-> Project
2. 选择Create from archetype
3. Add Archetype
4. 按照如下输入刚创建的骨架

>GroupId：com.example
>ArtifactId：dust-archetype
>Version：1.1.0-SNAPSHOT
>Repository(option)：local

5. 随后点击Next
6. 输入 *新的项目标识* , `groupId`, `artifactId`, `version`, `package`
7. 修改生成的项目结构为所需

## 修改默认配置

- 修改 `xxx-main` 模块下的启动类类名称 `DustApplication`
- 修改 `resources/META-INF/app.properties` 内的 appId
- 修改 `resources/*.properties` 多个springboot 配置文件 (swagger扫描的controller位置 等)
