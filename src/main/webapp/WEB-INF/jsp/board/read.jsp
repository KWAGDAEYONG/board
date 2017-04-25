<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">READ BOARD</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" action="modifyPage" method="post">
					<input type='hidden' name='bno' value="${read.bno}"> <input
						type='hidden' name='page' value="${cri.page}"> <input
						type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">
				</form>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label> <input type="text"
							name='title' class="form-control" value="${read.title}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="content" rows="3"
							readonly="readonly">${read.content}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Writer</label> <input type="text"
							name="writer" class="form-control" value="${read.writer}"
							readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
					<button type="submit" class="btn btn-warning">Modify</button>
					<button type="submit" class="btn btn-danger">REMOVE</button>
					<button type="submit" class="btn btn-primary">LIST ALL</button>
				</div>

				<div class="box-footer">
					<form class="answer-write"
						action="/answer/register?bno=${read.bno}" method="post">
						댓글 달기 :
						<textarea name="content"></textarea>
						<input type="submit" value="확인">
					</form>
					<div class="answerList">
					
					</div>
					
				</div>
				<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
				<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
				<script>
					$(".answer-write input[type=submit]").click(addAnswer);

					function addAnswer(e) {
						console.log("click me");
						e.preventDefault();

						var queryString = $(".answer-write").serialize();
						console.log("query: " + queryString);

						var url = $(".answer-write").attr("action");
						console.log("url: " + url);
						$.ajax({
							type : 'post',
							url : url,
							data : queryString,
							dataType : 'json',
							error : onError,
							success : onSuccess
						});
					}

					function onError() {

					}
					function onSuccess(data, status) {
						console.log(data);
						var answerTemplate = $("#answerTemplate").html();
						var template = answerTemplate.format(data.content,
								data.id, data.id);
						$(".answerList").append(template);
						$("textarea[name=content]").val("");
					}

					String.prototype.format = function() {
						var args = arguments;
						return this
								.replace(
										/{(\d+)}/g,
										function(match, number) {
											return typeof args[number] != 'undefined' ? args[number]
													: match;
										});
					};
				</script>

				<script>
					$(document).ready(function() {

						var formObj = $("form[role='form']");

						console.log(formObj);

						$(".btn-warning").on("click", function() {
							formObj.attr("action", "/board/modify");
							formObj.attr("method", "get");
							formObj.submit();
						});

						$(".btn-danger").on("click", function() {
							formObj.attr("method", "post");
							formObj.attr("action", "/board/remove");
							formObj.submit();
						});

						$(".btn-primary").on("click", function() {
							formObj.attr("method", "get");
							formObj.attr("action", "/board/listAll");
							formObj.submit();
						});

					});
				</script>

				<script type="text/template" id="answerTemplate">
    <article>
        <div>
            <div>
                <div>익명의 누군가 : {0}</div>
            </div>
        </div>
        <div> 
            <a href ="/api/qna/updateAnswer/{1}">수정</a>
            <form action="/api/questions/{1}/answers/{2}" method="POST">
                <input type="hidden" name="_method" value="DELETE">
                <button type="submit">삭제</button>
            </form>
        </div>
		<br>
    </article>
</script>


			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>
