# showMDModule
This is a project based on the `marked.js`. In the back-end, we use the `ssm-maven` struction to save the text to the sql. In the front-end, we use `marked,js` to convert the text into markdown format

## Introduction
目的：设计了一个description文本的展示模块：
1. 本模块为实现一个基于markdown的文本展示功能，展示效果如图1所示，展示界面包含了Markdown的展示，缩放按钮，文本收缩后的虚化

![展示界面](https://raw.githubusercontent.com/xuekaixu/MarkdownShow/master/Pictures/DescriptionPage.png)

2. 功能包括了文本文件的markdown显示、存储、修改和创建功能，包括了前端和后端代码。其中后端代码基于`ssm-maven`开发，实现与数据库的交互；前端代码基于`marked.js`开发，实现页面显示。
