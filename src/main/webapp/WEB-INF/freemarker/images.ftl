<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Images</title>
</head>
<body>
	<table border="1">
	<#-- <#attempt> -->
		<tr><th>DIRECTORIES</th></tr>
		<#list directory.getSubDirectories() as dir >
			<tr>
				<td>
					<#if directory.getUrl() != "" >
						<a href="${directory.getUrl()}-${dir.getName()}">${dir.getName()}</a>
					<#else>
						<a href="${dir.getName()}">${dir.getName()}</a>
					</#if>
				</td>
			</tr>
		</#list>
		<tr><th>FILES</th></tr>
		<#list directory.getFiles() as file >
			<tr>
				<td>${file.getName()}</td>
				<td><img src="/sandbox-java/image/${file.getName()}" width="250" /></td>
			</tr>
		</#list>
	<#-- <#recover> -->
	   <#-- No file here ! -->
	<#--</#attempt> -->
	</table>
</body>
</html>
