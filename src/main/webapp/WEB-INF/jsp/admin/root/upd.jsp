<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/web/jsp/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<fieldset class="layui-elem-field" style="margin: 20px; padding: 15px;">
		<legend>权限维护--修改信息</legend>
		<form class="layui-form" lay-filter="upduser" method="post">
			<div class="layui-form-item">
				<label class="layui-form-label">角色编号</label>
				<div class="layui-input-inline">
					<select name="roleCode"></select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">菜单编号</label>
				<div class="layui-input-inline">
					<select name="menuCode"></select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"></label>
				<div class="layui-input-inline">
					<input type="button" class="layui-btn" lay-submit
						lay-filter="updUser" value="确定" /> <input type="button"
						class="layui-btn" onclick="closeThis()" value="取消" />
				</div>
			</div>
		</form>
	</fieldset>
	<script type="text/javascript">
	var userCode = '<%=request.getSession().getAttribute("userCode")%>';
	var adminCode = '<%=request.getSession().getAttribute("adminCode")%>';
	console.log("u"+userCode+"a"+adminCode);
init();
function init(){
	
    var code = '<%=request.getParameter("code")%>';
			ajax("/role/search", {}, "json", function(d) {
				console.log(d);
				var html = "";
				$.each(d.data, function(i, dom) {
					html += "<option value='"+dom.code+"'>" + dom.name
							+ "</option>";
				});
				$("select[name='roleCode']").html(html);
				form.render();
				ajax("/menu/search", {}, "json", function(d) {
					console.log(d);
					var html = "";
					$.each(d.data, function(i, dom) {
						html += "<option value='"+dom.code+"'>" + dom.name
								+ "</option>";
					});
					$("select[name='menuCode']").html(html);
					form.render();
					$.ajax({
						url : con.app + '/root/initUpd',
						data : {
							code : code
						},
						dataType : 'json',
						type : 'post',
						success : function(data) {
							form.val("upduser", {
								roleCode : data.roleCode,
								menuCode : data.menuCode,
							});
							form.render();
						}
					});
				});
			})
		}
		formSubmit('/menu/upd', 'submit(updUser)', 'text', function(data) {
			if (data == 1) {
				layer.msg('修改成功');
				closeThis(1000);
			} else {
				layer.msg('修改失败');
			}
		});
	</script>
	<script id="tradd" type="text/html">
	<option value="{{d.value1}}">{{d.value}}</option>
</script>
</body>
</html>