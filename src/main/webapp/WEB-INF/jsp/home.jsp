<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@include file="include/header.jsp" %>
<a href="/board/register">글쓰기</a>-
<form Method="get" action="/board/listAll">
	<input type="hidden" name="page" value="1">
	<input type="hidden" name="perPageNum" value="10">
	<input type="hidden" name ="searchType" value="n">
	<input type="hidden" name ="keyword" value ="">
	<input type = "submit" value="게시판">
</form>
    <!-- Main content -->
    <section class="content">
      <div class="row">
      <!-- left column -->
      <div class="col-md-12">
        <!-- general form elements -->

					<div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">HOME PAGE</h3>
            </div>
          </div>
      </div><!--/.col (left) -->
      </div>   <!-- /.row -->
    </section><!-- /.content -->

    
<%@include file="include/footer.jsp" %>