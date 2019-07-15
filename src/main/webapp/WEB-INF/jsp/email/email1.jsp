<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/web/jsp/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<div class="layui-collapse">
		<div class="layui-colla-item">
			<h2 class="layui-colla-title">发送邮件</h2>
			<div class="layui-colla-content layui-show">
				<fieldset class="layui-elem-field layui-field-title"
					style="margin-top: 0px; padding: 5px">
					<form class="layui-form" action="${pageContext.request.contextPath}/email/send">
						<div class="layui-form-item">
							<label class="layui-form-label">标题</label>
							<div class="layui-input-block">
								<input type="text" name="subject" required lay-verify="required"
									placeholder="请输入标题" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label">邮件内容</label>
							<div class="layui-input-block">
								<textarea name="content" placeholder="请输入内容" class="layui-textarea"></textarea>
							</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-input-block">
								<button class="layui-btn" lay-submit lay-filter="formDemo">立即发送</button>
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
								<button class="layui-btn" onclick="byTime()">定时发送</button>
							</div>
						</div>
					</form>
				</fieldset>
			</div>
		</div>
	</div>
	<script>
		form.render();
		//监听提交
		formSubmit('/email/send', 'submit(formDemo)', 'text',
				function(data) {
					if (data == 0) {
						layer.msg('发送成功');
					} else {
						layer.msg('发送失败');
					}
				});
	</script>
</body>
</html>