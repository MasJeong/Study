<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify/Delete</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Modify/Delete</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form>
					<input type='hidden' name='pageNum' value='${cri.pageNum }'>
					<input type='hidden' name='amount' value='${cri.amount }'>
					
					<div class="form-group">
						<label>BNO</label> <input class="form-control" name="bno"
							readonly="readonly" value='<c:out value="${board.bno }" />'>
					</div>

					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title"
							value='<c:out value="${board.title }" />'>
					</div>

					<div class="form-group">
						<label>Content</label>
						<textarea row="5" cols="50" name="content" class="form-control"><c:out
								value="${board.content }" /></textarea>
					</div>

					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer"
							value='<c:out value="${board.writer }" />'>
					</div>

					<!--  data-oper는 커스텀 속성(만들어서 사용가능) -->
					<button class="btn btn-default" data-oper='modify'>Modify</button>
					<button class="btn btn-danger" data-oper='remove'>Remove</button>
					<button class="btn btn-info" data-oper='list'>List</button>

				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script>
$(document).ready(function(){
	
	var formObj = $("form");
	
	$('.btn').click(function(e){
	
	e.preventDefault(); //기본동작 막는다(폼태그에서 버튼누르면 서브밋으로 동작하는거)
	
	var operation = $(this).data("oper");//$(this)는 버튼으로 만듬
	
	console.log(operation);
	
	if(operation === 'list'){
		//self.location = "/board/list";
		formObj.attr("action", "/board/list")
		.attr("method", "get");
		
		var pageNumTag = $("input[name='pageNum']").clone();
		var amountTag = $("input[name='amount']").clone();
		
		formObj.empty();
		formObj.append(pageNumTag);
		formObj.append(amountTag);
		
	}else if(operation === 'remove'){
		formObj.attr("action", "/board/remove")
	 	.attr("method", "post");
	}else if(operation === 'modify'){
		formObj.attr("action", "/board/modify")
	 	.attr("method", "post"); 
	}
	
	formObj.submit();
	});
});
</script>

<%@ include file="../includes/footer.jsp"%>
