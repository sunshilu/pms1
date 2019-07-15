var con = {
	app : "/pms",
	jsp_login : "/web/jsp/login.jsp",
	jsp_reg : "/web/jsp/reg.jsp",
	jsp_list : "/web/jsp/list.jsp",
	main : "/jsp/administrator/main.jsp",
	user_main :"/jsp/user/main.jsp",
	home:"/jsp/web/home.jsp",
	jsp_url:"/unit/forward?url="
};
var form = layui.form;
var $ = layui.jquery;
var layer = layui.layer;
var element = layui.element;
var laypage = layui.laypage;
var laytpl = layui.laytpl;
var laydate = layui.laydate;
var upload = layui.upload;
var carousel = layui.carousel;
var table=layui.table;

// layui.use(['form','layer','jquery'], function () {
// var form = layui.form;// 获取操作对象
// var $ = layui.jquery;
// ...
// });

// 强烈不推荐下面的做法
// var form,$;
// layui.use(['form','layer','jquery'], function () {
// form = layui.form;// 获取操作对象
// $ = layui.jquery;
// ...
// });

function toJsp(url) {
	location.href = con.app + url;
}
function goJspLogin() {
	toJsp(con.jsp_login);
}
function goJspReg() {
	toJsp(con.jsp_reg)
}
function goLogout() {
	openConfirm(function(index) {
		layer.close(index);
		ajax("/EmployeeServlet", {
			action : "close"
		}, "text", function(data) {
			if (data == "0") {
				toJsp(con.jsp_login);
			}
		})

	}, '确定注销？');
}
function openConfirm(func, title) {
	layer.confirm(title ? title : "确定进行该操作？", {
		icon : 3,
		title : '提示'
	}, func);
}

function formSubmit(url, submit, dataType, func) {
	form.on(submit, function(data) {
		console.log(data.field);
		ajax(url, data.field, dataType, func);
	});
}
function ajax(url, field, dataType, func) {
	$.ajax({
		url : con.app + url,
		data : field,
		dataType : dataType,
		type : 'post',
		success : func
	});
}
function openLayer(url, end) {
	layer.open({
		type : 2,
		area : [ '800px', '450px' ],
		fixed : false, // 不固定
		maxmin : true,
		end : end,
		content : con.app + url
	});
}
function closeThis(time) {
	setTimeout(function() {// 先得到当前iframe层的索引
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	}, time ? time : 200)
}
function setPageInfo(elem, count, curr, limit, jump) {
	laypage
			.render({
				elem : elem,// id
				count : count,// 数据总数
				curr : curr,// 当前页
				limit : limit,// 每页显示的条数
				limits : [ 10, 20, 30, 40, 50 ],// 每页条数的选择项
				layout : [ 'count', 'prev', 'page', 'next', 'limit', 'refresh',
						'skip' ],
				jump : jump
			});
}
function setPageInfoTheme(elem,count,curr,limit,color,jump){
	laypage.render({
		elem : elem,// id
		count : count,// 数据总数
		curr : curr,// 当前页
		limit : limit,// 每页显示的条数
		limits : [ 3, 6, 9, 12, 15 ],// 每页条数的选择项
		theme:color,
		layout : [ 'count', 'prev', 'page', 'next', 'limit', 'refresh',
				'skip' ],
		jump : jump
	});
}
function getlaytpl(sel, data) {
	var temp = $(sel).html();
	return laytpl(temp).render(data);
}
function renderUpload(id, url, data, done) {
	var uploadInst = upload.render({
		elem : '#' + id,
		url : con.app + url,
		data : data,
		done : done
	})
}
function initRoleAndParent(){
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
}
