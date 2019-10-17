package com.sofency.entries;

import java.util.ArrayList;

public class Page {
    private int currentPage;
    private int pageSize;
   
    private int totalCount;
   
    private int totalPage;
   
    private ArrayList<student>  students;
    
	public Page() {
		super();
	}

	public Page(int currentPage, int pageSize, int totalCount, int totalPage, ArrayList<student> students) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.students = students;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize= pageSize;
		this.totalPage = this.totalCount%this.pageSize ==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
	}
	
	
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public ArrayList<student> getStudents() {
		return students;
	}
	
	public void setStudents(ArrayList<student> students) {
		this.students = students;
	}
}
