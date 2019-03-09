#艺术家及其作品展示系统
---
##时间安排
* 环境搭建 jdk1.8 、mysql57
* 框架搭建 springboot、mybatis、thmeleaf、bootstrap
* 功能设计
* 数据库设计
* 详细设计
* 开发

### 功能设计

* 登录
* 注册
* 找回密码

#### 用户

* 信息修改 
* 申请认证
* 上传作品
* 评论作品，回复用户评论
* 投票支持

#### 管理员

* 用户管理
* 艺术作品管理
* 艺术家审核
* 艺术家信息管理
* 作品评论管理
* 作品评分管理



### 数据库设计 数据库名 artworkcms


>user 用户表    

	id：主键    
	name：用户名    
	pwd：密码    
	avatar：头像    
	auth：权限【普通用户、管理员、被冻结】  
	sex:性别
	isArtist:是否为艺术家
  

>artist  艺术家表

	user_id： 外键 用户id。  
	nation： 国籍。  
	birthday: 出生日期
	profession：职业 
	city：城市
	info： 简介
	revire: 审核


>artwork 艺术作品表

	id：作品id 主键
	name：作品名
	artist：艺术家id（user.id)    
	info：信息。 
	review: 是否通过审核 【已审核、待审核、审核通过、审核失败】
	score：得分


>artwork_media 艺术作品媒体文件

	artwork_id 艺术作品id 外键 artwork.id
	type：媒体文件类型 【pic、audio、video】
	url：链接

>artwork_score 艺术作品评分表

	user_id 用户id
	score  评分

>artwork_comment 艺术作品评论

	id： 评论id
	reply：回复的id artwort_comment.id
	user_id： 评论者id
	content： 内容
	timestamp：时间


### 详细设计

#### 接口
	
##### 开放接口
	/open/login 登录。  
	/open/register 注册。  
	/open/retrieve 找回密码。  
	/open/comment 获取/加载更多 评论接口
##### 用户接口
	/api/artwork/:artwork.id/score 评分接口
	/api/comment 评论接口
	/api/user/modify 修改用户信息接口
	/api/user/logout 注销登录
##### 管理员接口
	/admin/user/add 添加用户
	/admin/user/list 查看用户列表
	/admin/user/:user.id 用户审核
	/admin/user/:user.id 用户详情
	/admin/user/:user.id/modify 修改用户信息
	/admin/artwork/add 添加艺术品
	/admin/artwork/list 艺术品列表
	/admin/artwork/:artwork.id 详情
	/admin/artwork/:artwork.id/modify 修改
	/admin/artwork/:artwork.id/review 审核
	
	
#### 路由

##### 客户端
	/ 主页
	/login 登录
	/register 注册
	/retrieve 找回账号密码
	/user/:user.id 用户/艺术家 详情页
	/artwork/:artwork.id 艺术作品详情页
	/artwork/add 上传艺术作品
	/artwork/:artwork.id/modify 修改作品信息
##### 运营后台
	/ 主页
	/user/list 用户列表
	/user/:user.id 用户详情
	/user/:user.id/review 作家审核
	/artwork/list 艺术品列表
	/artwork/:artwork.id 艺术品详情
	/artwork/:artwork.id/review 艺术品审核

	
	
	


