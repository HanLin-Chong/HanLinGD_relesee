<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<!-- !!!!!!!!!!!!!!!!!!!!!!!!   特别注意    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
	<!-- 
		   子页面禁止引用其它任何位置，任何形式的jquery文件（包括联网引用的也不行）,
		   否则父页面bootstrap会失效报错，只能引用本地的js/jquery-1.11.0.min.js 
	-->
    <!-- !!!!!!!!!!!!!!!!!!!!!!!!   /特别注意  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
    <title>index</title>
    <meta charset="utf-8">

    
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<!-- AmazeUI 
	<link rel="stylesheet" type="text/css" href="css/amazeui.min.css"/>-->

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="css/font-awesome.min.css" rel="stylesheet">
	
	<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css" />
	<link rel="stylesheet" href="css/custom.css">
	<!-- iziToast -->
	<link rel="stylesheet" href="css/iziToast.min.css">
	 
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-1.11.0.min.js"></script>

    <script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
    <!-- AmazeUI 
	<script type="text/javascript" src="js/amazeui.min.js"></script> -->

    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="js/custom.js"></script>
    <!-- iziToast -->
    <script src="js/iziToast.min.js" type="text/javascript"></script>
    
    <!-- sock对象 -->
    <script src="js/Socket.js" type="text/javascript"></script>
    <style>
    	/*调整用户信息下的两个label*/
    	.label{
    		float:left;
    		margin-left:5px;
    	}
    </style>
    
  </head>
  
  <body>
	<div class="page-wrapper">
      <nav id="sidebar" class="sidebar-wrapper" style="z-index:999">
        <div class="sidebar-content">
          <a href="#" id="toggle-sidebar"><i class="fa fa-bars"></i></a>
          <div class="sidebar-brand">
              <a href="#">审核员</a>
          </div>
          <div class="sidebar-header">
              <div class="user-pic">
                  <img class="img-responsive img-rounded" src="img/" alt="">
              </div>
              <div class="user-info">
                  <span class="user-name">姓名：</span><!-- 名 <strong>姓</strong> -->
                  <span class="user-role">工号：</span>
                  <span class="user-role">机构号：</span>
                  <div class="user-status">                       
                      <a href="#"><span class="label label-success mylabelgroup">账号状态：</span></a>
                                           
                  </div>
              </div>
          </div><!-- sidebar-header  -->
          <div class="sidebar-search">
              <div>                   
                  <div class="input-group">                          
                      <input type="text" class="form-control search-menu" placeholder="搜索功能暂未开放">
                      <span class="input-group-addon"><i class="fa fa-search"></i></span>
                  </div>
              </div>                    
          </div><!-- sidebar-search  -->
          <div class="sidebar-menu">
              <ul>
                  <li class="header-menu"><span>业务处理</span></li>            
                  
                  <li class="sidebar-dropdown">

                      <a  href="#" ><i class="fa fa-file"></i><span>境外机构申请境内账户-NRA</span></a>
                      <div class="sidebar-submenu">
                          <ul>
                              <li class="pageloder-trigger"  whichpage=""><a href="#">资料管理 </a> </li>
                              
                              <li class="pageloder-trigger" whichpage=""><a href="#">审核队列属性设置</a></li>
                              <li class="pageloder-trigger" whichpage=""><a href="#">插队审核</a></li>
                          </ul>
                      </div>
                  </li>
                  
                  <li class="pageloder-trigger" whichpage="Auditor_queue_manage.html"><a href="#"><i class="glyphicon glyphicon-user"></i><span>客户经理账户管理</span></a></li>
                  <li class="pageloder-trigger" whichpage="Auditor_handle_rules.html"><a href="#"><i class="fa fa-eye"></i><span>电商客户境外账户申请</span></a></li>
                  <li class="pageloder-trigger" whichpage="Auditor_handle_rules.html"><a href="#"><i class="fa fa-eye"></i><span>总台账信息</span></a></li>

              </ul>
             </div><!-- sidebar-menu  -->           
          </div><!-- sidebar-content  -->
   
          <div class="sidebar-footer">
              <a id="notifications-trigger" title="消息中心" ><i class="fa fa-bell"></i></a>
              <a id="message_send_and_history_message" title="发送消息"><i class="glyphicon glyphicon-list-alt"></i></a>
              <a title="状态跟踪"><i class="fa fa-power-off"></i></a>
              <a title="退出当前账号"><i class="fa fa-power-off"></i></a>
          </div>
      </nav><!-- sidebar-wrapper  -->
      <main class="page-content">
      	
      </main>
  </div><!-- page-wrapper -->  
  
  
  <!-- Button trigger modal -->


<!-- 消息模态框 -->
	<div class="modal fade bs-example-modal-lg" id="notifications-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      	<div class="modal-header">
	        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        	<h4 class="modal-title" id="myModalLabel">消息中心</h4>
	      	</div>
	      	<div class="modal-body row">
	      		<ul id="listview" class="list-group" ><!-- col-md-8 -->
			  	空
				</ul>
	      	</div>
	      	
	      	<div class="modal-footer">
	      		
				  <ul id="pg" class="pagination" style="cursor:pointer;margin:15px 0px;padding:0px;float:left">
				    <li>
				      <a  aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <li><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">3</a></li>
				    <li><a href="#">4</a></li>
				    <li><a href="#">5</a></li>
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>

	        	  <button style="margin:20px 0px;" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        	  <button id="all_message_readed" style="margin:20px 0px;" type="button" class="btn btn-primary">全部标为已读</button>
	        	
	      	</div>
	    </div>
	  </div>
	</div>
  
  
  
  <script>
  //自定义class：.pageloder-trigger 所有点击需要切换页面的html元素，需要有whichpage属性
  	$(document).ready(function(){
  		 
  		
  		//所有pageloder-trigger类，只要添加whichpage属性就可实现加载该页面
  		$(".pageloder-trigger").click(function(e){
  			var url=e.currentTarget.getAttribute("whichpage");
  			$(".page-content").load(url);
  		});
  		
  		$("#message_send_and_history_message").click(function(){
  			alert("此模块等待具体方案中");
  		});
  		

		//左下角打开消息中心图标按钮
		$("#notifications-trigger").click(function(e){
			
			$("#notifications-modal").modal('show');//or hide
		});
		


		
		
		//默认500mm=0.5秒后跳出左侧栏
		setTimeout(function(){
			$(".page-wrapper").toggleClass("toggled");
		},500)
		
		$(".page-content").load("Auditor_handle_rules.html");

  	});


  	
  	
  </script>

  </body>
</html>
