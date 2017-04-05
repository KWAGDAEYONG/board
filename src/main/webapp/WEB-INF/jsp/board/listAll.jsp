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
		<td><a href='/board/read?bno=${boardVO.bno}'>${boardVO.title}</a></td>
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
							<li><a href="/board/listAll?page=${page.startPage-1}">&laquo;</a>
						</c:if>
						
						<c:forEach begin="${page.startPage}" end="${page.endPage }" var="idx">
							<li 
								<c:out value="&{page.cri.page == idx? 'class = active ':''}"/>>
								<a href="/board/listAll?page=${idx}">${idx}</a>
							</li>
						</c:forEach>
						
						<c:if test="${page.next && page.endPage > 0 }">
							<li><a href="/board/listAll?page=${page.endPage+1}">&raquo;</a>
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


<%@include file="../include/footer.jsp"%>
