/*!
 * Link dialog plugin for Editor.md
 *
 * @file        link-dialog.js
 * @author      pandao
 * @version     1.2.0
 * @updateTime  2015-03-07
 * {@link       https://github.com/pandao/editor.md}
 * @license     MIT
 */

(function() {

    var factory = function (exports) {

		var $            = jQuery;           // if using module loader(Require.js/Sea.js).

        exports.saveMarkdownContent = function(dbTable,userName){
            //关键js代码--格式转换
            var text = $("#test-editormd>textarea").val();

            // var des = text.replace(/\r\n/g, '<br/>').replace(/\n/g, '<br/>').replace(/\s/g, ' '); //转换格式
            // var des = text.replace(/\n|\r\n/g,"<br>");
            var des = text;
            //将des文本内容存入数据库
            $.ajax({
                type: "post",  //数据提交方式（post/get）
                url: "../user/DescriptionContentUpdate",  //提交到的url
                data: {dbTable:dbTable, content:des, userName:userName},
                //提交的数据
                dataType: "json",//返回的数据类型格式
                success: function(data){
                    // $("#status").text(data.status);
                    if (data.result="success"){
                        $("#status")
                            .addClass("success")
                            .html("Data saved successfully xxxxxxxx")
                            .fadeIn('slow')
                            .delay(1000)
                            .fadeOut('slow');
                    }else{
                        $("#status")
                            .addClass("error")
                            .html("Error, data could not be saved")
                            .fadeIn('slow')
                            .delay(1000)
                            .fadeOut('slow');
                    }

                }
            });
        };
        exports.createDescription = function(){
            //关键js代码--格式转换
            var text = $("#test-editormd>textarea").val();
            var dbTable = $.trim($("#to_dbTable").val());
            var userName = $.trim($("#to_UserName").val());
            if(dbTable==="" || dbTable==null){
                alert("Please input dbTable!!");
                return;
            }
            // var des = text.replace(/\r\n/g, '<br/>').replace(/\n/g, '<br/>').replace(/\s/g, ' '); //转换格式
            // var des = text.replace(/\n|\r\n/g,"<br>");
            // var des = text;
            //将des文本内容存入数据库
            $.ajax({
                type: "post",  //数据提交方式（post/get）
                url: "../user/DescriptionContentCreate",  //提交到的url
                data: {dbTable:dbTable, content:text, userName:userName},
                //提交的数据
                dataType: "json",//返回的数据类型格式
                success: function(data){
                    // $("#status").text(data.status);
                    if (data.result==="success"){
                        $("#status")
                            .addClass("success")
                            .html("Data saved successfully xxxxxxxx")
                            .fadeIn('slow')
                            .delay(1000)
                            .fadeOut('slow');
                    }else{
                        $("#status")
                            .addClass("error")
                            .html("Error, data could not be saved")
                            .fadeIn('slow')
                            .delay(1000)
                            .fadeOut('slow');
                    }

                }
            });
        };

	};
    
	// CommonJS/Node.js
	if (typeof require === "function" && typeof exports === "object" && typeof module === "object")
    { 
        module.exports = factory;
    }
	else if (typeof define === "function")  // AMD/CMD/Sea.js
    {
		if (define.amd) { // for Require.js

			define(["editormd"], function(editormd) {
                factory(editormd);
            });

		} else { // for Sea.js
			define(function(require) {
                var editormd = require("./../../editormd");
                factory(editormd);
            });
		}
	} 
	else
	{
        factory(window.editormd);
	}

})();
