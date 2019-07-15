<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/web/jsp/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<fieldset class="layui-elem-field" style="margin: 20px; padding: 15px;">
		<legend>用户维护--添加信息</legend>

		<form class="layui-form" method="post">
			<div class="layui-form-item">
				<label class="layui-form-label">账号</label>
				<div class="layui-input-inline">
					<input type="text" name="code" lay-verify="required"
						placeholder="请输入账号" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">密码</label>
				<div class="layui-input-inline">
					<input type="password" name="password" lay-verify="required"
						placeholder="请输入密码" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-inline">
					<input type="text" name="name" placeholder="请输入姓名"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">角色</label>
				<div class="layui-input-inline">
					<select name="roleCode" lay-filter="changeRole"></select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">上级人员</label>
				<div class="layui-input-inline">
					<select name="parentCode"></select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"></label>
				<div class="layui-input-inline">
					<input type="button" class="layui-btn" lay-submit
						lay-filter="addUser" value="确定" /> <input type="button"
						class="layui-btn" onclick="closeThis()" value="取消" />
				</div>
			</div>
		</form>
	</fieldset>
	<script type="text/javascript">
	form.render();
	ajax("/role/search", {}, "json", function(d){
		console.log(d);
		var html="";
		$.each(d.data,function(i,dom){
			html+="<option value='"+dom.code+"'>"+dom.name+"</option>";
			});
		$("select[name='roleCode']").html(html);
		form.render();
		form.on('select(changeRole)', function(c) {
			console.log(c.value); //得到被选中的值
			ajax("/user/searchParent", {roleCode:c.value}, "json", function(data) {
				console.log(data);
				var html = "";
				$.each(data, function(i, dom) {
					html+="<option value='"+dom.parentCode+"'>"+dom.parentName+"</option>";
				});
				$("select[name='parentCode']").html(html);
				form.render();
			});
		});
		});
		formSubmit('/user/add', 'submit(addUser)', 'text',
				function(data) {
					if (data == 0) {
						layer.msg('添加成功');
					} else if (data == 1) {
						layer.msg('账号已存在');
					} else if(data == 3){
						layer.msg('添加失败，上级编号不存在');
					} else if(data == 2){
						layer.msg('添加失败');
					}
					closeThis(1000);
				});
	</script>
</body>
</html>