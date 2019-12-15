# showMDModule
This is a project based on the `marked.js`. In the back-end, we use the `ssm-maven` struction to save the text to the sql. In the front-end, we use `marked,js` to convert the text into markdown format

## 1. Introduction
目的：设计了一个description文本的展示模块：
1. 本模块为实现一个基于markdown的文本展示功能，展示效果如图1所示，展示界面包含了Markdown的展示，缩放按钮，文本收缩后的虚化

![展示界面](https://raw.githubusercontent.com/xuekaixu/MarkdownShow/master/Pictures/DescriptionPage.png)

2. 功能包括了文本文件的markdown显示、存储、修改和创建功能，包括了前端和后端代码。其中后端代码基于`ssm-maven`开发，实现与数据库的交互；前端代码基于`marked.js`开发，实现页面显示。

## 2. 前端界面
前端界面包括了：1.数据库文件的索引界面；2.文本的MD展示界面；3.文本的修改界面；4.文本的创建界面

1. 索引界面：

![索引界面](https://raw.githubusercontent.com/xuekaixu/MarkdownShow/master/Pictures/indexPage.png)

* 查询数据库中全部内容，显示以上各字段；
* 包含链接：search（跳转展示界面）、modify（修改对应Description文件）、create（创建新的Description文件）

2. 展示界面：

![展示界面](https://raw.githubusercontent.com/xuekaixu/MarkdownShow/master/Pictures/DescriptionPage.png)

* 以markdown格式显示描述文件；
* 文本框可以缩放；
* 包含Modify按键，跳转修改界面

3. 修改界面：

![修改界面](https://raw.githubusercontent.com/xuekaixu/MarkdownShow/master/Pictures/modifyPage.png)

* 基于editormd.js的markdown编辑器；
* 包含save按键，存储到数据库中（包含修改者的用户名）

4. 创建界面

![创建界面](https://raw.githubusercontent.com/xuekaixu/MarkdownShow/master/Pictures/createPage.png)

* 创建新的描述行文本；
* 需要填写描述的dbTable名称（必填）；创建者名称（选填）
* 创建按键


## 3. 后端模块
结构图如下：

<p>
	<img src="https://raw.githubusercontent.com/xuekaixu/MarkdownShow/master/Pictures/structureFig.png" alt="Sample"  height="300">
	</p>
</p>

* 采用ssm+maven结构，主要的模块包括：model、util、dao、service、controller模块。
* model包含一个对象类：`HiveTableDesc`，属性和sql表中的字段类似
* util包含一个日期转换帮助类：`DateUtil`，实现日期格式转换
* dao包含一个sql映射的接口类
* service包含处理请求类
* controller包含前端请求调度类

## 4. References--本模块所引用的开源代码
1. marked.js--[https://github.com/markedjs/marked](https://github.com/markedjs/marked)
2. editormd.js--[https://github.com/pandao/editor.md](https://github.com/pandao/editor.md)
