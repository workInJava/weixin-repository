<#assign basepath='test-wei-project-front'/>
<#macro html title javascripts css>
	<html>
		 <head>
		    <link rel="icon" href="images/favicon.ico"/>
		    <title>${title!'weiproduct'}</title>
		    <link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap-theme.css" rel="stylesheet">
		    <link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap-theme.min.css" rel="stylesheet">
		    <link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.css" rel="stylesheet">
		    <link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
		    <#if css??>
			    <#list css as cs>
			    	<link href="${cs}" rel="stylesheet">
			    </#list>
		    </#if>
		    <script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
		    <script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
		    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.js"></script>
		    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		    <#if javascripts??>
			    <#list javascripts as js>
			    	<script src="${js}"></script>
			    </#list>
		    </#if>
		 </head>
		 <body>
			<#nested>
		 </body>
	</html>
</#macro>