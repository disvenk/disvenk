Date.prototype.format = function(format){ 
    var o =  { 
    "M+" : this.getMonth()+1, //month 
    "d+" : this.getDate(), //day 
    "h+" : this.getHours(), //hour 
    "m+" : this.getMinutes(), //minute 
    "s+" : this.getSeconds(), //second 
    "q+" : Math.floor((this.getMonth()+3)/3), //quarter 
    "S" : this.getMilliseconds() //millisecond 
    };
    if(/(y+)/.test(format)){ 
    	format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
    }
    for(var k in o)  { 
	    if(new RegExp("("+ k +")").test(format)){ 
	    	format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
	    } 
    } 
    return format; 
};

var YP = YEPAO = {
	// 图片编辑器参数
	kingEditorParams : {
		//指定上传文件参数名称
		filePostName  : "uploadFile",
		//指定上传文件请求的url。
		uploadJson : '/pic/upload',
		//上传类型，分别为image、flash、media、file
		dir : "image"
	},
	// 视频编辑器参数
	kingEditorParams1 : {
		//指定上传文件参数名称
		filePostName  : "uploadFile",
		//指定上传文件请求的url。
		uploadJson : '/media/upload',
		//上传类型，分别为image、flash、media、file
		dir : "media"
	},
	// 格式化时间
	formatDateTime : function(val,row){
		var now = new Date(val);
    	return now.format("yyyy-MM-dd hh:mm:ss");
	},
    
    init : function(data){
    	// 初始化图片上传组件
    	this.initPicUpload(data);//初始化到这里的时候就会调用这两个方法，调用者是YEPAO
    },
    // 初始化图片上传组件
    initPicUpload : function(data){
    	//上传图片
    	$(".picFileUpload").each(function(i,e){
    		var _ele = $(e);
    		_ele.siblings("div.pics").remove();
    		_ele.after('\
    			<div class="pics">\
        			<ul></ul>\
        		</div>');
    		// 回显图片
        	if(data && data.pics){
        		var imgs = data.pics.split(",");
        		for(var i in imgs){
        			if($.trim(imgs[i]).length > 0){
        				_ele.siblings(".pics").find("ul").append("<li><a href='"+imgs[i]+"' target='_blank'><img src='"+imgs[i]+"' width='80' height='50' /></a></li>");
        			}
        		}
        	}
        	//给“上传图片按钮”绑定click事件
        	$(e).click(function(){
        		var form = $(this).parentsUntil("form").parent("form");
        		//打开图片上传窗口
        		KindEditor.editor(YP.kingEditorParams).loadPlugin('multiimage',function(){
        			var editor = this;
        			editor.plugin.multiImageDialog({
						clickFn : function(urlList) {
							var imgArray = [];
							KindEditor.each(urlList, function(i, data) {
								imgArray.push(data.url);
								form.find(".pics ul").append("<li><a href='"+data.url+"' target='_blank'><img src='"+data.url+"' width='80' height='50' /></a></li>");
							});
							form.find("[name=img]").val(imgArray.join(","));
							editor.hideDialog();
						}
					});
        		});
        	});
    	});
    	
    	//上传视频
     	$(".mediaFileUpload").each(function(i,ee){
    		var _ele = $(ee);
      
        	//给“上传视频按钮”绑定click事件
        	$(ee).click(function(){
        	/*	var form = $(this).parentsUntil("form").parent("form");
        		//打开视频上传窗口
        		KindEditor.editor(YP.kingEditorParams1).loadPlugin('media', function() {
        			var editor = this;
                    editor.plugin.media.edit();
                    
        		});*/
        		
        		/*$("#upload-goods-video").uploadify({
        			"height"          : 30,
        			"width"           : 120,  //定义上传插件的宽和高
        			"swf"             : "/js/uploadify.swf",  //引入上传插件的flash
        			"fileObjName"     : "goods_video",   //以什么名字上传到服务器上.. 保存到$_FILES. 默认的名字为 'Filedata'
        			"buttonText"      : "上传视频",
        			"uploader"        : "/media/upload", //上传给哪个url地址
        			'removeTimeout'
        			 : 3,  //上传后的提示在几秒后消失
        			'multi'           : false,//是否执行多文件上传
        			'debug'           : false, //是否开启调试模式
        			'formData'      : {name:'goods_video',pic_url:''}, //上传图片的同时以POST的形式向服务器参数,  指定上传到又拍云的哪个空间
        			'fileTypeExts'
        			 : '*.jpg; *.png; *.gif; *.bmp; *.mp4;',  //指定上传的类型,  它可以帮我们验证..
        			'onUploadSuccess' : function(file, data, response) {  //上传成功之后执行该方法
        			var obj = $.parseJSON(data);
        			// console.log(data);
        			 $("#video_path").val(obj.name);*/


        			//显示预览图片的div
        			// $('.upload-pre-item img').attr('src','__BRAND__/'+obj.path+'!s'); //将上传后的路径设置给img的src中
        			// $('.upload-img-box').show();
        			/*},
        			'onFallback' : function() {
        			alert('未检测到兼容版本的Flash.');
        			}
        			});*/
        	});
        	
    	});
    },

    
    createEditor : function(select){
    	return KindEditor.create(select, YP.kingEditorParams);
    },
    
   
    closeCurrentWindow : function(){
    	$(".panel-tool-close").click();
    },
    
    /**
     * 初始化单图片上传组件 <br/>
     * 选择器为：.onePicUpload <br/>
     * 上传完成后会设置input内容以及在input后面追加<img> 
     */
    initOnePicUpload : function(){
    	$(".onePicUpload").click(function(){
			var _self = $(this);
			KindEditor.editor(YP.kingEditorParams).loadPlugin('image', function() {
				this.plugin.imageDialog({
					showRemote : false,
					clickFn : function(url, title, width, height, border, align) {
						var input = _self.siblings("input");
						input.parent().find("img").remove();
						input.val(url);
						input.after("<a href='"+url+"' target='_blank'><img src='"+url+"' width='80' height='50'/></a>");
						this.hideDialog();
					}
				});
			});
		});
    }
};
