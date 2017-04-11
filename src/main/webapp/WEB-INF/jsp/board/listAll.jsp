<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL PAGE</h3>
				</div>
				<div class="box-body">
					<select name="searchType">
						<option value="n" <c:out value="${cri.searchType == null ? 'selected':''}" />>---</option>
						<option value="t" <c:out value="${cri.searchType eq 't' ? 'selected':''}" />>Title</option>
						<option value="c" <c:out value="${cri.searchType eq 'c' ? 'selected':''}" />>Content</option>
						<option value="w" <c:out value="${cri.searchType eq 'w' ? 'selected':''}" />>Writer</option>
						<option value="tc" <c:out value="${cri.searchType eq 'tc' ? 'selected':''}" />>Title OR Content</option>
						<option value="cw" <c:out value="${cri.searchType eq 'cw' ? 'selected':''}" />>Content OR Writer</option>
						<option value="tcw" <c:out value="${cri.searchType eq 'tcw' ? 'selected':''}" />>Title OR Content OR Writer</option>
					</select>
					
					<input type="text" name='keyword' id="keywordInput" value='${cri.keyword}'>
					<button id='searchBtn'>Search</button>
					<button id='newBtn'>New Board</button>
				
<table class="table table-bordered">
	<tr>
		<th style="width: 10px">BNO</th>
		<th>TITLE</th>
		<th>WRITER</th>
		<th>REGDATE</th>
		<th style="width: 40px">VIEWCNT</th>
	</tr>


<c:forEach items="${list}" var="boardVO">

	<tr>
		<td>${boardVO.bno}</td>
		<td><a href='/board/read?bno=${boardVO.bno}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'>${boardVO.title}</a></td>
		<td>${boardVO.writer}</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
				value="${boardVO.regdate}" /></td>
		<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
	</tr>

</c:forEach>

</table>

				</div>
				<!-- /.box-body -->
				<div class="text-center">
					<ul class="pagination">
						<c:if test="${page.prev}">
							<li><a href="/board/listAll?page=${page.startPage-1}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}">&laquo;</a>
						</c:if>
						
						<c:forEach begin="${page.startPage}" end="${page.endPage }" var="idx">
							<li 
								<c:out value="&{page.cri.page == idx? 'class = active ':''}"/>>
								<a href="/board/listAll?page=${idx}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}">${idx}</a>
							</li>
						</c:forEach>
						
						<c:if test="${page.next && page.endPage > 0 }">
							<li><a href="/board/listAll?page=${page.endPage+1}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}">&raquo;</a>
						</c:if>
					</ul>
				
				</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>
	$(document).ready(function(){
		$('#searchBtn').on(
			"click",
			function(event){
			self.location = "/board/listAll"
				+ "?page="+${cri.page}
				+ "&perPageNum="+${cri.perPageNum}
				+ "&searchType="+$("select option:selected").val()
				+ "&keyword="+$('#keywordInput').val();
			});
		$('#newBtn').on("click", function(evt){
			self.location="/board/listAll"
		});
	});		
</script>


<%@include file="../include/footer.jsp"%>
